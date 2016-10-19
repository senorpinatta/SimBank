import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */
public class AgentState extends LoggedInState {

    public AgentState(ArrayList<String> transactions, ArrayList<String> validAccounts) {
        super(transactions, validAccounts);
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
            stateIndex = deposite(0, 10000000);


        return stateIndex;
    }


}
