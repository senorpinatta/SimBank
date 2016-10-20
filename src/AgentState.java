import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by benji on 10/18/2016.
 */
public class AgentState extends LoggedInState {

	private static final int UPPER = 99999999;
	private static final int LOWER = 0;
	
    public AgentState(ArrayList<String> transactions, ArrayList<String> validAccounts, ArrayList<String> masterTransactions) {
        super(transactions, validAccounts, masterTransactions);
    }


    /*
    * So we need to add function definitions for:
    *   withdrawal
    *   transfer
    *   create
    *   delete
    *   and the handleCommand call like the one or deposit
    */
    @Override
    public int handleCommand(String line) {
        int stateIndex = 0;
        if(line.equals("deposit"))
            // double check these bounds
            stateIndex = deposit(0, 10000000);
        if(line.equals("withdraw"))
            // double check these bounds
            stateIndex = withdraw(0, 10000000);
        if(line.equals("transfer"))
            // double check these bounds
            stateIndex = transfer(0, 10000000);
        if(line.equals("create"))
            // double check these bounds
            stateIndex = create();
        if(line.equals("delete"))
            // double check these bounds
            stateIndex = delete();


        return stateIndex;
    }

    public int deposit() {
        return deposit(LOWER, UPPER);
    }
    
    public int withdraw() {
    	return withdraw(LOWER, UPPER);
    }

    public int transfer() {
    	return transfer(LOWER, UPPER);
    }
    
    public int create() {
    	Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        String line;
        int accountNumber = 0;
        String name = null;
        while (flag) {
            try {
            	System.out.println("Enter the account Number: ");
        		line = keyboard.nextLine();
        		if (!accountCheck(line)) {
        			accountNumber = Integer.parseInt(line);
        		}
        		else {
        			System.out.println("Error");
        			return 0;
        		} 
                line = keyboard.nextLine();
                if ((line.length() > 30 || line.length() < 3) && line.matches("[A-Za-z0-9]+")) {
                	name = line;
                }
                else {
        			System.out.println("Error");
        			return 0;
        		} 
                flag = false;
            } catch (NumberFormatException e) {
                // do nothing one of the inputs was bad
            }
        }
        transactions.add(String.format("CR %d 00000000 000 %s", accountNumber, name));
    	return 0;
    }
    
    public int delete() {
    	Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        String line;
        int accountNumber = 0;
        String name = null;
        while (flag) {
            try {
            	System.out.println("Enter the account Number: ");
        		line = keyboard.nextLine();
        		if (accountCheck(line)) {
        			accountNumber = Integer.parseInt(line);
        		}
        		else {
        			System.out.println("Error");
        			return 0;
        		} 
                line = keyboard.nextLine();
                if ((line.length() > 30 || line.length() < 3) && line.matches("[A-Za-z0-9]+")) {
                	name = line;
                }
                else {
        			System.out.println("Error");
        			return 0;
        		} 
                flag = false;
            } catch (NumberFormatException e) {
                // do nothing one of the inputs was bad
            }
        }
        transactions.add(String.format("DL %d 00000000 000 %s", accountNumber, name));
    	return 0;
    }
}
