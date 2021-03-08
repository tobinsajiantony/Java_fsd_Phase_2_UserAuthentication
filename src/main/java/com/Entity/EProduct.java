package com.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "eproduct")
public class EProduct {
	@Id @Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;

	@Column(name="name")
	private String name;

	@Column(name="price")
	private int price;

	@Column(name="date_added")
	private Date dateAdded;

	public EProduct() {

	}
	public EProduct(String name, int price, Date dateAdded) {
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}

	public long getID() {return this.ID; }
	public String getName() { return this.name;}
	public int getPrice() { return this.price;}
	public Date getDateAdded() { return this.dateAdded;}

	public void setID(long id) { this.ID = id;}
	public void setName(String name) { this.name = name;}
	public void setPrice(int price) { this.price = price;}
	public void setDateAdded(Date date) { this.dateAdded = date;}

}
