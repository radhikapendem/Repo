package com.lt.business;

import com.lt.exception.PaymentNotSuccessfull;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of Payment Services 
 * 
 */
public interface PaymentInterface {

	
	/**
	 * Method to get Payment
	 *  @param studentId,fee
	 */
	public void getPayment(int studentId, double fee);//mode,scanner
	/**
	 * Method to online
	 * @param studentId,fee
	 */
	public void online(int studentId, double fee);
	/**
	 * Method to offline
	 * 
	 */
	public void offline();
	/**
	 * Method to calculateFee
	 * @throws PaymentNotSuccessfull 
	 * 
	 */
	public double calculateFee(int studentId) throws PaymentNotSuccessfull;

}

