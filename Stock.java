package vending;

public class Stock {
    private static Quantity quantityOfTea = new Quantity(5); // �����̍݌ɐ�

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
		private static Quantity quantityOfCoke = new Quantity(5); // �R�[���̍݌ɐ�
		private static Quantity quantityOfDietCoke = new Quantity(5); // �_�C�G�b�g�R�[���̍݌ɐ�

		public static Quantity getQuantity(Drink.KindOfDrink kindOfDrink) {
			if (kindOfDrink == Drink.KindOfDrink.COKE) {
				return quantityOfCoke;
			}
			return quantityOfDietCoke;
		}
	}
}
