import java.util.List;

abstract class loggedIn {

	/*public boolean logout() {
		System.out.println("Peace out niggas");
		return true;
	}*/
	
	public abstract void deposit(int accountNumber, double depositAmount, List<String> acountsList);
	
	public abstract void withdraw(int accountNumber, double withdrawAmount);
	
	public abstract void transfer(int accountNumFrom, int accountNumTo, double depositAmount);
	
}
