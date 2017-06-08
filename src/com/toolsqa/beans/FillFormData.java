package com.toolsqa.beans;

public class FillFormData {
	
	private String firstName;
	private String lastName;
	private String pickDate;
	private int testID;
	
	FillFormData(){
		
	}
	
	public FillFormData(String firstname,String lastname,String pickdate,int testid){
		this.firstName=firstname;
		this.lastName=lastname;
		this.pickDate=pickdate;
		this.testID=testid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPickDate() {
		return pickDate;
	}
	public void setPickDate(String pickDate) {
		this.pickDate = pickDate;
	}
	public int getTestID() {
		return testID;
	}
	public void setTestID(int testID) {
		this.testID = testID;
	}
	
}
