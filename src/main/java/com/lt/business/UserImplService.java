package com.lt.business;

import org.springframework.stereotype.Service;

import com.lt.dao.UserDAOImpl;

@Service
public class UserImplService implements UserInterface
{

	UserDAOImpl userDAOImpl=UserDAOImpl.getInstance();

private static volatile UserImplService instance = null;
	
	private UserImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static UserImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(UserImplService.class){
    instance = new UserImplService();
    }
    }
    return instance;
    }

    
	@Override
	public boolean login(String username, String password) throws Exception
	{
		return userDAOImpl.verifyCredential(username, password);
	}

	@Override
	public String viewRole() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getRole(String userId) throws Exception {
		return userDAOImpl.getRole(userId);
	}

	@Override
	public boolean updatePassword(String username, String newPassword) 
	{
		return userDAOImpl.updateUserPassword(username, newPassword);
	}


}
