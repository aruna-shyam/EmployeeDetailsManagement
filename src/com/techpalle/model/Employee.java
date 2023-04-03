package com.techpalle.model;

public class Employee 
{
	private int eid;
	private String ename;
	private String egender;
	private String edob;
	private String edesignation;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEgender() {
		return egender;
	}
	public void setEgender(String egender) {
		this.egender = egender;
	}
	public String getEdob() {
		return edob;
	}
	public void setEdob(String edob) {
		this.edob = edob;
	}
	public String getEdesignation() {
		return edesignation;
	}
	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}
	
	
	public Employee(int eid, String ename, String egender, String edob, String edesignation) 
	{
		super();
		this.eid = eid;
		this.ename = ename;
		this.egender = egender;
		this.edob = edob;
		this.edesignation = edesignation;
	}
	
	
	public Employee(String ename, String egender, String edob, String edesignation) 
	{
		super();
		this.ename = ename;
		this.egender = egender;
		this.edob = edob;
		this.edesignation = edesignation;
	}
	
	
}
