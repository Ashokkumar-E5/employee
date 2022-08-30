/**
 * <h1>Package for Trainee class</h1>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.model;

import com.element5.employee.model.Employee;
import com.element5.employee.model.Trainer;

/**
 * <h2>This is the Trainee class</h2>
 *
 * <p> 
 * This is Trainee class extends the Employee class.
 * This class can achieve the Employee class methods and
 * this class have setter and getter method
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  07 / 07 / 2022
 */
public class Trainee extends Employee {

    private String task;

    /**
     * <p> 
     * This is the method to set the task for trainee </p>
     *
     * @param String task - task for the given trainee
     *
     * @return void - returns nothing
     */
    public void setTask(String task) {
	this.task = task;
    }

    /**
     * <p> 
     * This is the method to get the task for trainee 
     * </p>
     *
     * @return String - returns String task
     */
    public String getTask() {
	return task;
    }
    
    /**
     * <p> 
     * This is the method to override the toString method 
     * </p>
     * 
     * @return String - returns to string of the trainee
     */
    @Override
    public String toString() {
        System.out.println("\n ------------EMPLOYEE DETAILS----------- \n\n");
	return (" Company : " + super.getCompanyName() 
                +"\n" + " ID : " + super.getId() + "\n" 
                +" Name : " +super.getName() + "\n"
		+" Gender : " + super.getGender()+ "\n"
                +" Age :"  + super.getAge() + "\n"
                +" Designation : " + super.getDesignation() + "\n"
		+" Experience : " + super.getExperience() + "\n"
		+" salary :" + super.getSalary() + "\n"
		+" Email ID : " + super.getEmailId() + "\n"
                +" Contact Number : " + super.getContactNumber() + "\n" 
                +" Aadhar Number : " + super.getAadharNumber()
		+"\n");
    }  
       
}