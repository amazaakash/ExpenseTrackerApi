package com.aakash.ExpenseTrackerApiNew.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aakash.ExpenseTrackerApiNew.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	// this is for when we used to filter the expenses by category
	// select * from tbl_expense where category=?
	Page<Expense> findByCategory(String category, Pageable page);

	//select * from tbl_expenses where name like '%keyword%'
	//Page<Expense> findByNameContaining(String keyword, Pageable page);
}
