package com.nit.test.Entity;



import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Pro_name;
	private String Pro_Disc;
	private double Pro_price;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalDateTime arrivalTime;
	
	private int shelfLife;

	private LocalDateTime expirayDateTime;

	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPro_name() {
		return Pro_name;
	}
	public void setPro_name(String pro_name) {
		Pro_name = pro_name;
	}
	public String getPro_Disc() {
		return Pro_Disc;
	}
	public void setPro_Disc(String pro_Disc) {
		Pro_Disc = pro_Disc;
	}
	public double getPro_price() {
		return Pro_price;
	}
	public void setPro_price(double pro_price) {
		Pro_price = pro_price;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	public int getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}
	public LocalDateTime getExpirayDateTime() {
		return expirayDateTime;
	}
	public void setExpirayDateTime(LocalDateTime expirayDateTime) {
		this.expirayDateTime = expirayDateTime;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", Pro_name=" + Pro_name + ", Pro_Disc=" + Pro_Disc + ", Pro_price=" + Pro_price
				+ ", arrivalTime=" + arrivalTime + ", shelfLife=" + shelfLife + ", expirayDateTime=" + expirayDateTime
				+ "]";
	}
	public Products(int id, String pro_name, String pro_Disc, double pro_price, LocalDateTime arrivalTime,
			int shelfLife, LocalDateTime expirayDateTime) {
		super();
		this.id = id;
		Pro_name = pro_name;
		Pro_Disc = pro_Disc;
		Pro_price = pro_price;
		this.arrivalTime = arrivalTime;
		this.shelfLife = shelfLife;
		this.expirayDateTime = expirayDateTime;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
