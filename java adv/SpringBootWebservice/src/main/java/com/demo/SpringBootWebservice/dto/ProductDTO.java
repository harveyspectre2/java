package com.demo.SpringBootWebservice.dto;

import java.time.LocalDate;




import org.springframework.format.annotation.DateTimeFormat;

public class ProductDTO {
	 private int pid;
	 private String pname;
	 private int qty;
	 private double price;
	 private String mfgdate;
	public ProductDTO() {
		super();
	}
	public ProductDTO(int pid, String pname, int qty, double price, String mfgdate) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.mfgdate = mfgdate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMfgdate() {
		return mfgdate;
	}
	public void setMfgdate(String mfgdate) {
		this.mfgdate = mfgdate;
	}
	@Override
	public String toString() {
		return "ProductDTO [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", mfgdate="
				+ mfgdate + "]";
	}
	 
}
