package vending;

public class VendingMachine {
    Quantity numberOf100Yen = new Quantity(10); // 100�~�ʂ̍݌�
    Change charge = new Change(); // ���ނ�

    /**
     * �W���[�X���w������.
     *
     * @param i           �������z. 100�~��500�~�̂ݎ󂯕t����.
     * @param kindOfDrink �W���[�X�̎��.
     *                    �R�[��({@code Juice.COKE}),�_�C�G�b�g�R�[��({@code Juice.DIET_COKE},����({@code Juice.TEA})���w��ł���.
     * @return �w�肵���W���[�X. �݌ɕs����ނ�K�s���Ŕ����Ȃ������ꍇ�� {@code null} ���Ԃ����.
     */
    public Drink buy(Money i, Drink.KindOfDrink kindOfDrink) {
		boolean canBuy = false;
        // 100�~��500�~�����󂯕t����
        canBuy = (i.is100() || i.is500());

        // �ނ�K�s��
        canBuy = canBuy && !(i.is500() && numberOf100Yen.isLessThan(new Quantity(4)));

		canBuy = canBuy && Stock.pop(kindOfDrink);
		if (!canBuy) {
			this.charge.increase(i);
			return null;
		}

        if (i.is100()) {
            // 100�~�ʂ�ނ�K�Ɏg����
            numberOf100Yen.increase();
        }
		if (i.is500()) {
            // 400�~�̂��ނ�
            Money currentCharge = this.charge.calc(i, new Money(100));
            // 100�~�ʂ�ނ�K�Ɏg����
            numberOf100Yen.decrease(currentCharge.calcAmountOf100YenCoin());
        }
        return new Drink(kindOfDrink);
    }

	/**
	 * ���ނ�����o��.
	 *
	 * @return ���ނ�̋��z
	 */
	public Money refund() {
		return this.charge.refund();
	}
}
