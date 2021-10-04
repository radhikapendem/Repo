package com.lt.business;

import com.lt.constants.PaymentMode;

public interface NotificationInterface {

	/**
	    * Method to getNotify
	    * 
	    */
	public String getNotify();
	/**
	    * Method to make AdminOperation Singleton
	    * @param studentId,PaymentMode,fee.
	    */
	public boolean sendNotification(int studentId, PaymentMode mode, double fee);
	
}