import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by benji on 10/18/2016.
 */
public class LoggedOutState extends CommandManager {

    // Default Constructor for the LoggedOutState Class
    public LoggedOutState(ArrayList<String> transactions) {
        super(transactions);
    }

    // there is only 1 accepted input when from the LoggedOutState login which logs the user in
    public int handleCommand(String line) {
        // 1 informs the FrontEnd to change to a LoggedInState
        if (line.trim().equals("login")) {
            return 1;
        }
        // Does not change State
        else
            return 0;
    }

}
