package com.lt.dao;

import com.lt.constants.PaymentMode;

public interface PaymentDAOInterface {

	double calculateFee(int studentId);

	boolean payment(int studentId, PaymentMode mode, double fee);

	String paymentStatus(int studentId);

}
