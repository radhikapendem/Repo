package com.lt.constants;



public enum PaymentMode {
	CREDIT_CARD,NET_BANKING,DEBIT_CARD;

	/**
	 * Method to get Mode of Payment
	 * @param value
	 * @return Mode of Payment
	 */
	public static PaymentMode getModeofPayment(int value)
	{
		switch(value)
		{
		case 1:
			return PaymentMode.CREDIT_CARD;
		case 2:
			return PaymentMode.NET_BANKING;
		case 3:
			return PaymentMode.DEBIT_CARD;
		default:
			return null;

		}

	}


}
