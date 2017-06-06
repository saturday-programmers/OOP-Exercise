package vending;

public class Quantity {
	private int value;

	public Quantity(int value) {
		this.value = value;
	}

	public boolean isEmpty() {
		return (value == 0);
	}

	public void increase() {
		this.value++;
	}

	public void decrease() {
		this.value--;
	}

	public void decrease(Quantity quantity) {
		this.value -= quantity.value;
	}

	public boolean isLessThan(Quantity quantity) {
		return (this.value < quantity.value);
	}
}
