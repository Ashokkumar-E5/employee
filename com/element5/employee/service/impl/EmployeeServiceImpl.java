/**
 * <h1>
 * Package for Employee Service Impl class
 * </h1>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.List;

import com.element5.employee.dao.EmployeeDAO;
import com.element5.employee.dao.impl.EmployeeDaoImpl;
import com.element5.employee.exception.DatabaseException;
import com.element5.employee.model.Trainer;
import com.element5.employee.model.Trainee;
import com.element5.employee.service.EmployeeService;

/**
 * <h1>
 * This is EmployeeServiceImpl class 
 * </h1>
 *
 * <p> 
 * This class implements the EmployeeService class.
 * This class implements all the methods in the EmployeeService class.
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  20 / 07 / 2022
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDaoImpl = new EmployeeDaoImpl();

    /**
     * {@inheritdoc}
     */
    public String createTrainee(String id, String name, String gender, LocalDate dateOfBirth, LocalDate dateOfJoin,
			      String designation, float salary, String emailId, long contactNumber,
			      long aadharNumber, String task) throws DatabaseException {
        Trainee trainee = new Trainee();
	trainee.setId(id);
        trainee.setName(name);
	trainee.setGender(gender);
        trainee.setDateOfBirth(dateOfBirth);
	trainee.setDateOfJoin(dateOfJoin);
	trainee.setDesignation(designation);
	trainee.setSalary(salary);
	trainee.setEmailId(emailId);
	trainee.setContactNumber(contactNumber);
	trainee.setAadharNumber(aadharNumber);
	trainee.setTask(task);
        return employeeDaoImpl.insertTrainee(trainee) ? "Trainee is successfully added " : "Trainee is not added";
    }

    /**
     * {@inheritdoc}
     */
    public String createTrainer(String id, String name, String gender, LocalDate dateOfBirth, LocalDate dateOfJoin,
			       String designation, float salary, String emailId, long contactNumber,
			       long aadharNumber, int batchNumber) throws DatabaseException {
        Trainer trainer = new Trainer();
	trainer.setId(id);
        trainer.setName(name);
	trainer.setGender(gender);
        trainer.setDateOfBirth(dateOfBirth);
	trainer.setDateOfJoin(dateOfJoin);
	trainer.setDesignation(designation);
	trainer.setSalary(salary);
	trainer.setBatchNumber(batchNumber);
	trainer.setEmailId(emailId);
	trainer.setContactNumber(contactNumber);
	trainer.setAadharNumber(aadharNumber);
	return employeeDaoImpl.insertTrainer(trainer) ? "Trainer is successfully added " : " Trainer is not added ";
    }
    
    /**
     * {@inheritdoc}
     */
    public Trainer getTrainerById(String id) throws DatabaseException {
	return employeeDaoImpl.retrieveTrainerById(id);
    }

    /**
     * {@inheritdoc}
     */
    public Trainee getTraineeById(String id) throws DatabaseException {
	return employeeDaoImpl.retrieveTraineeById(id);
    }

    /**
     * {@inheritdoc}
     */
    public List<Trainer> getTrainers() throws DatabaseException {
	return employeeDaoImpl.retrieveTrainers();
    }

    /**
     * {@inheritdoc}
     */
    public List<Trainee> getTrainees() throws DatabaseException {
	return employeeDaoImpl.retrieveTrainees();
    }

    /**
     * {@inheritdoc}
     */
    public String deleteTrainerById(String id) throws DatabaseException  {
	return employeeDaoImpl.deleteTrainerById(id) ? "Trainer is successfully deleted" : "Trainer is not deleted";
    }

    /**
     * {@inheritdoc}
     */
    public String deleteTraineeById(String id) throws DatabaseException {
	return employeeDaoImpl.deleteTraineeById(id) ? "Trainee is successfully deleted" : "Trainee is not deleted";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTrainerEmailIdById(String id, String newEmailId) throws DatabaseException {
	return employeeDaoImpl.updateTrainerEmailIdById(id, newEmailId) ? "Trainer email id is successfully updated "
									: "Trainer email id is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTraineeEmailIdById(String id, String newEmailId) throws DatabaseException {
	return employeeDaoImpl.updateTraineeEmailIdById(id, newEmailId) ? "Trainee email id is successfully updated"
								        : "Trainee email id is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTrainerDesignationById(String id, String newDesignation) throws DatabaseException {
	return employeeDaoImpl.updateTrainerDesignationById(id, newDesignation) ? "Trainer designation is successfully updated"
									 	: "Trainer designation is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTraineeDesignationById(String id, String newDesignation)  throws DatabaseException{
	return employeeDaoImpl.updateTraineeDesignationById(id, newDesignation) ? "Trainee designation is successfully updated"
									 	: "Trainee designation is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTrainerContactNumberById(String id, long newContactNumber) throws DatabaseException {
	return employeeDaoImpl.updateTrainerContactNumberById(id, newContactNumber) ? "Trainer contact number is successfully updated"
									 	     : "Trainer contact number is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTraineeContactNumberById(String id, long newContactNumber) throws DatabaseException {
	return employeeDaoImpl.updateTraineeContactNumberById(id, newContactNumber) ? "Trainee contact number is successfully updated"
									 	     : "Trainee contact number is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String updateTrainerAadharNumberById(String id, long newAadharNumber) throws DatabaseException {
	return employeeDaoImpl.updateTrainerAadharNumberById(id, newAadharNumber) ? "Trainer aadhar number is successfully updated"
									          : "Trainer aadhar number is not updated";
    }
    
    /**
     * {@inheritdoc}
     */
    public String updateTraineeAadharNumberById(String id, long newAadharNumber) throws DatabaseException {
	return employeeDaoImpl.updateTraineeAadharNumberById(id, newAadharNumber) ? "Trainee aadhar number is successfully updated"
									 	  : "Trainee aadhar number is not updated";
    }

    /**
     * {@inheritdoc}
     */
    public String generateEmployeeId() {
	Random random = new Random();
	int range = 99999 - 10000 + 1;
	int randomNumber = random.nextInt(range) + 10000;
	char identity = 'E';
	String employeeId = identity + ""  + randomNumber;
	return employeeId;
    }

    /**
     * {@inheritdoc}
     */
    public String associateTrainerToTrainee(String traineeId, String trainerId) throws DatabaseException {
	return employeeDaoImpl.associateTraineeToTrainer(traineeId, trainerId) ? "Trainer is associate to trainee successfully"
									       : "Trainer is not associate to trainee";
    }
  
    /**
     * {@inheritdoc} 
     */
    public List<Trainee> getUnassignedTrainees() throws DatabaseException {
	return employeeDaoImpl.getUnassignedTrainees();
    }
}

    

