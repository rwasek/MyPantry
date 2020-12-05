package com.richardwasek.mypantry.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="stock_picture")
	private String stockPicture;
	
//	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Grocery> groceries;
	
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
	
	public List<Grocery> getGroceries() {
		return groceries;
	}

	public void setGroceries(List<Grocery> groceries) {
		this.groceries = groceries;
	}
	
	public void addGrocery(Grocery grocery) {
		if (groceries == null) {
			groceries = new ArrayList<>();
		}
		if (!groceries.contains(grocery)) {
			groceries.add(grocery);
			if (grocery.getCategory() != null) {
				grocery.getCategory().getGroceries().remove(grocery);
			}
		}
	}
	
	public void removeGrocery(Grocery grocery) {
		grocery.setCategory(null);
		if(groceries != null) {
			groceries.remove(grocery);
		}
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
