package com.aakash.ExpenseTrackerApiNew.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aakash.ExpenseTrackerApiNew.entity.Expense;
import com.aakash.ExpenseTrackerApiNew.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}

	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new RuntimeException("Expense is not present for id" + id);
	}

	@Override
	public void deleteExpenseById(Long id) {

		expenseRepo.deleteById(id);

	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);

	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		Expense existingexpense = getExpenseById(id);
		existingexpense.setExpense_name(
				expense.getExpense_name() != null ? expense.getExpense_name() : existingexpense.getExpense_name());
		existingexpense.setDescription(
				expense.getDescription() != null ? expense.getDescription() : existingexpense.getDescription());
		existingexpense
				.setCategory(expense.getCategory() != null ? expense.getCategory() : existingexpense.getCategory());
		existingexpense.setExpense_amount(expense.getExpense_amount() != null ? expense.getExpense_amount()
				: existingexpense.getExpense_amount());
		existingexpense.setDate(expense.getDate() != null ? expense.getDate() : existingexpense.getDate());

		return expenseRepo.save(existingexpense);
	}

	@Override
	public List<Expense> readByCategory(String category, Pageable page) {
		return expenseRepo.findByCategory(category, page).toList();

	}

	/*
	 * @Override public List<Expense> readByName(String keyword, Pageable page) {
	 * 
	 * return expenseRepo.findByNameContaining(keyword, page).toList(); }
	 */

}
