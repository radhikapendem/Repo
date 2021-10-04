package com.lt.exception;

/**
 *
 * @author G4-FullStackGroup
 * Implementations of PaymentNotSuccessfull
 *
 */
public class PaymentNotSuccessfull extends Exception {

	private String PatmentMode;

	public void PaymentNotSuccessfull(String PatmentMode) {
		this.PatmentMode = PatmentMode;
	}
	public String getCourseCode() {
		return PatmentMode;
	}
	public String getMessage() {
		return "PatmentMode: " + PatmentMode + " Payment is not done!";
	}

}