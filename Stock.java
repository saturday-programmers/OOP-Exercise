package vending;

public class Stock {
    private static Quantity quantityOfTea = new Quantity(5); // お茶の在庫数

    public static boolean pop(Drink.KindOfDrink kindOfDrink) {
		Quantity quantity;
		quantity = quantityOfTea;
        if (kindOfDrink == Drink.KindOfDrink.COKE || kindOfDrink == Drink.KindOfDrink.DIET_COKE) {
			quantity = CokeStock.getQuantity(kindOfDrink);
        }

        if (quantity.isEmpty()) {
            return false;
        }

        quantity.decrease();
        return true;
    }

	private static class CokeStock {
		private static Quantity quantityOfCoke = new Quantity(5); // コーラの在庫数
		private static Quantity quantityOfDietCoke = new Quantity(5); // ダイエットコーラの在庫数

		public static Quantity getQuantity(Drink.KindOfDrink kindOfDrink) {
			if (kindOfDrink == Drink.KindOfDrink.COKE) {
				return quantityOfCoke;
			}
			return quantityOfDietCoke;
		}
	}
}
