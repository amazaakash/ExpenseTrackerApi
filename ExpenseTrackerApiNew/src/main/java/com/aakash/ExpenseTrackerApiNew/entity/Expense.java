package com.aakash.ExpenseTrackerApiNew.entity;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_expenses")
public class Expense {

	private Long id;

	private BigDecimal expense_amount;

	private String category;

	private Date date;

	private String description;

	private String expense_name;

	private Timestamp createdAt;

	private Timestamp updated_At;

	public Expense() {
		super();

	}

	public Expense(BigDecimal expense_amount, String category, Date date, String description, String expense_name,
			Timestamp createdAt, Timestamp updated_At) {
		super();
		this.expense_amount = expense_amount;
		this.category = category;
		this.date = date;
		this.description = description;
		this.expense_name = expense_name;
		this.createdAt = createdAt;
		this.updated_At = updated_At;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "expense_amount")
	public BigDecimal getExpense_amount() {
		return expense_amount;
	}

	public void setExpense_amount(BigDecimal expense_amount) {
		this.expense_amount = expense_amount;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "expense_name")
	@NotNull(message = "expense name must not be null")//by this we are adding  validations
	public String getExpense_name() {
		return expense_name;
	}

	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}

	@Column(name="createdAt",nullable = false,updatable = false)
	@CreationTimestamp
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name="updated_At")
	@CreationTimestamp
	public Timestamp getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Timestamp updated_At) {
		this.updated_At = updated_At;
	}

}
