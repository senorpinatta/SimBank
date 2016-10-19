import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */
public class LoggedInState extends CommandManager {
    private ArrayList<String> validAccounts;


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
}
