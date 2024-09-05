package com.hibernate.entity;

//Create the Interface for performing the lazy operation on final class
public interface IProduct {
	public Integer getLockerId();
	public String getLockerName();
	public String getLockerPass();
	public String getPerson();
	
	public void setLockerId(Integer lockerId);
	public void setLockerName(String lockerName);
	public void setLockerPass(String LockerPass);
	public void setPerson(String password);
	
}
