package com.lt.business;

import org.springframework.stereotype.Service;

@Service
public class CatlogImplService implements CatlogInterface {

	private static volatile CatlogImplService instance = null;
	/**
	 * Default Constructor
	 * @return values
	 */
	private CatlogImplService()
    {
    }
    /**
    * Method to make CatlogImplService Singleton
    * @return
    */
    public static CatlogImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(CatlogImplService.class){
    instance = new CatlogImplService();
    }
    }
    return instance;
    }
    
	@Override
	public String getCourseId() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCourseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCourseId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCourseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
