package vending;

public class Change {
    Money charge = new Money(0); // ���ނ�

	public void increase(Money money) {
		this.charge.increase(money);
	}

    public Money calc(Money inputMoney, Money price) {
		Money ret = price.calcChange(inputMoney);
		this.charge.increase(ret);
		return ret;
    }

    /**
     * ���ނ�����o��.
     *
     * @return ���ނ�̋��z
     */
    public Money refund() {
        Money result = new Money(this.charge);
        this.charge.clear();
        return result;
    }
}
