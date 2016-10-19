import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */
public class AtmState extends LoggedInState {

    public AtmState(ArrayList<String> transactions, ArrayList<String> validAccounts) {
        super(transactions, validAccounts);
    }

    public int handleCommand(String line) {
        return 0;
    }
}
