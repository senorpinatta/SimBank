import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by benji on 10/18/2016.
 */
public class LoggedInState extends CommandManager {
    protected ArrayList<String> validAccounts;


    public LoggedInState(ArrayList<String> transactions, ArrayList<String> validAccounts) {
        super(transactions);
        this.validAccounts = validAccounts;

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
    private boolean accountCheck(String accountNumer) {
        for (String validAccount : validAccounts)
            if(validAccount.equals(accountNumer))
                return true;
        return // we know none of the accounts match the one we entered so we reject the attempt
                false;
    }

    // Deposite Command Example for how we should do it its in this class because both
    // AtmState and AgentState use it see AtmState for what we do in that class
    protected int deposit(int lowerBound, int upperBound) {
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        String line;
        int accountNumber = 0;
        int amount = 0;
        while (flag) {
            try {
                line = keyboard.nextLine();
                accountNumber = Integer.parseInt(line);
                line = keyboard.nextLine();
                amount = Integer.parseInt(line);
                flag = false;
            } catch (NumberFormatException e) {
                // do nothing one of the inputs was bad
            }

        }
        transactions.add(String.format("DE %d 000 %d ***", accountNumber, amount));
        return 0;
    }
}
