/**
 * <h1> Package for Employee DAO Impl class </h1>
 *
 * @Copyright 2022 Element5
 *
 */
package com.element5.employee.dao.impl;

import java.lang.NullPointerException;
import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.element5.employee.dao.EmployeeDAO;
import com.element5.employee.exception.DatabaseException;
import com.element5.employee.model.Employee;
import com.element5.employee.model.Trainer;
import com.element5.employee.model.Trainee;
import com.element5.employee.utils.ConnectionUtil;
import com.element5.employee.utils.ConstantUtil;

/**
 * <h2>
 * This is EmployeeDAOimpl class 
 * </h2>
 *
 * <p> 
 * This class implements the EmployeeDAO class.
 * This class implements all the methods in the EmployeeDAO class.
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  24 / 07 / 2022 
 */
public class EmployeeDaoImpl implements EmployeeDAO  {

    /**
     * {@inheritdoc} 
     */
    public boolean insertTrainee(Trainee trainee) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "INSERT INTO trainee (id, name, gender, date_of_birth," 
						  +" date_of_join, designation, task, salary,"
						  +" email_id, contact_number, aadhar_number)" 
						  + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, trainee.getId());
	    statement.setString(2, trainee.getName());
            statement.setString(3, trainee.getGender());
            statement.setDate(4, Date.valueOf(trainee.getDateOfBirth()));
	    statement.setDate(5, Date.valueOf(trainee.getDateOfJoin()));
            statement.setString(6, trainee.getDesignation());
            statement.setString(7, trainee.getTask());
            statement.setFloat(8, trainee.getSalary());
	    statement.setString(9, trainee.getEmailId());
            statement.setLong(10, trainee.getContactNumber());
            statement.setLong(11, trainee.getAadharNumber());
            statement.executeUpdate(); 
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(sqlException.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean insertTrainer(Trainer trainer) throws DatabaseException {
        Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "INSERT INTO trainer (id, name, gender, date_of_birth," 
						 +" date_of_join, designation, batch_number," 
						 +" salary, email_id, contact_number,"
						 +" aadhar_number) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, trainer.getId());
	    statement.setString(2, trainer.getName());
            statement.setString(3, trainer.getGender());
            statement.setDate(4, Date.valueOf(trainer.getDateOfBirth()));
	    statement.setDate(5, Date.valueOf(trainer.getDateOfJoin()));
            statement.setString(6, trainer.getDesignation());
            statement.setInt(7, trainer.getBatchNumber());
            statement.setFloat(8, trainer.getSalary());
	    statement.setString(9, trainer.getEmailId());
            statement.setLong(10, trainer.getContactNumber());
            statement.setLong(11, trainer.getAadharNumber());
            statement.executeUpdate();
	    return true;
	}catch (SQLException sqlException) {
	    throw new DatabaseException(sqlException.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public Trainee retrieveTraineeById(String traineeId) throws DatabaseException{
       
	Connection connection = null;
	PreparedStatement statement = null;
	try {
            String query = "SELECT * FROM trainee WHERE id = (?)";
            connection = ConnectionUtil.getConnection();
	    Trainee trainee = null;
            statement = connection.prepareStatement(query);
            statement.setString(1, traineeId);
	    ResultSet traineeDetails = statement.executeQuery();
            while(traineeDetails.next()) {
                trainee = new Trainee();
	        trainee.setId(traineeDetails.getString(ConstantUtil.id));
                trainee.setName(traineeDetails.getString(ConstantUtil.name));
                trainee.setGender(traineeDetails.getString(ConstantUtil.gender));
                trainee.setDateOfBirth(traineeDetails.getDate(ConstantUtil.dateOfBirth).toLocalDate());
                trainee.setDateOfJoin(traineeDetails.getDate(ConstantUtil.dateOfJoin).toLocalDate());
    	        trainee.setTask(traineeDetails.getString(ConstantUtil.task));
	        trainee.setDesignation(traineeDetails.getString(ConstantUtil.designation));
	        trainee.setSalary(traineeDetails.getFloat(ConstantUtil.salary));
                trainee.setEmailId(traineeDetails.getString(ConstantUtil.emailId));
	        trainee.setContactNumber(traineeDetails.getLong(ConstantUtil.contactNumber));
	        trainee.setAadharNumber(traineeDetails.getLong(ConstantUtil.aadharNumber));
	    }
	    return trainee;
        } catch (SQLException |NullPointerException exception) {
	    throw new DatabaseException(exception.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	} 
    }

    /**
     * {@inheritdoc} 
     */
    public Trainer retrieveTrainerById(String trainerId) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
        PreparedStatement statement2 = null;
	List<Trainee> trainees = new ArrayList<>();
        Trainer trainer = null;
	try {
            String query = "SELECT * FROM trainer WHERE id = (?)";
            connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, trainerId);
	    ResultSet trainerDetails = statement.executeQuery();
            while (trainerDetails.next()) {
		trainer = new Trainer();
	        trainer.setId(trainerDetails.getString(ConstantUtil.id));
                trainer.setName(trainerDetails.getString(ConstantUtil.name));
                trainer.setGender(trainerDetails.getString(ConstantUtil.gender));
                trainer.setDateOfBirth(trainerDetails.getDate(ConstantUtil.dateOfBirth).toLocalDate());
                trainer.setDateOfJoin(trainerDetails.getDate(ConstantUtil.dateOfJoin).toLocalDate());
    	        trainer.setBatchNumber(trainerDetails.getInt(ConstantUtil.batchNumber));
	        trainer.setDesignation(trainerDetails.getString(ConstantUtil.designation));
	        trainer.setSalary(trainerDetails.getFloat(ConstantUtil.salary));
                trainer.setEmailId(trainerDetails.getString(ConstantUtil.emailId));
	        trainer.setContactNumber(trainerDetails.getLong(ConstantUtil.contactNumber));
	        trainer.setAadharNumber(trainerDetails.getLong(ConstantUtil.aadharNumber));
            
	        String query2 = "SELECT * FROM trainee WHERE trainer_id = (?)";
	        statement2 = connection.prepareStatement(query2);
                statement2.setString(1, trainerId);
	        ResultSet traineeDetails = statement2.executeQuery();
	        while(traineeDetails.next()) {
	            Trainee trainee = new Trainee();
	            trainee.setId(traineeDetails.getString(ConstantUtil.id));
                    trainee.setName(traineeDetails.getString(ConstantUtil.name));
                    trainee.setGender(traineeDetails.getString(ConstantUtil.gender));
                    trainee.setDateOfBirth(traineeDetails.getDate(ConstantUtil.dateOfBirth).toLocalDate());
                    trainee.setDateOfJoin(traineeDetails.getDate(ConstantUtil.dateOfJoin).toLocalDate());
    	            trainee.setTask(traineeDetails.getString(ConstantUtil.task));
	            trainee.setDesignation(traineeDetails.getString(ConstantUtil.designation));
	            trainee.setSalary(traineeDetails.getFloat(ConstantUtil.salary));
                    trainee.setEmailId(traineeDetails.getString(ConstantUtil.emailId));
	            trainee.setContactNumber(traineeDetails.getLong(ConstantUtil.contactNumber));
	            trainee.setAadharNumber(traineeDetails.getLong(ConstantUtil.aadharNumber));	
		    trainees.add(trainee);
                }
            }
	    trainer.setTrainees(trainees);
            return trainer;
	} catch (SQLException | NullPointerException exception) {
	    throw new DatabaseException(exception.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public List<Trainee> retrieveTrainees() throws DatabaseException { 
	Connection connection = null;
	PreparedStatement statement = null;
        Trainee trainee = null;
	List<Trainee> trainees = new ArrayList<>();
	try {
            String query = "SELECT * FROM trainee WHERE is_active = true";
            connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet traineesDetails = statement.executeQuery();
            while(traineesDetails.next()) {
                trainee = new Trainee();
	        trainee.setId(traineesDetails.getString(ConstantUtil.id));
                trainee.setName(traineesDetails.getString(ConstantUtil.name));
                trainee.setGender(traineesDetails.getString(ConstantUtil.gender));
                trainee.setDateOfBirth(traineesDetails.getDate(ConstantUtil.dateOfBirth).toLocalDate());
                trainee.setDateOfJoin(traineesDetails.getDate(ConstantUtil.dateOfJoin).toLocalDate());
    	        trainee.setTask(traineesDetails.getString(ConstantUtil.task));
	        trainee.setDesignation(traineesDetails.getString(ConstantUtil.designation));
	        trainee.setSalary(traineesDetails.getFloat(ConstantUtil.salary));
                trainee.setEmailId(traineesDetails.getString(ConstantUtil.emailId));
	        trainee.setContactNumber(traineesDetails.getLong(ConstantUtil.contactNumber));
	        trainee.setAadharNumber(traineesDetails.getLong(ConstantUtil.aadharNumber));
                trainees.add(trainee);
            }   
	} catch (SQLException | NullPointerException exception) {
	    throw new DatabaseException(exception.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return trainees;
    }

    /**
     * {@inheritdoc} 
     */
    public List<Trainer> retrieveTrainers() throws DatabaseException {
        Connection connection = null;
	PreparedStatement statement = null; 
        List<Trainer> trainers = new ArrayList<>();
	try {
            String query = "SELECT * FROM trainer WHERE is_active = true";
            connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet trainersDetails = statement.executeQuery();
            while(trainersDetails.next()) {
                Trainer trainer = new Trainer();
	        trainer.setId(trainersDetails.getString(ConstantUtil.id));
                trainer.setName(trainersDetails.getString(ConstantUtil.name));
                trainer.setGender(trainersDetails.getString(ConstantUtil.gender));
                trainer.setDateOfBirth(trainersDetails.getDate(ConstantUtil.dateOfBirth).toLocalDate());
                trainer.setDateOfJoin(trainersDetails.getDate(ConstantUtil.dateOfJoin).toLocalDate());
    	        trainer.setBatchNumber(trainersDetails.getInt(ConstantUtil.batchNumber));
	        trainer.setDesignation(trainersDetails.getString(ConstantUtil.designation));
	        trainer.setSalary(trainersDetails.getFloat(ConstantUtil.salary));
                trainer.setEmailId(trainersDetails.getString(ConstantUtil.emailId));
	        trainer.setContactNumber(trainersDetails.getLong(ConstantUtil.contactNumber));
	        trainer.setAadharNumber(trainersDetails.getLong(ConstantUtil.aadharNumber));
                trainers.add(trainer);
            } 
	    return trainers;
	} catch (SQLException | NullPointerException exception) {
	    throw new DatabaseException(exception.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean deleteTraineeById(String traineeId) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainee SET is_active = false WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setString(1, traineeId);
	    statement.executeUpdate();	 
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainee is not deleted ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean deleteTrainerById(String trainerId) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainer SET is_active = false WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setString(1, trainerId);
	    statement.executeUpdate();
	    statement.close();
	    connection.close();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainer is not deleted ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
	
    /**
     * {@inheritdoc} 
     */
    public boolean updateTraineeDesignationById(String traineeId, String newDesignation) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainee SET trainee_designation = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setString(1, newDesignation);
	    statement.setString(2, traineeId);
	    statement.executeUpdate();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainee designation is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    
    /**
     * {@inheritdoc} 
     */
    public boolean updateTrainerDesignationById(String trainerId, String newDesignation) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainer SET trainer_designation = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, newDesignation);
	    statement.setString(2, trainerId);
	    statement.executeUpdate();
	    statement.close();
	    connection.close();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainer designation is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean updateTraineeEmailIdById(String traineeId, String newEmailId) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainee SET trainee_emailid = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, newEmailId);
	    statement.setString(2, traineeId);
	    statement.executeUpdate();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainee email id is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean updateTrainerEmailIdById(String trainerId, String newEmailId) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainer SET trainer_emailid = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setString(1, newEmailId);
	    statement.setString(2, trainerId);
	    statement.executeUpdate();
	    statement.close();
	    connection.close();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainer email id  is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean updateTraineeContactNumberById(String traineeId, long newContactNumber) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainee SET trainee_contactnumber = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setLong(1, newContactNumber);
	    statement.setString(2, traineeId);
	    statement.executeUpdate();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainee contact number is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean updateTrainerContactNumberById(String trainerId, long newContactNumber) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainer SET trainer_contactnumber = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setLong(1, newContactNumber);
	    statement.setString(2, trainerId);
	    statement.executeUpdate();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainer contact number is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean updateTraineeAadharNumberById(String traineeId, long newAadharNumber) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainee SET trainee_contactnumber = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setLong(1, newAadharNumber);
	    statement.setString(2, traineeId);
	    statement.executeUpdate();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainee aadhar number is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc} 
     */
    public boolean updateTrainerAadharNumberById(String trainerId, long newAadharNumber) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainer SET trainer_contactnumber = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setLong(1, newAadharNumber);
	    statement.setString(2, trainerId);
	    statement.executeUpdate();
	    return true;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainer aadhar number is not updated ");
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * {@inheritdoc}
     */
    public boolean associateTraineeToTrainer(String traineeId, String trainerId) throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
	try {
	    String query = "UPDATE trainee SET trainer_id = (?) WHERE id = (?)";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    statement.setString(1, trainerId);
	    statement.setString(2, traineeId);
	    statement.executeUpdate();
	} catch (SQLException sqlException) {
	    throw new DatabaseException(" Something wrong trainee is not associated to trainer");
	} finally {
	    try {
                if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
        return true;
    }

    /**
     * {@inheritdoc}     
     */
    public List<Trainee> getUnassignedTrainees() throws DatabaseException {
	Connection connection = null;
	PreparedStatement statement = null;
        List<Trainee> trainees = new ArrayList<>();
        try {
	    String query = "SELECT * FROM trainee WHERE trainer_id IS NULL";
	    connection = ConnectionUtil.getConnection();
            statement = connection.prepareStatement(query);
	    ResultSet unassignedTrainees = statement.executeQuery();
	    while(unassignedTrainees.next()) {
		Trainee trainee = new Trainee();
	        trainee.setId(unassignedTrainees.getString(ConstantUtil.id));
                trainee.setName(unassignedTrainees.getString(ConstantUtil.name));
                trainee.setGender(unassignedTrainees.getString(ConstantUtil.gender));
                trainee.setDateOfBirth(unassignedTrainees.getDate(ConstantUtil.dateOfBirth).toLocalDate());
                trainee.setDateOfJoin(unassignedTrainees.getDate(ConstantUtil.dateOfJoin).toLocalDate());
    	        trainee.setTask(unassignedTrainees.getString(ConstantUtil.task));
	        trainee.setDesignation(unassignedTrainees.getString(ConstantUtil.designation));
	        trainee.setSalary(unassignedTrainees.getFloat(ConstantUtil.salary));
                trainee.setEmailId(unassignedTrainees.getString(ConstantUtil.emailId));
	        trainee.setContactNumber(unassignedTrainees.getLong(ConstantUtil.contactNumber));
	        trainee.setAadharNumber(unassignedTrainees.getLong(ConstantUtil.aadharNumber));
		trainees.add(trainee);
 	        System.out.println(trainee);
	    }
	    return trainees;
	} catch (SQLException sqlException) {
	    throw new DatabaseException(sqlException.getMessage());
	} finally {
	    try {
		if (null != statement) {
                    statement.close();
                }
	        if (null != connection) {
                    connection.close();
                }
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }		
}