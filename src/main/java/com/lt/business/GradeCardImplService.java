package com.lt.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.bean.GradeCard;
import com.lt.dao.GradeCardDAOImpl;
import com.lt.exception.GradeCardNotFoundException;

@Service
public class GradeCardImplService implements GradeCardInterface
{
	
private static volatile GradeCardImplService instance = null;
	
	List<GradeCard> gradeCard = new ArrayList<GradeCard>();
	GradeCardDAOImpl gradeCardDao = GradeCardDAOImpl.getInstance();
	
	private GradeCardImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static GradeCardImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(GradeCardImplService.class){
    instance = new GradeCardImplService();
    }
    }
    return instance;
    }
    
	@Override
	public List<GradeCard> viewGradeCard(int StudentId) throws GradeCardNotFoundException {
		return gradeCardDao.viewGradeCard(StudentId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printGradeCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void payFee() {
		// TODO Auto-generated method stub
		
	}

	

	
}