package com.richardwasek.mypantry.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="stock_picture")
	private String stockPicture;
	
	// Constructors:
	public Category() {
		super();
	}
	
	public Category(int id, String categoryName, String stockPicture) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.stockPicture = stockPicture;
	}
	
	// Methods:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStockPicture() {
		return stockPicture;
	}

	public void setStockPicture(String stockPicture) {
		this.stockPicture = stockPicture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append(", stockPicture=");
		builder.append(stockPicture);
		builder.append("]");
		return builder.toString();
	}
	
	
	

	


	

	
	

}
