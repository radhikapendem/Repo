package com.lt.business;

import org.springframework.stereotype.Service;

@Service
public class GradesImplService implements GradesInterface {

private static volatile GradesImplService instance = null;
	
	private GradesImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static GradesImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(GradesImplService.class){
    instance = new GradesImplService();
    }
    }
    return instance;
    }

    
	@Override
	public String submitGrades() {
		// TODO Auto-generated method stub
		return null;
	}

}
