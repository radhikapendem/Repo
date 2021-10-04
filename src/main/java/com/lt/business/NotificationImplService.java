package com.lt.business;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lt.constants.PaymentMode;
import com.lt.dao.PaymentDAOImpl;
import com.lt.dao.PaymentDAOInterface;
@Service
public class NotificationImplService implements NotificationInterface
{
	
	private static Logger logger = Logger.getLogger(CourseImplService.class);
	PaymentDAOInterface daoPayment = PaymentDAOImpl.getInstance();
	
	private static volatile NotificationImplService instance = null;
	
	private NotificationImplService()
    {
    }
    
    public static NotificationImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(NotificationImplService.class){
    instance = new NotificationImplService();
    }
    }
    return instance;
    }
    
	@Override
	public String getNotify() 
	{
		return  "Payment Successful";
	}

	@Override
	public boolean sendNotification(int studentId, PaymentMode mode, double fee) {
		if(daoPayment.payment(studentId, mode, fee)) {
			return true;
		}
		return false;
		
	}

}
