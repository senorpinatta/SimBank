import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */

// parent class for the all the States
public abstract class CommandManager {
    protected ArrayList<String> transactions;

    // Default Constructor for the CommandManagerClass
    public CommandManager(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    // This method performs the required functionality based on which state object it is.
    // It returns an integer code which refers to which state it should be changed to
    public abstract int handleCommand(String line);

}
