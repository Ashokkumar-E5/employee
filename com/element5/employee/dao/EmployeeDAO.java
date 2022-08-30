/**
 * <h1>Package for Employee DAO class</h1>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.dao;

import java.util.List;

import com.element5.employee.exception.DatabaseException;
import com.element5.employee.model.Employee;
import com.element5.employee.model.Trainer;
import com.element5.employee.model.Trainee;

/**
 * <h2> This is EmployeeDAO class </h2>
 *
 * <p> 
 * In this class all the methods are declared only.
 * In future if any class implements this EmployeeDAO class.
 * The implemented class should implement all methods which is declared in this class.
 * </p>
 *
 * @author Ashok Kumar M
 *
 * @since 10/07/2022
 */ 
public interface EmployeeDAO {

    /**
     * <p>
     * This method is used to Insert Trainer in to the map 
     * </p>
     *
     * @param {@link Trainer} trainer Object
     *
     * @return boolean 
     */
    public boolean insertTrainer(Trainer trainer) throws DatabaseException;

    /**
     * <p>
     * This method is used to Insert Trainee in to the map
     * </p>
     *
     * @param {@link Trainee} trainee Object
     *
     * @return boolean
     */ 
    public boolean insertTrainee(Trainee trainee) throws DatabaseException;

    /**
     * <p>
     * This method is used to retrieve Trainer in to the map 
     * </p>
     *
     * @param {@link Trainer} trainer Object
     *
     * @return Trainer 
     */
    public Trainer retrieveTrainerById(String id) throws DatabaseException;

    /**
     * <p>
     * This method is used to retrieve Trainee in to the map 
     * </p>
     *
     * @param {@link String} id
     *
     * @return Trainee
     */
    public Trainee retrieveTraineeById(String id) throws DatabaseException;

    /**
     * <p>
     * This method is used to get the All Trainers details in the map
     * </p>
     * 
     * @return {@link  List <Trainer>} returns trainers object
     */
    public List<Trainer> retrieveTrainers() throws DatabaseException;

    /**
     * <p>
     * This method is used to get the All Trainees details in the map
     * </p> 
     *
     * @return {@link  List <Trainee>} returns trainees object
     */
    public List<Trainee> retrieveTrainees() throws DatabaseException;

    /**
     * <p>
     * This method is used to update Trainee Email Id in to the map
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newEmailId
     * 
     * @return boolean 
     */
    public boolean updateTraineeEmailIdById(String id, String newEmailId) throws DatabaseException;

    /**
     * <p>
     * This method is used to update Trainer Email Id in to the map 
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newEmailId 
     *
     * @return boolean
     */
    public boolean updateTrainerEmailIdById(String id, String newEmailId) throws DatabaseException;

    /**
     * <p>
     * This method is used to update Trainer Designation in to the map 
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newDesignation 
     *
     * @return boolean
     */
    public boolean updateTrainerDesignationById(String id, String newDesignation) throws DatabaseException;

    /**
     * <p>
     * This method is used to update Trainee Designation in to the map
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newDesignation
     * 
     * @return boolean
     */
    public boolean updateTraineeDesignationById(String id, String newDesignation) throws DatabaseException;

    /**
     * <p>
     * This method is used to update Trainer Contact Number in to the map 
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newContactNumber
     *
     * @return boolean
     */
    public boolean updateTrainerContactNumberById(String id, long newContactNumber) throws DatabaseException;
   
    /**
     * <p>
     * This method is used to update Trainee Contact Number in to the map
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newContactNumber
     *
     * @return boolean
     */
    public boolean updateTraineeContactNumberById(String id, long newContactNumber) throws DatabaseException;
   
    /**
     * <p>
     * This method is used to update Trainer Aadhar Number in to the map
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newAadharNumber 
     *
     * @return boolean
     */
    public boolean updateTrainerAadharNumberById(String id, long newAadharNumber) throws DatabaseException;

   
    /**
     * <p>
     * This method is used to update Trainee Aadhar Number in to the map 
     * </p>
     *
     * @param {@link String} id
     * @param {@link String} newAadharNumber 
     *
     * @return boolean
     */
    public boolean updateTraineeAadharNumberById(String id, long newAadharNumber) throws DatabaseException;

    /**
     * <p>
     * This method is used to delete Trainer in to the map
     * </p>
     *
     * @param {@link String} id
     *
     * @return boolean
     */
    public boolean deleteTrainerById(String id) throws DatabaseException;

    /**
     * <p>
     * This method is used to delete Trainee in to the map 
     * </p>
     *
     * @param {@link String} id
     *
     * @return boolean
     */
    public boolean deleteTraineeById(String id) throws DatabaseException; 

    /**
     * <p>
     * This is the method to associate the trainer to trainee
     * </p>
     *
     * @param String traineeId - id of the trainee 
     * @param String trainerId - id of the trainer
     *
     * @returns boolean 
     */
    public boolean associateTraineeToTrainer(String traineeId, String trainerId) throws DatabaseException; 

    /**
     * <p>
     * This method is get the all unassigned Trainees 
     * </p>
     *
     * @return List<Trainee>
     */
    public List<Trainee> getUnassignedTrainees() throws DatabaseException;
     
}