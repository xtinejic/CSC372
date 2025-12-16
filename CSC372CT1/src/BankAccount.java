public class BankAccount {
	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;
	
public BankAccount() {
	this.balance = 0.0;
}

public void deposit(double amount) {
	if (amount > 0) {
		balance += amount;
		System.out.println();
	} else {
		System.out.println("Deposit amount must be positive.");
	}
}

public void withdrawal(double amount) {
	if (amount > 0) {
		if (amount <= balance) {
			balance = amount;
			System.out.printf("Withdrew: $%.2f. New Balance: $%.2f%n", amount, balance);
		} else { 
			System.out.println("Withdrawal amount must be positive.");	
		} 	
	}
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public int getAccountID() {
	return accountID;
}

public void setAccountID(int accountID) {
	this.accountID = accountID;
}

public double getBalance() {
	return balance;
}

public void accountSummary() {
	System.out.println("\n=== Account Summary ===");
	System.out.println("Account Holder: " + firstName + " " + lastName);
	System.out.println("AccountID: " + accountID);
	System.out.println("Current Balance: $%.2f%n");
}
	}


