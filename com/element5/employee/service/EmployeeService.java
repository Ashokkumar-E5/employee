/**
 * <h1>Package for Employee Service class</h1>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.service;

import java.time.LocalDate;
import java.util.Random;
import java.util.List;

import com.element5.employee.exception.DatabaseException;
import com.element5.employee.model.Employee;
import com.element5.employee.model.Trainer;
import com.element5.employee.model.Trainee;

/**
 * <h2>
 * This is EmployeeService class 
 * </h2>
 *
 * <p> 
 * In this class all the methods are declared only.
 * In future if any class implements this EmployeeService class.
 * The implemented class should implement all methods which is declared in this class.
 * </p>
 *
 * @author Ashok Kumar M
 *
 * @since 12/07/2022
 */ 
public interface EmployeeService {

    /**
     * <p>
     * This method is to pass the trainee object to dao impl class to Create Trainee
     * </p>
     *
     * @param {@link String}String id is the employee id of the trainee
     * @param {@link String} String name is the name for the trainee
     * @param {@link String} String gender is the gender for the trainee
     * @param {@link LocalDate} String dateOfBirth is the date of Birth for the trainee
     * @param {@link LocalDate} String dateOfJoin is the date of join for the trainee
     * @param {@link String} String designation is the designation for the trainee
     * @param {@link float} float salary is the employee id for the trainee
     * @param {@link String} String emailId is the email Id for the trainee
     * @param {@link long} long contactNumber is the Contact Number for the trainee
     * @param {@link long} long aadharNumber is the Aadhar Number for the trainee
     *
     * @return {@link String}
     */
    public String createTrainee(String id, String name, String gender, LocalDate dateOfBirth, LocalDate dateOfJoin,
			      String designation, float salary, String emailId, long contactNumber,
			      long aadharNumber, String task) throws DatabaseException;
    /**
     * <p>
     * This method is to pass the trainer object to dao impl class to Create Trainer
     * </p>
     *
     * @param {@link String} employee id of the trainer
     * @param {@link String} String name is the name for the trainer
     * @param {@link String} String gender is the gender for the trainer
     * @param {@link LocalDate} String dateOfBirth is the date of Birth for the trainer
     * @param {@link LocalDate} String dateOfJoin is the date of join for the trainer
     * @param {@link String} String designation is the designation for the trainer
     * @param {@link float} int salary is the employee id for the trainer
     * @param {@link String} String emailId is the email Id for the trainer
     * @param {@link long} long contactNumber is the Contact Number for the trainer
     * @param {@link long} long aadharNumber is the Aadhar Number for the trainer
     * @param {@link int} int batchNumber is to find which Batch trainer
     *
     * @return {@link String}
     */
    public String createTrainer(String id, String name, String gender, LocalDate dateOfBirth, LocalDate dateOfJoin,
			      String designation, float salary, String emailId, long contactNumber,
			      long aadharNumber, int batchNumber) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainer id to dao impl class to get the trainer details
     * </p>
     *
     * @param {@link String} String id is the id of the trainer 
     *
     * @return {@link Trainer} returns  trainer object
     */
    public Trainer getTrainerById(String id) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainee id to dao impl class to get the trainee details
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     *
     * @return {@link Trainee} returns trainee object
     */
    public Trainee getTraineeById(String id) throws DatabaseException;

    /** <p>
     * This method to call the dao impl class to get the all trainers details
     * </p>
     *
     * @return {@link List <Trainer>} returns trainers object
     */
    public List<Trainer> getTrainers() throws DatabaseException;
    
    /** 
     * <p>
     * This method to call the dao impl class to get the all trainees details
     * </p>
     *
     * @return {@link List <Trainee>} returns trainees object
     */
    public List<Trainee> getTrainees() throws DatabaseException;
    
    /**
     * <p>
     * This method to pass the trainer id to dao impl class to delete trainer 
     * </p>
     *
     * @param {@link String} String id is the id of the trainer
     *
     * @return String 
     */
    public String deleteTrainerById(String id) throws DatabaseException;
 
    /**
     * <p>
     * This method to pass the trainee id to dao impl class
     * to delete trainee details 
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     *
     * @return String
     */
    public String deleteTraineeById(String id) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainer id and new Email Id to dao impl class
     * to update trainer Email Id 
     * </p>
     *
     * @param {@link String} String id is the id of the trainer
     * @param {@link String} String newEmailId
     *
     * @return String
     */
    public String updateTrainerEmailIdById(String id, String newEmailId) throws DatabaseException;

    /**
     * <p>
     * This method pass the trainee id and new Email Id to dao impl class
     * to update trainee Email Id
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link String} String newEmailId
     *
     * @return String
     */
    public String updateTraineeEmailIdById(String id, String newEmailId) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainer id and new Designation to dao impl class
     * to update trainer Designation
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link String} String newDesignation
     *
     * @return String
     */
    public String updateTrainerDesignationById(String id, String newDesignation) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainee id and new Designation to dao impl class
     * to update trainee Designation
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link String} String newDesignation
     *
     * @return String
     */
    public String updateTraineeDesignationById(String id, String newDesignation) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainer id and new Contact Number to dao impl class
     * to update trainer Contact Number
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link long} String newContactNumber
     *
     * @return String
     */
    public String updateTrainerContactNumberById(String id, long newContactNumber) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainee id and new Contact Number to dao impl class
     * to update trainee Contact Number
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link long} String newContactNumber
     *
     * @return String
     */
    public String updateTraineeContactNumberById(String id, long newContactNumber) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainer id and New Aadhar Number to dao impl class
     * to update trainer Aadhar Number
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link long} String newAadharNumber
     *
     * @return String
     */
    public String updateTrainerAadharNumberById(String id, long newAadharNumber) throws DatabaseException;

    /**
     * <p>
     * This method to pass the trainee id and New Aadhar Number to dao impl class
     * to update trainee Aadhar Number
     * </p>
     *
     * @param {@link String} String id is the id of the trainee
     * @param {@link long} String newAadharNumber
     *
     * @return String 
     */
    public String updateTraineeAadharNumberById(String id, long newAadharNumber) throws DatabaseException; 

    /**
     * <p>
     * This method is to generate the Employee id
     * </p>
     *
     * @return {@link String} returns employeeId
     */
    public String generateEmployeeId(); 

    /**
     * <p>
     * This is the method to pass the traineeId and trainerId
     * to associate the trainee to trainer
     * </p>
     *
     * @param String traineeId - id of the trainee 
     * @param String trainerId - id of the trainer
     *
     * @returns String - returns status
     */
    public String associateTrainerToTrainee(String traineeId, String trainerId) throws DatabaseException;

    /**
     * <p>
     * This method is to get all unassigned Trainees
     * </p>
     *
     * @return List<Trainee>
     */
    public List<Trainee> getUnassignedTrainees() throws DatabaseException;

}