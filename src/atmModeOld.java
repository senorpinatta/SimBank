import java.text.MessageFormat;
import java.util.List;

public class atmModeOld extends loggedIn {

	@Override
	public void deposit(int accountNumber, double depositAmount, List<String> accountsList) {
		if (depositAmount > 1000) {
			System.out.print("Cannot deposit amounts greater than $1000.00\n");
		}
		else if (!accountsList.contains(Integer.toString(accountNumber))) {
			System.out.print("Invalid account number specified\n");
		}
		else {
			System.out.format("$%d was deposited in to account number %d\n", accountNumber, depositAmount);
		}
	}

	@Override
	public void withdraw(int accountNumber, double withdrawAmount) {
		System.out.println(MessageFormat.format("${0} was withdrawn in to account number {1}\n", accountNumber, withdrawAmount));
		
	}

	@Override
	public void transfer(int accountNumInitial, int accountNumNew, double depositAmount) {
		System.out.println(MessageFormat.format("${0} was transfered from account number {1} to account number {2}", accountNumInitial, accountNumNew, depositAmount));
		
	}

}
