import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */
public class AtmState extends LoggedInState {

    public AtmState(ArrayList<String> transactions, ArrayList<String> validAccounts) {
        super(transactions, validAccounts);
    }

    /* So we just need to impliment a method for each transaction we can do
    * CheckList:
    *   withdrawal
    *   transfer
    *   Then the same in AgentState
    *
    */
    public int handleCommand(String line) {

        return 0;
    }


    // Implimentation with the values filled in
    public int deposit() {
        return deposit(0, 10000);
    }


}
