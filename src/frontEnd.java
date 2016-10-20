/**
 * Created by benji on 10/18/2016.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// This class controls the front end for the SimBank Program
public class frontEnd {
    CommandManager commMan;
    private ArrayList<String> validAccounts;
    private ArrayList<String> masterTransactions;
    private ArrayList<String> temporaryTransactions;

    public frontEnd() {
        commMan = new LoggedOutState(temporaryTransactions);
        validAccounts = null;
        masterTransactions  = new ArrayList<>();
        temporaryTransactions = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        String line;
        // holdes the result of handleCommand(line)
        // 0 -> no change in state, 1 -> change to  LoggedIn, 2 -> change to AtmState, 3 -> change to AgentState, 4 -> change to LoggendOutState
        int stateIndex;
        // Infinite loop. We don't want the front end to stop accepting input;
        while(true) {
            line = keyboard.nextLine();
            stateIndex = commMan.handleCommand(line);
            updateCommMan(stateIndex);
        }
    }

    private void updateCommMan(int stateIndex) {
        if (stateIndex == 1) { // we have logged in reads in accounts file
            validAccounts = getAccountsList("AccountsFile.txt");
            commMan = new LoggedInState(temporaryTransactions, validAccounts, masterTransactions);
        }
        if (stateIndex == 2)
            commMan = new AtmState(temporaryTransactions, validAccounts, masterTransactions);
        if (stateIndex == 3)
            commMan = new AgentState(temporaryTransactions, validAccounts, masterTransactions);
        if (stateIndex == 4) { // We must have logged out to get here so the users session must be over
            // we write the temporaryTransactions ArrayList to the
            masterTransactions.addAll(temporaryTransactions);
            // clear temporaryTransactions
            temporaryTransactions = new ArrayList<>();
            commMan = new LoggedOutState(masterTransactions);
        }
    }

    private static ArrayList<String> getAccountsList(String fileName) {
        String line = null;
        ArrayList<String> accountsList = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                accountsList.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        return accountsList;
    }
}
