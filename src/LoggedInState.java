import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by benji on 10/18/2016.
 */
public class LoggedInState extends CommandManager {
    protected ArrayList<String> validAccounts;

    private ArrayList<String> mastTrans;
    
    public LoggedInState(ArrayList<String> transactions, ArrayList<String> validAccounts, ArrayList<String> masterTransactions) {
        super(transactions);
        this.validAccounts = validAccounts;
        mastTrans = masterTransactions;

    }

    public int handleCommand(String line) {
        if (line.trim().equals("atm"))
            return 2;
        else
            if (line.trim().equals("agent"))
                return 3;
            else
                return 0;
    }


    // Checks through the list of valid accounts to see if any match the supplied account number
    protected boolean accountCheck(String accountNumber) {
        for (String validAccount : validAccounts)
            if(validAccount.equals(accountNumber))
                return true;
        return false;// we know none of the accounts match the one we entered so we reject the attempt
    }

    // Deposite Command Example for how we should do it its in this class because both
    // AtmState and AgentState use it see AtmState for what we do in that class
    protected int deposit(int lowerBound, int upperBound) {
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        String line;
        int total = 0;
        int accountNumber = 0;
        int amount = 0;
        try {
        	System.out.println("Enter the account Number: ");
    		line = keyboard.nextLine();
    		if (accountCheck(line)) {
    			flag = false;
    			accountNumber = Integer.parseInt(line);
    		}
    		else {
    			System.out.println("Error");
    			return 0;
    		}
    		System.out.println("Enter the amount:");
    		line = keyboard.nextLine();
    		amount = Integer.parseInt(line);
    		total = transactionSum(String.format("%d", accountNumber), "DE", upperBound) + amount;
    		if (total < lowerBound || total > upperBound) {
    			System.out.printf("total ammount is not in [%d, %d]\n", lowerBound, upperBound);
        		return 0;
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Error");
        	return 0;
        }
        transactions.add(String.format("DE %d 00000000 000 %d ***", accountNumber, amount));
        return 0;
    }
    
    protected int withdraw(int lowerBound, int upperBound) {
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        String line;
        int total = 0;
        int accountNumber = 0;
        int amount = 0;
        try {
        	System.out.println("Enter the account Number: ");
    		line = keyboard.nextLine();
    		if (accountCheck(line)) {
    			flag = false;
    			accountNumber = Integer.parseInt(line);
    		}
    		else {
    			System.out.println("Error");
    			return 0;
    		}
    		System.out.println("Enter the amount:");
    		line = keyboard.nextLine();
    		amount = Integer.parseInt(line);
    		total = transactionSum(String.format("%d", accountNumber), "WD", upperBound) + amount;
    		if (total < lowerBound || total > upperBound) {
    			System.out.printf("total ammount is not in [%d, %d]\n", lowerBound, upperBound);
        		return 0;
        	}
        } catch (NumberFormatException e) {
        	System.out.println("Error");
        	return 0;
        }
        transactions.add(String.format("WD %d 00000000 000 %d ***", accountNumber, amount));
        return 0;
    }
    
    protected int transfer(int lowerBound, int upperBound) {
    	Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        String line;
        int total = 0;
        int accountNumberFrom = 0;
        int accountNumberTo = 0;
        int amount = 0;
        try {
        	System.out.println("Enter the account Number to withdraw from: ");
    		line = keyboard.nextLine();
    		if (accountCheck(line)) {
    			flag = false;
    			accountNumberFrom = Integer.parseInt(line);
    		}
    		else {
    			System.out.println("Error");
    			return 0;
    		}
    		
    		System.out.println("Enter the account Number to deposit to: ");
    		line = keyboard.nextLine();
    		if (accountCheck(line)) {
    			flag = false;
    			accountNumberTo = Integer.parseInt(line);
    		}
    		else {
    			System.out.println("Error");
    			return 0;
    		}
    		
    		System.out.println("Enter the amount:");
    		line = keyboard.nextLine();
    		amount = Integer.parseInt(line);
    		
    		total = transactionSum(String.format("%d", accountNumberFrom), "WD", upperBound) + amount;
    		if (total < lowerBound || total > upperBound) {
    			System.out.printf("total ammount is not in [%d, %d]\n", lowerBound, upperBound);
        		return 0;
        	}
    		
    		total = transactionSum(String.format("%d", accountNumberTo), "DE", upperBound) + amount;
    		if (total < lowerBound || total > upperBound) {
    			System.out.printf("total ammount is not in [%d, %d]\n", lowerBound, upperBound);
        		return 0;
        	}
    		
        } catch (NumberFormatException e) {
        	System.out.println("Error");
        	return 0;
        }
        transactions.add(String.format("TR %d %d %d ***", accountNumberFrom, accountNumberTo, amount));
        return 0;
    }

    private int sumList(ArrayList<String> trans, String accNum, String transType) {
    	int sum = 0;
    	String[] parts;
    	for (String line :  trans) {
    		parts = line.split(" ");
    		if (accNum.equals(parts[1]) && transType.equals(parts[0]))
    			sum += Integer.parseInt(parts[3]);
    	}
    	return sum;
    }
    
    private int transactionSum(String accNum, String transType, int upperBound) {
    	int sum = 0;
    	if (upperBound == 99999999)
    		return 0;
    	else {
    		sum += sumList(transactions, accNum, transType);
    		sum += sumList(mastTrans, accNum, transType);
    	}
		return sum;
    	
    }
    	
}
