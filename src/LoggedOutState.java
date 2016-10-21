import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */
public class LoggedOutState extends CommandManager {
   
	//Default Constructor for the LoggedOutState Class
    public LoggedOutState(ArrayList<String> transactions) {
        super(transactions);
    }

    //"Handles" user input. The only accepted input when in this object is the login method.
    //If user inputs anything else, 0 is returned.
    public int handleCommand(String line) {
        // 1 informs the FrontEnd to change to a LoggedInState
        if (line.equals("login"))
            return 1;
        if (line.equals("Terminate"))
            return -1; // Breaks the loop in frontEnd
        else {
            System.out.println("Error");
            return 0; // Does not change State
        }



    }

}
