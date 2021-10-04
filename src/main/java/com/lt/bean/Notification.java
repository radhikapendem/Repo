package com.lt.bean;

import com.lt.constants.NotificationType;

public class Notification {
	private int notificationId;
	private int studentId;
	private NotificationType type;
	private String referenceId;
	
	/**
	 * Parameterized constructor
	 * @param notificationId
	 * @param studentId
	 * @param type
	 * @param referenceId
	 */
	public Notification(int notificationId,int studentId, NotificationType type,String referenceId)
	{
		this.notificationId = notificationId;
		this.studentId = studentId;
		this.type = type;
		this.referenceId = referenceId;
	}
	
	/**
	 * Method to get Notification Id
	 * @return Notification Id
	 */
	public int getNotificationId() {
		return notificationId;
	}
	
	/**
	 * Method to get Student Id of student enrolled in the course
	 * @return Student Id
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Method to set Student Id of student enrolled in the course
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Method to get Notification Type
	 * @return Notification Type
	 */
	public NotificationType getType() {
		return type;
	}
	
	/** 
	 * Method to set Notification Type
	 * @param type
	 */
	public void setType(NotificationType type) {
		this.type = type;
	}

	/**
	 * Method to get Reference Id
	 * @return Reference Id
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * Method to set Reference Id
	 * @param referenceId
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", studentId=" + studentId + ", type=" + type
				+ ", referenceId=" + referenceId + "]";
	}
	
	
}
	
	
	