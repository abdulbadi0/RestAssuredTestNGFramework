package program101;

public class CreditCardAccount {
	long cardNumber;
	String name;
	double outstanding;
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getOutstanding() {
		return outstanding;
	}
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	public CreditCardAccount(long cardNumber, String name, double outstanding) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.outstanding = outstanding;
	}
	@Override
	public String toString() {
		return "CreditCardAccount [cardNumber=" + cardNumber + ", name=" + name + ", outstanding=" + outstanding + "]";
	}
	

}
