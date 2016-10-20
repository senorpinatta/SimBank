import java.util.ArrayList;

/**
 * Created by benji on 10/18/2016.
 */
public class AtmState extends LoggedInState {
	
	private static final int UPPER = 100000;
	private static final int LOWER = 0;
	
	
    public AtmState(ArrayList<String> transactions, ArrayList<String> validAccounts, ArrayList<String> masterTransactions) {
        super(transactions, validAccounts, masterTransactions);
    }

    /* So we just need to impliment a method for each transaction we can do
    * CheckList:
    *   withdrawal
    *   transfer
    *   Then the same in AgentState
    *
    */
    public int handleCommand(String line) {
    	int stateIndex = 0;
        if(line.equals("deposit"))
            // double check these bounds
            stateIndex = deposit(0, UPPER);
        if(line.equals("withdraw"))
            // double check these bounds
            stateIndex = deposit(0, UPPER);
        if(line.equals("transfer"))
            // double check these bounds
            stateIndex = deposit(0, UPPER);

        return stateIndex;
    }


    // Implimentation with the values filled in
    public int deposit() {
        return deposit(LOWER, UPPER);
    }
    
    public int withdraw() {
    	return withdraw(LOWER, UPPER);
    }
    
    public int transfer() {
    	return transfer(LOWER, UPPER);
    }
}
