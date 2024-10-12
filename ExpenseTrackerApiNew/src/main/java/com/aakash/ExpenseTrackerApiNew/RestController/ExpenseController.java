package com.aakash.ExpenseTrackerApiNew.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.ExpenseTrackerApiNew.entity.Expense;
import com.aakash.ExpenseTrackerApiNew.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}
	//get data by passing path variable value in the url
	@GetMapping("expenses/{id}")
	public Expense getExpensesById(@PathVariable("id") Long id) {
		return expenseService.getExpenseById(id);
	}
	
	//By below we can add status code to the api that will show in postman 204
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
    public void deleteExpensebyID(@RequestParam Long id) {
		//if the input in url is same as input in method then we don't need to specify in 
		//@RequestParam as well as @PathVariable
		expenseService.deleteExpenseById(id);
	}	
	
	
	//By below we can add status code to the api that will show in postman 201
	@ResponseStatus(value=HttpStatus.CREATED)
	//map http post request into java object 
	@PostMapping("/expenses")
	//in this method we need to only pass json object from postman then it will automatically insert into table
	//by adding @Valid annotation it will check request is valid or not
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
		
	}
	
	
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expense,@PathVariable Long id) {
		return expenseService.updateExpenseDetails(id,expense);
		
	}
	//get expense by category 
	@GetMapping("/expenses/category")
	public List<Expense> getExpenseByCategory(@RequestParam String category,Pageable page){
		return expenseService.readByCategory(category, page);
		
	}
	
	/*
	 * @GetMapping("/expenses/name") public List<Expense>
	 * getExpenseByName(@RequestParam String keyword,Pageable page){ return
	 * expenseService.readByName(keyword, page);
	 * 
	 * }
	 */
	
	
}








