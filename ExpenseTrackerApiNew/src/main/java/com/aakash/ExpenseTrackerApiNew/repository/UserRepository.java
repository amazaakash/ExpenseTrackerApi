package com.aakash.ExpenseTrackerApiNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aakash.ExpenseTrackerApiNew.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
