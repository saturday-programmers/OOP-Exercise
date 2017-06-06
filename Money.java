package vending;

public class Money {
	private int value;

	public Money(int value) {
		this.value = value;
	}

	public Money(Money money) {
		this.value = money.value;
	}

	public void clear() {
		this.value = 0;
	}

	public void decrease(Money money) {
		this.value -= money.value;
	}

	public void increase(Money money) {
		this.value += money.value;
	}

	public boolean is100() {
		return (this.value == 100);
	}

	public boolean is500() {
		return (this.value == 500);
	}

	public Money calcChange(Money payment) {
		return new Money(payment.value - this.value);
	}

	public Quantity calcAmountOf100YenCoin() {
		return new Quantity(this.value / 100);
	}
}
