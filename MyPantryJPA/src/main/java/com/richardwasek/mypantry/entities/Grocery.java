package com.richardwasek.mypantry.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Grocery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="product_name")
	private String productName;
	
	private Double amount;
	
	@Column(name="date_purchased")
	private LocalDate datePurchased;
	
	@Column(name="expiration_date")
	private LocalDate expirationDate;
	
	@Column(name="date_opened")
	private LocalDate dateOpened;
	
	@Column(name="amount_used")
	private Double amountUsed;
	
	// Constructors:
	public Grocery() {
		super();
	}

	public Grocery(int id, Category category, User user, String productName, Double amount, LocalDate datePurchased,
			LocalDate expirationDate, LocalDate dateOpened, Double amountUsed) {
		super();
		this.id = id;
		this.category = category;
		this.user = user;
		this.productName = productName;
		this.amount = amount;
		this.datePurchased = datePurchased;
		this.expirationDate = expirationDate;
		this.dateOpened = dateOpened;
		this.amountUsed = amountUsed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(LocalDate datePurchased) {
		this.datePurchased = datePurchased;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public LocalDate getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(LocalDate dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Double getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(Double amountUsed) {
		this.amountUsed = amountUsed;
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
		Grocery other = (Grocery) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Grocery [id=");
		builder.append(id);
		builder.append(", category=");
		builder.append(category);
		builder.append(", user=");
		builder.append(user);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", datePurchased=");
		builder.append(datePurchased);
		builder.append(", expirationDate=");
		builder.append(expirationDate);
		builder.append(", dateOpened=");
		builder.append(dateOpened);
		builder.append(", amountUsed=");
		builder.append(amountUsed);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
	

}
