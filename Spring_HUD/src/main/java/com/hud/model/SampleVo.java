package com.hud.model;

public class SampleVo {
 private String firstName;
 private String lastName;
 private int mno;
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
public int getMno() {
	return mno;
}
public void setMno(int mno) {
	this.mno = mno;
}
@Override
public String toString() {
	return "SampleVo [firstName=" + firstName + ", lastName=" + lastName + ", mno=" + mno + "]";
}
 
 
}
