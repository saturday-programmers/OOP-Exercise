package vending;

public class VendingMachine {
    Quantity numberOf100Yen = new Quantity(10); // 100円玉の在庫
    Change charge = new Change(); // お釣り

    /**
     * ジュースを購入する.
     *
     * @param i           投入金額. 100円と500円のみ受け付ける.
     * @param kindOfDrink ジュースの種類.
     *                    コーラ({@code Juice.COKE}),ダイエットコーラ({@code Juice.DIET_COKE},お茶({@code Juice.TEA})が指定できる.
     * @return 指定したジュース. 在庫不足や釣り銭不足で買えなかった場合は {@code null} が返される.
     */
    public Drink buy(Money i, Drink.KindOfDrink kindOfDrink) {
		boolean canBuy = false;
        // 100円と500円だけ受け付ける
        canBuy = (i.is100() || i.is500());

        // 釣り銭不足
        canBuy = canBuy && !(i.is500() && numberOf100Yen.isLessThan(new Quantity(4)));

		canBuy = canBuy && Stock.pop(kindOfDrink);
		if (!canBuy) {
			this.charge.increase(i);
			return null;
		}

        if (i.is100()) {
            // 100円玉を釣り銭に使える
            numberOf100Yen.increase();
        }
		if (i.is500()) {
            // 400円のお釣り
            Money currentCharge = this.charge.calc(i, new Money(100));
            // 100円玉を釣り銭に使える
            numberOf100Yen.decrease(currentCharge.calcAmountOf100YenCoin());
        }
        return new Drink(kindOfDrink);
    }

	/**
	 * お釣りを取り出す.
	 *
	 * @return お釣りの金額
	 */
	public Money refund() {
		return this.charge.refund();
	}
}
