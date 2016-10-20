import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class frontEndOld {

	private static List<String> getAccountsList() {

		String fileName = "AccountsFile.txt";
        String line = null;
        List<String> accountsList = new ArrayList<String>();

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

	private static void loggedInOperations(loggedIn permissionLevel, List<String> accountsArray) {
		Scanner keyboard = new Scanner(System.in);
		
		boolean loggedOut = false;
		int actionCounter = 0;
		
		while (loggedOut != true) {
			if (actionCounter == 0) {
				System.out.println("How can SimBank help you today?");
			}
			else {
				System.out.println("What else can SimBank help you with today?");
			}
			String userAction = keyboard.next();
			if (userAction.equalsIgnoreCase("deposit")) {
				System.out.println("Please enter account number to deposit to");
				int accountNumber = keyboard.nextInt();
				System.out.println("Please enter amount to deposit");
				int depositAmount = keyboard.nextInt();
				permissionLevel.deposit(accountNumber, depositAmount, accountsArray);
			}
			else if (userAction.equalsIgnoreCase("logout")) {
				loggedOut = true;
				System.out.println("Peace out niggas");
			}
			actionCounter++;
		}
	}

	public static void main(String[] args) 	{
		System.out.println("Starting SimBank\nPlease select login type:\natm\tagent");
		Scanner keyboard = new Scanner(System.in);
		String typeOfUser = keyboard.next();
		
		loggedIn permissionLevel;
		
		if (typeOfUser.equalsIgnoreCase("atm")) {
			permissionLevel = new atmModeOld();
		}
		else {
			permissionLevel = new tellerMode();
		}
		
		System.out.println("Logged in as " + typeOfUser);
		
		List<String> accountsArray = getAccountsList();
		
		loggedInOperations(permissionLevel, accountsArray);
		}
}
