/**
 * <h1>Package for Trainer class</h1>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.model;

import java.util.List;

import com.element5.employee.model.Employee;
import com.element5.employee.model.Trainee;

/**
 * <h2>
 * This is the Trainer class
 *</h2>
 *
 * <p> 
 * This Trainer class extends the Employee class.
 * This class can achieve the Employee class methods and
 * this class have setter and getter methods 
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  07 / 07 / 2022
 */
public class Trainer extends Employee {

    private int  batchNumber;
    private List<Trainee> trainees;

    /**
     * <p> 
     * This is the method to set the trainees for trainer 
     * </p>
     *
     * @param List<Trainee> trainee - trainee of the trainer
     *
     * @return void - returns nothing
     */
    public void setTrainees(List<Trainee> trainees) {
	this.trainees = trainees;
    }
      
    /**
     * <p> 
     * This is the method to set the batch number for trainer 
     * </p>
     *
     * @param int batchNumber - the batchNumber of the trainer
     *
     * @return void - returns nothing
     */
    public void setBatchNumber(int batchNumber) {
	this.batchNumber = batchNumber;
    }

    /**
     * <p> 
     * This is the method to get the batchNumber of the trainer 
     * </p>
     *
     * @return - returns batchNumber
     */
    public int getBatchNumber() {
	return batchNumber;
    }

    /**
     * <p> 
     * This is the method to get the trainees of the trainer 
     * </p>
     *
     * @return List<Trainee> - returns trainees
     */
    public List<Trainee> getTrainees() {
	return trainees;
    }

    /**
     * <p> 
     * This is the method to override the toString method
     * </p>
     *
     * @returns String - returns trainer as String
     */
    @Override
    public String toString() {
        System.out.println("\n ------------TRAINER DETAILS----------- \n\n");
	return (" Company : " + super.getCompanyName() 
                +"\n" + " ID : " + super.getId() + "\n" 
                +" Name : " + super.getName() + "\n"
		+" Gender : " + super.getGender()+ "\n"
                +" Age : "  + super.getAge() + "\n"
                +" Designation : " + super.getDesignation() + "\n"
		+" Experience : " + super.getExperience() + "\n"
		+" Batch Number " + getBatchNumber() + "\n"
		+" Email ID : " + super.getEmailId() + "\n"
                +" Contact Number : " + super.getContactNumber() + "\n" 
                +" Aadhar Number : " + super.getAadharNumber() + "\n"
		+"\n----------------------------------------");
    }  
}