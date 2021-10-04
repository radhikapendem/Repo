package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * Professor Class
 * 
 */
public class Professor {
    private int ProfessorId;
    private String ProfessorName;
    private String Department;
    private String ProfessorAddress;
    private String username;
    private String password;
    
    public Professor(String professorName, String department, String professorAddress, String username,
            String password) {
        super();
        ProfessorName = professorName;
        Department = department;
        ProfessorAddress = professorAddress;
        this.username = username;
        this.password = password;
    }

 


    public Professor(String professorName, String department, String professorAddress) {
        ProfessorName = professorName;
        Department = department;
        ProfessorAddress = professorAddress;
    }
    
    
    public Professor() {
        super();
    }

 


    /**
     * Method to get ProfessorId
     * @param getProfessorId
     */
    public int getProfessorId() {
        return ProfessorId;
    }
    /**
     * Method to set ProfessorId
     * @param setProfessorId
     */
    public void setProfessorId(int professorId) {
        ProfessorId = professorId;
    }
    /**
     * Method to get ProfessorName
     * @param getProfessorName
     */
    public String getProfessorName() {
        return ProfessorName;
    }
    /**
     * Method to set ProfessorName
     * @param setProfessorName
     */
    public void setProfessorName(String professorName) {
        ProfessorName = professorName;
    }
    
    /**
     * Method to get ProfessorEmailId
     * @param getProfessorEmailId
     */
    public String getDepartment() {
        return Department;
    }
    
    /**
     * Method to set ProfessorEmailId
     * @param setProfessorEmailId
     */
    public void setDepartment(String department) {
        Department = department;
    }
    /**
     * Method to get ProfessorAddress
     * @param getProfessorAddress
     */
    public String getProfessorAddress() {
        return ProfessorAddress;
    }
    /**
     * Method to set ProfessorAddress
     * @param setProfessorAddress
     */
    public void setProfessorAddress(String professorAddress) {
        ProfessorAddress = professorAddress;
    }
    public String getUsername() {
        return username;
    }

 


    public void setUsername(String username) {
        this.username = username;
    }

 


    public String getPassword() {
        return password;
    }

 


    public void setPassword(String password) {
        this.password = password;
    }

 


    @Override
    public String toString() {
        return "Professor [ProfessorId=" + ProfessorId + ", ProfessorName=" + ProfessorName + ", Department="
                + Department + ", ProfessorAddress=" + ProfessorAddress + "]";
    }
    

 

} 