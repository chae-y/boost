package kr.or.connect.JDBCProeject.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CARD {
	private String name;
	private String phone;
	private String company;
	private Date date;
	
	public CARD() {
		
	}
	public CARD(String name, String phone, String company) {
		this.name=name; this.phone = phone; this.company = company;
	}
	public CARD(String name, String phone, String company, Date date) {
		this.name=name; this.phone = phone; this.company = company; this.date = date;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
		String date1 = format.format(date);
		return "BusinessCard{name=" + name + ", phone=" + phone + ", company=" + company + ", createDate="+date1+"}";
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
