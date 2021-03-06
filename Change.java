package vending;

public class Change {
    Money charge = new Money(0); // お釣り

	public void increase(Money money) {
		this.charge.increase(money);
	}

    public Money calc(Money inputMoney, Money price) {
		Money ret = price.calcChange(inputMoney);
		this.charge.increase(ret);
		return ret;
    }

    /**
     * お釣りを取り出す.
     *
     * @return お釣りの金額
     */
    public Money refund() {
        Money result = new Money(this.charge);
        this.charge.clear();
        return result;
    }
}
