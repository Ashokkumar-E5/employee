/**
 * <h1>
 * Package for Employee class
 * </h1>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.model;

import java.time.LocalDate;

import com.element5.employee.utils.DateUtil;

/**
 * <h1>
 * Employee class
 * </h1>
 *
 * <p> 
 * This class have setters and getters methods to set the Employee Informations 
 * and get the Employee Informations 
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  07 / 07 / 2022
 */
public class Employee {

    private String companyName = "Element5";    
    private String id;
    private String name;
    private int age;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoin;
    private int experience;
    private String designation;
    private float salary;
    private String emailId;
    private long contactNumber;
    private long aadharNumber; 

    /**
     * <p>
     * This method is to set the Employee Id
     * </p>
     *
     * @param String id - id of the employee
     *
     * @return void - returns nothing
     */
    public void setId(String id) {
	this.id = id;
    }
 
    /**
     * <p>
     * This method is to set the Employee name
     * </p>
     *
     * @param String name - name of the employee
     *
     * @return void - returns nothing
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * <p>This method is to set the Employee gender</p>
     *
     * @param String gender - gender of the employee
     *
     * @return void - returns nothing
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * <p>
     * This method is to set the Employee date of birth
     * </p>
     *
     * @param LocalDate dateOfBirth - dateOfBirth of the employee
     *
     * @return void - returns nothing
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    /**
     * <p>
     * This method is to set the Employee designation
     * </p>
     *
     * @param String designation - designation of the employee
     *
     * @return void - returns nothing
     */
    public void setDesignation(String designation) {
	this.designation = designation;
    }

    /**
     * <p>
     * This method is to set the Employee date of join
     * </p>
     *
     * @param LocalDate dateOfJoin - dateOfJoin of the employee
     *
     * @return void - returns nothing
     */
    public void setDateOfJoin(LocalDate dateOfJoin) {
	this.dateOfJoin = dateOfJoin;
    }

    /**
     * <p>
     * This method is to set the Employee salary
     * </p>
     *
     * @param float salary - salary of the employee
     *
     * @return void - returns nothing
     */
    public void setSalary(float salary) {
	this.salary = salary;
    }

    /**
     * <p>
     * This method is to set the Employee email id
     * </p>
     *
     * @param String emailId - emailId of the employee
     *
     * @return void - returns nothing
     */
    public void setEmailId(String emailId) {
	this.emailId = emailId;
    }

    /**
     * <p>
     * This method is to set the Employee contact number
     * </p>
     *
     * @param long contactNumber - contactNumber of the employee
     *
     * @return void - returns nothing
     */
    public void setContactNumber(long contactNumber) {
	this.contactNumber = contactNumber;
    }

    /**
     * <p>
     * This method is to set the Employee aadhar number
     * </p>
     *
     * @param String aadharNumber - aadharNumber of the employee
     *
     * @return void - returns nothing
     */
    public void setAadharNumber(long aadharNumber) {
	this.aadharNumber = aadharNumber;
    }

    /**
     * <p> 
     * This method is to get the Employee id
     * </p>
     *
     * @return String - returns id of the employee
     */
    public String getId() {
	return id;
    }

    /**
     * <p> 
     * This method is to get the Employee name
     * </p>
     *
     * @return String - returns name of the employee
     */
    public String getName() {
	return name;
    }

    /**
     * <p>
     * This method is to get the Employee gender
     * </p>
     *
     * @return String- returns gender of the employee
     */
    public String getGender() {
	return gender;
    }

    /**
     * <p> 
     * This method is to get the Employee age 
     * </p>
     *
     * @return int - returns age of the employee
     */
    public int getAge() {
	return (DateUtil.calculateYears(String.valueOf(dateOfBirth)));
    }

    /**
     * <p> 
     * This method is to get the Employee experience 
     * </p>
     *
     * @return int - returns experience of the employee
     */
    public int getExperience() {
	return (DateUtil.calculateYears(String.valueOf(dateOfJoin)));
    }

    /**
     * <p> 
     * This method is to get the Employee dateOfJoin 
     * </p>
     *
     * @return Date - returns Date dateOfJoin of the employee
     */
    public LocalDate getDateOfJoin() {
	return dateOfJoin;
    }

    /**
     * <p> 
     * This method is to get the Employee dateOfBirth 
     * </p>
     *
     * @return Date- returns Date dateOfBirth of the employee
     */
    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    /**
     * <p> 
     * This method is to get the Employee gender 
     * </p>
     *
     * @return String - returns gender of the employee
     */
    public String getDesignation() {
	return designation;
    }

    /**
     * <p> 
     * This method is to get the Employee email id 
     * </p>
     *
     * @return String - returns emailId of the employee
     */
    public String getEmailId() {
	return emailId;
    }

    /**
     * <p> 
     * This method is to get the Employee contact number 
     * </p>
     *
     * @return long - returns contactNumber of the employee
     */
    public long getContactNumber() {
	return contactNumber;
    }
 
    /**
     * <p> 
     * This method is to get the Employee aadhar number
     * </p>
     *
     * @return long - returns aadharNumber of the employee
     */
    public long getAadharNumber() {
	return aadharNumber;
    }
 
    /**
     * <p> 
     * This method is to get the Employee salary 
     * </p>
     *
     * @return float - returns salary of the employee
     */
    public float getSalary() {
	return salary;
    }

    /**
     * <p>
     * This method is to get the Employee company name 
     * </p>
     *
     * @return String - returns companyName of the employee
     */
    public String getCompanyName() {
	return companyName;
    }
  
}   