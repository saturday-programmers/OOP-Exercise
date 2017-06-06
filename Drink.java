package vending;

public class Drink {
	public enum KindOfDrink {
		COKE,
		DIET_COKE,
		TEA
	}

	private KindOfDrink kindOfDrink;

	public Drink(KindOfDrink kindOfDrink) {
		this.kindOfDrink = kindOfDrink;
	}
}

