/**
 * <h1>
 * Package for Employee Controller
 * </h1>
 *
 * @Copyright 2022 Element5
 */ 
package com.element5.employee.controller;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.text.ParseException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.element5.employee.exception.DatabaseException;
import com.element5.employee.model.Employee;
import com.element5.employee.model.Trainee;
import com.element5.employee.model.Trainer;
import com.element5.employee.service.EmployeeService;
import com.element5.employee.service.impl.EmployeeServiceImpl;
import com.element5.employee.utils.DateUtil;
import com.element5.employee.utils.StringUtil;

/**
* <h2> This is Employee Controller class</h2>
*
* <p> 
* The Employee Controller class is used to get infromation from the user  and
* display the output on the screen
*</p>

*
* @author  Ashok Kumar M
*
* @since  17 / 07 / 2022
* 
*/
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private Scanner scanner = new Scanner(System.in);

    /**
     * <p> 
     * This is the main method to uses the employeeMenu method 
     * to start the application 
     * </p>
     *
     * @param - String[] args
     *
     * @return - returns nothing
     */	 
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
	logger.info(" Welcome To Element5 Employee Portal\n ");
	employeeController.employeeMenu();
    }

    /**
     * <p> 
     * This method is to access the Employee Operations </p>
     * The Operations are Add, View, Update, Delete 
     * </p>
     *
     * @return void - returns nothing
     */
    public void employeeMenu() {
	boolean flag = true;
        while (flag) {
	    logger.info(" Add employee enter 1 \n");
	    logger.info(" View employee enter 2 \n");
	    logger.info(" Update employee enter 3 \n");
	    logger.info(" Delete employee enter 4 \n");
	    logger.info("Associate trainer to trainee 5\n");
	    logger.info("To Exit enter 6\n");
	    int menuChoice = getNumberInput();
	    try {
                switch (menuChoice) {
	        case 1:
	            addEmployee();
		    break;
	        case 2:
		    viewEmployee();
		    break;
		case 3:
		    updateEmployee();
		    break;
		case 4:
		    deleteEmployee();
		    break;
	        case 5:
		    associateTrainerToTrainee();
		    break;
		case 6:
		    logger.info(" Thank You For Using Element5 Employee Portal ");
		    flag = false;
		    break;
		default:
		    logger.info("Sorry You are Entered Invalid Menu Option\n Please Enter Valid Menu Option");
	
	        }
	    } catch (DatabaseException databaseException) {
		logger.info(databaseException.getMessage());
	    }
	} 
    }

    /**
     * <p>
     * This method is to add the Employee Details.
     * Add trainee details and Trainer details
     * </p>
     *
     * @return void - returns nothing
     */   	   
    public void addEmployee() throws DatabaseException {
	boolean flag = true;
	while (flag) {
            logger.info("Press 1 to Trainer\n ");
	    logger.info("Press 2 to Trainee\n ");
	    logger.info("Press 3 to Exit");
	    int addOption = getNumberInput(); 	     
	    switch (addOption) {	        
	    case 1: 
		logger.info(" How Many Trainers you want add ?\n");
	        int trainerCount = getNumberInput();
	        for (int index = 1; index <= trainerCount; index++) {
		    logger.info(" Trainer Employee Detail - " + index );
		    addTrainer();
		}
		break;
	    case 2: 
		logger.info(" How Many Trainees you want add ?\n");
	        int traineeCount = getNumberInput();
	        for (int index = 1; index <= traineeCount; index++) {
		    logger.info(" Trainee Employee Detail - " + index);
		    addTrainee();
		}
		break;
	    case 3:
		flag = false;
		break;
	    default: 
		logger.info("Oops !!! You Entered Invalid Option ");
		logger.info("\n Please Enter Valid Option ");
	    }	    
	}	 
    }
   
    /**
     * <p>
     * This method is to view the Employee Details
     * View trainee details and Trainer details
     * </p>
     *
     * @return void - returns nothing
     */
    public void viewEmployee() throws DatabaseException {
	boolean flag = true;
	while (flag) {
            logger.info("Press 1 to Trainer Details\n ");
	    logger.info("Press 2 to Trainee Details\n ");
	    logger.info("Press 3 to All Trainers\n ");
	    logger.info("Press 4 to All Trainees\n ");
	    logger.info("Press 5 to Exit\n");
	    int viewOption = getNumberInput(); 	     
	    switch (viewOption) {        
	    case 1: 
		displayTrainerById();
		break;
	    case 2: 
		displayTraineeById();
		break;
	    case 3: 
		displayTrainers();
		break;
	    case 4: 
		displayTrainees();
		break;
	    case 5:
		flag = false;
		break;		
	    default: 
		logger.info("Oops !!! You Entered Invalid Option ");
		logger.info("\n Please Enter Valid Option ");
	    }
	} 
    }

    /**
     * <p> 
     * This method is to update the Employee Details .
     * Update trainee details and Trainer details .
     * </p>
     *
     * @return void - returns nothing
     */
    public void updateEmployee() throws DatabaseException {
	boolean flag = true;
	while (flag) {
            logger.info("Press 1 to Update Trainer\n");
	    logger.info("Press 2 to Update Trainee\n");
	    logger.info("Press 3 to Exit\n");
	    int updateOption = getNumberInput(); 	     
	    switch(updateOption) {       
	    case 1: 
		updateTrainerById();
		break;
	    case 2: 
		updateTraineeById();
		break;
	    case 3:
		flag = false;
		break;
	    default: 
		logger.info("Oops !!! You Entered Invalid Option ");
		logger.info("\n Please Enter Valid Option ");
	    }
	}	 
    }

    /**
     * <p>
     * This method is to delete the Employee Details.
     * Delete trainee details and Trainer details
     * </p>
     *
     * @return - returns nothing
     */
    public void deleteEmployee() throws DatabaseException {
        boolean flag = true;
	while (flag) {
            logger.info("Press 1 to Trainer\n");
	    logger.info("Press 2 to Trainee\n");
	    logger.info("Press 3 to Exit\n");
	    int deleteOption = getNumberInput();    
	    switch (deleteOption) {      
	    case 1: 
		deleteTrainerById();
		break;
	    case 2: 
		deleteTraineeById();
		break;
	    case 3:
		flag = false;
                break;		
	    default:   
		logger.info("Oops !!! You Entered Invalid Option ");
		logger.info("\n Please Enter Valid Option ");
	    }		    
	}	 
    }

    /**
     * <p>
     * This is the common method is to get the valid words from user 
     * for both tariner and trainee
     * </p>
     *
     * @return {link String} returns input
     */
    public String getStringInput() {
        String stringInput = "";
        boolean flag = true;
	while (flag) {
	    stringInput = scanner.next();
	    if (StringUtil.isValidString(stringInput)) {
	        return stringInput;  
	    }
            logger.info(" You Entered Invalid words ");
	    logger.info(" Please Enter Valid words ");    
	}
	return stringInput;
    }

    /**
     * <p>
     * This is the common method is to get the date from the user fro both
     *  trainer and trainee.
     * </p>
     *
     * @return {link Date} returns input
     */
    public LocalDate getDateInput() {
	LocalDate validDate = null;
	boolean flag = true;
        while (flag) {
	    try {
	        String date = scanner.next();
	        validDate = DateUtil.isValidDateFormat(date); 
	        break;        
            } catch (DateTimeParseException parseException) {
	        logger.error(" You Entered Invalid Date\n ");
	        logger.error(" Please Enter the valid Date\n ");
	    }
	}
	return validDate;
    }    

    /**
     * <p>
     * This is the common method is to get the contact number from user
     * for both employees trainer and trainee
     * </p>
     *
     * @param number - this method is choose whether this method is used for trainer
     *			or trainee
     *
     * @return {link String} returns input
     */
    public long getContactNumberInput(int number) throws DatabaseException {
	long validContactNumber = 0;
	boolean flag = true;
	while (flag) {
	    try {
		Scanner scanner = new Scanner(System.in);
	        validContactNumber = scanner.nextLong();
	        String numbersLength = Long.toString(validContactNumber);
	        if (10 == numbersLength.length()) {
		    if (checkContactNumberIsExists(validContactNumber, number)) {
			flag = false;
		    } else {
			logger.info("Sorry this contact number is already exists");
			logger.info("Please try again");
		    }
	        } else {
		    logger.info(" Please Enter 10 numbers\n you should not excess more than 10 numbers or less than 10 numbers ");
	        }
	    } catch (InputMismatchException mismatchException) {
	        logger.error(" Please Enter Valid Numbers ");
	    }
	}
	return validContactNumber;
	
    }

    /**
     * <p>
     * This is the common method to check the user contact number
     * is already exists or not for both trainer and trainee
     * </p>
     *
     * @param long input - input for check whether number is exists
     * @param int number - this number is choose the whether this method 
     *                     is used for trainer or trainee
     *
     * @returns boolean
     */
    public boolean checkContactNumberIsExists(long input, int number) throws DatabaseException {
	boolean isExists = true;
	if (1 == number) {
	    List<Trainee> trainees = employeeService.getTrainees();
	    for (Trainee trainee : trainees) {
		if (input == trainee.getContactNumber()) {
		    isExists = false;
		}
	    }
	} else {
	    List<Trainer> trainers = employeeService.getTrainers();
	    for (Trainer trainer : trainers) {
		if (input == trainer.getContactNumber()) {
		    isExists = false;
		}
	    }
	}
	return isExists;
    }
    

    /**
     * <p>
     * This is the common method is to get the email id from user 
     * for both trainer and trainee
     * </p>
     *
     * @param number - this method is choose whether this method is used for trainer
     *			or trainee
     *
     * @return {link String} returns input
     */
    public String getEmailIdInput(int number) throws DatabaseException {
	String stringInputs = "";
	boolean isExists = true;
	while (isExists) {
	    stringInputs = scanner.next();
	    if (StringUtil.isValidEmailId(stringInputs)) {
		if (checkEmailIdIsExists(stringInputs, number)) {
		    isExists = false;
		} else {
		    logger.info("Sorry email id is already exists\n");
		    logger.info("Please try again");
		}    
	    } else {
	        logger.info("You entered Invalid Email Id :");
	        logger.info("Please Enter Valid Email Id :"); 
	    } 
	}
	return stringInputs;
    }	

    /**
     * <p>
     * This is the common method to check the user email id
     * is already exists or not for both trainer and trainee
     * </p>
     *
     * @param String input - input for check whether number is exists
     * @param int number - this number is choose the whether this method 
     *                     is used for trainer or trainee
     *
     * @returns boolean
     */
    public boolean checkEmailIdIsExists(String input, int number) throws DatabaseException {
	boolean isExists = true;
	if (1 == number) {
	    List<Trainee> trainees = employeeService.getTrainees();
	    for (Trainee trainee : trainees) {
		if (input.equals(trainee.getEmailId())) {
		    isExists = false;
		}
	    }
	} else {
	    List<Trainer> trainers = employeeService.getTrainers();
	    for (Trainer trainer : trainers) {
		if (input.equals(trainer.getEmailId())) {
		    isExists = false;
		}
	    }
	}
	return isExists;
    }

	
    /**
     * <p>
     * This is the common method is to get the Alpha Numeric
     * value from user for both trainer and trainee
     * </p>
     *
     * @return {link String} returns input
     */
    public String getAlphaNumericInput() {
	String alphaInput = "";
	alphaInput = scanner.next();
	if (StringUtil.isValidAlphaNumeric(alphaInput)) {
	    return alphaInput;  
	} else {
	    logger.info("You entered Invalid Employee Id :");
	    logger.info("Please Enter Valid Employee Id");
	    getAlphaNumericInput();
	}
	return alphaInput;
    }

    /**
     * <p>
     * This is the common  method is to get the gender from user
     * for both trainer and trainee
     * </p>
     *
     * @return {link String} returns input
     */
    public String getGenderInput() {
	String stringInput = "";
        boolean flag = true;
        while (flag) {
	    stringInput = scanner.next();
	    if (StringUtil.isValidGender(stringInput)) {
	        return stringInput.toUpperCase();
	    } else {
		logger.info("You entered Invalid gender :");
	        logger.info("Please Enter Valid gender");
	    }
        }
        return stringInput;
    }  

    /**
     * <p>
     * This is the common method is to get the aadhar number
     * from user for both trainer and trainee
     * </p>
     *
     * @param number - this method is choose whether this method is used for trainer
     *			or trainee
     *
     * @return {link String} returns input
     */
    public long getAadharNumberInput(int number) throws DatabaseException {
	long validAadharNumber = 0;
	boolean flag = true;
        while (flag) {
            try {
		Scanner sanner = new Scanner(System.in);
	        validAadharNumber = scanner.nextLong();
	        String numbersLength = Long.toString(validAadharNumber);
	        if (12 == numbersLength.length()) {
		    if (checkAadharNumberIsExists(validAadharNumber, number)) {
			flag = false;
		    } else {
			logger.info("Sorry this aadhar number is already exists\n");
			logger.info("Please try again");
		    }
	        } else {
		    logger.info(" Please Enter 12 numbers\n you should not excess more than 12 numbers or less than 12 numbers ");
	        }
	    } catch (InputMismatchException mismatchException) {
	        logger.error(" Please Enter Numbers Only ");
	    }
	}
	return validAadharNumber;
    }

   
    /**
     * <p>
     * This is the common method to check the user aadhar number
     * is already exists or not for both trainer and trainee
     * </p>
     *
     * @param long input - input for check whether number is exists
     * @param int number - this number is choose the whether this method 
     *                     is used for trainer or trainee
     *
     * @returns boolean
     */
    public boolean checkAadharNumberIsExists(long input, int number) throws DatabaseException {
	boolean isExists = true;
	if (1 == number) {
	    List<Trainee> trainees = employeeService.getTrainees();
	    for (Trainee trainee : trainees) {
		if (input == trainee.getAadharNumber()) {
		    isExists = false;
		}
	    }
	} else {
	    List<Trainer> trainers = employeeService.getTrainers();
	    for (Trainer trainer : trainers) {
		if (input == trainer.getAadharNumber()) {
		    isExists = false;
		}
	    }
	}
	return isExists;
    }
    

    /**
     * <p>
     * This is the common method is to get the Number 
     * from user for both trainer and trainee
     * </p>
     *
     * @return {link String} returns input
     */
    public int getNumberInput() {
	int validNumber = 0;
	boolean flag = true;
	while (flag) {
	    Scanner scanner = new Scanner(System.in);
	    try {
	        validNumber = scanner.nextInt();
		flag = false;
	    } catch(InputMismatchException inputMismatchException) {
	        logger.error("You entered Invalid Number \n");
	        logger.error("Enter Valid Number :");
	    }
	}
	return validNumber;  
    }  

    /**
     * <p>
     * This is the common method is to get the float number 
     * for both the trainer and trainee
     * </p>
     *
     * @return {link float} returns validFloatNumber
     */
    public float getFloatNumberInput() {
	float validFloatNumber = 0;
	boolean flag = true;
	while (flag) {
	    Scanner scanner = new Scanner(System.in);
	    try {
	        validFloatNumber = scanner.nextFloat();
		flag = false;
	    } catch(InputMismatchException inputMismatchException) {
	        logger.error("You entered Invalid Number \n");
	        logger.error("Enter Valid Number :");
	    }
	}
	return validFloatNumber;  
    }

    /**
     * <p>
     * This method is to add the Trainee Details
     * </p>
     *
     * @return void - returns nothing
     */
    public void addTrainee() throws DatabaseException {
        logger.info(" Enter Name : ");
	String name = getStringInput();
        logger.info(" Enter gender ");
        String gender = getGenderInput();
        logger.info(" Enter Date Of Birth in the Format dd-MM-YYYY");
        LocalDate dateOfBirth = getDateInput();
        logger.info(" Enter Designation :");
        String designation = getStringInput();
        logger.info(" Enter Date Of Join in the Format dd-MM-YYYY");
        LocalDate dateOfJoin = getDateInput();
        logger.info(" Enter Salary :");
        float salary = getFloatNumberInput();
	logger.info(" Enter task :");
	String task = getStringInput();
        logger.info(" Enter Email Id :");
        String emailId = getEmailIdInput(1);
        logger.info(" Enter Contact Number : ");
        long contactNumber = getContactNumberInput(1);
        logger.info(" Enter Aadhar Number :");
	long aadharNumber = getAadharNumberInput(1);   
        String id = employeeService.generateEmployeeId();
	logger.info(" Your Employee Id is " + id);        
	logger.info(employeeService.createTrainee(id, name, gender, dateOfBirth, dateOfJoin,
			                          designation, salary, emailId, contactNumber,
			                          aadharNumber, task));
    }

    /**
     * <p> 
     * This method is to add the Trainer Details 
     * </p>
     *
     * @return void - returns nothing
     */
    public void addTrainer() throws DatabaseException {
        logger.info(" Enter Name : ");
	String name = getStringInput();
        logger.info(" Enter gender :");
        String gender = getGenderInput();
        logger.info(" Enter Date Of Birth in the Format dd/MM/YYYY :");
        LocalDate dateOfBirth = getDateInput();
        logger.info(" Enter Designation : ");
        String designation = getStringInput();
        logger.info(" Enter Date Of Join in the Format dd/MM/YYYY :");
        LocalDate dateOfJoin = getDateInput();
        logger.info(" Enter Salary : ");
        float salary = getFloatNumberInput();
        logger.info(" Enter Batch Number : ");
        int batchNumber = getNumberInput();
        logger.info(" Enter Email Id :");
        String emailId = getEmailIdInput(2);
        logger.info(" Enter Contact Number :");
        long contactNumber = getContactNumberInput(2);
        logger.info(" Enter Aadhar Number :");
	long aadharNumber = getAadharNumberInput(2);    
        String id = employeeService.generateEmployeeId();
	logger.info(" Your Employee Id is " + id); 
	logger.info(employeeService.createTrainer(id, name, gender, dateOfBirth, dateOfJoin,
			                          designation, salary, emailId,  contactNumber,
			                          aadharNumber, batchNumber));
    }

    /**
     * <p>
     * This method is used to get Trainee  information by the user
     * </p> 
     *
     * @return void - returns nothing
     */
    public void displayTraineeById() throws DatabaseException {
        logger.info(" Enter Trainee Id : ");
        String traineeId = getAlphaNumericInput();
        logger.info(traineeId);
        Trainee trainee = employeeService.getTraineeById(traineeId);
        if (null != trainee) {
	    logger.info("{}",trainee);	
	} else {
	    logger.info("Sorry No Trainee Record Found");
        }
    } 

    /**
     * <p>
     * This method is used to get Trainer  information by the user
     * </p> 
     *
     * @return void - returns nothing
     */   
    public void displayTrainerById() throws DatabaseException {
	logger.info(" Enter Trainer Id : ");
	String trainerId = getAlphaNumericInput();
        logger.info(trainerId);
	Trainer trainer = employeeService.getTrainerById(trainerId);
	if (null != trainer) {
	    logger.info("{}",trainer);
	    if (null != trainer.getTrainees()) {
		logger.info("{}", trainer.getTrainees());
	    }
        } else {
	    logger.info(" Sorry No Trainer Record Found ");
	}
    }

    /**
     * <p>
     * This method is used to get all Trainees  information by the user
     * </p>
     * 
     * @return void - returns nothing
     */
    public void displayTrainers() throws DatabaseException {
	List<Trainer> trainers = employeeService.getTrainers();
	if (null != trainers) {
	    logger.info("{}", trainers);
	} else {
	    logger.info("Sorry no trainers");
	}
    }

    /**
     * <p>
     * This method is used to get all Trainers information by the user
     * </p>
     * 
     * @return void - returns nothing
     */
    public void displayTrainees() throws DatabaseException {
	List <Trainee> trainees = employeeService.getTrainees();
	if (null != trainees) {
	    logger.info("{}",trainees);
	} else {
	    logger.info("Sorry no trainees");
	}
    }

    /**
     * <p>
     * This method is used to delete Trainee  information by the user
     * </p>
     * 
     * @return - returns nothing
     */
    public void deleteTraineeById() throws DatabaseException {
	logger.info(" Enter Trainee Id : ");
	String traineeId = getAlphaNumericInput();
        Trainee trainee = employeeService.getTraineeById(traineeId);
        if (null != trainee) {
	    logger.info(employeeService.deleteTraineeById(traineeId));
	} else {
	    logger.info(" No Trainee Record Found ");
	}
    }

    /**
     * </p>
     * This method is used to delete Trainer  information by the user
     * </p>
     *
     * @return void - returns nothing
     */    
    public void deleteTrainerById() throws DatabaseException {
	logger.info(" Enter Trainer Id : ");
	String trainerId = getAlphaNumericInput();
        Trainer trainer = employeeService.getTrainerById(trainerId);
        if (null != trainer) {
	    logger.info(employeeService.deleteTrainerById(trainerId));
        } else {
	    logger.info(" No Trainer Record Found ");
        }
    }

    /**
     * <p>
     * This method is used to update Trainee  informations by the user 
     * and this method updates Email Id, Contact Number, Aadhar Number, Designation
     * </p>
     * 
     * @return void -  returns nothing
     */
    public void updateTraineeById() throws DatabaseException {
	boolean flag = true;
	while (flag) {
	    logger.info(" Which Details You want change ?\n");
	    logger.info(" For Email enter 1 \n");
	    logger.info(" For Contact Number enter 2\n");
	    logger.info(" For Aadhar Number enter 3 \n");
	    logger.info(" For Designation enter 4 \n");
	    logger.info(" For Exit enter 5\n");
	    int updateOption = getNumberInput(); 
	    logger.info(" Enter Trainee Id ");
            String traineeId = getAlphaNumericInput();
            Trainee trainee = employeeService.getTraineeById(traineeId);
	    if (null != trainee) {
                switch (updateOption) {
	        case 1 :
		    logger.info(" Enter new Email Id ");
		    String newEmailId = getEmailIdInput(1);
		    logger.info(employeeService.updateTraineeEmailIdById(traineeId, newEmailId));
		    break;
                case 2 :
		    logger.info(" Enter new Contact Number ");
		    long newContactNumber = getContactNumberInput(1);
		    logger.info(employeeService.updateTraineeContactNumberById(traineeId, newContactNumber));
                    break;
                case 3 :
		    logger.info(" Enter new Aadhar Number ");
		    long newAadharNumber = getAadharNumberInput(1);
		    logger.info(employeeService.updateTraineeAadharNumberById(traineeId, newAadharNumber));
		    break;
                case 4 :
		    logger.info(" Enter new Designation ");
		    String newDesignation = getStringInput();
		    logger.info(employeeService.updateTraineeDesignationById(traineeId, newDesignation));
		case 5:
		    flag = false;
		    break;
	        default:
		    logger.info(" Sorry You Entered Invalid Option\n Try Again");
	        }
	    } else {
		logger.info(" No Trainee Record Found");
	    } 
	}  	        
    }

    /**
     * <p>
     * This method is used to update Trainer  informations by the user 
     * and this method updates Email Id, Contact Number, Aadhar Number, Designation
     * </p> 
     *
     * @return void - returns nothing
     */	
    public void updateTrainerById() throws DatabaseException {
	boolean flag = true;
	while (flag) {
	    logger.info(" Which Details You want change ?\n");
	    logger.info(" For Email enter 1\n");
	    logger.info("For Contact Number enter 2\n");
	    logger.info(" For Aadhar Number enter 3\n");
	    logger.info(" For Designation enter 4 \n");
	    logger.info(" For Exit enter 5\n");
	    int updateOption = getNumberInput();
	    logger.info(" Enter Trainer Id ");
            String trainerId = getAlphaNumericInput();
            Trainer trainer = employeeService.getTrainerById(trainerId);
            if (null != trainer) {  
                switch (updateOption) {
	        case 1 :
		    logger.info(" Enter new Email Id ");
		    String newEmailId = getEmailIdInput(2);
		    logger.info(employeeService.updateTrainerEmailIdById(trainerId, newEmailId));
		    break;
                case 2 :
		    logger.info(" Enter new Contact Number ");
		    long newContactNumber = getContactNumberInput(2);
		    logger.info(employeeService.updateTrainerContactNumberById(trainerId, newContactNumber));
                    break;
                case 3 :
		    logger.info(" Enter new Aadhar Number ");
		    long newAadharNumber = getAadharNumberInput(2);
		    logger.info(employeeService.updateTrainerAadharNumberById(trainerId, newAadharNumber));
		    break;
                case 4 :
		    logger.info(" Enter new Designation ");
		    String newDesignation = getStringInput();
		    logger.info(employeeService.updateTrainerDesignationById(trainerId, newDesignation));
		    break;
		case 5 :
		    flag = false;
		    break;
	        default:
		    logger.info(" Sorry You Entered Invalid Option\n Try Again");
	        }
	    } else {
		    logger.info(" No Trainer Record Found ");
	    }      
        }
    } 

    /**
     * <p>
     * This method is to associate trainee to trainer 
     * </p>
     * @return void - returns nothing
     */
    public void associateTrainerToTrainee() throws DatabaseException {
	boolean isAssigned = true;
	while(isAssigned) {
	    String traineeId = getTraineeToAssociateTrainer();
	    String trainerId = "";
	    if (null != traineeId) {
	        trainerId = getTrainerToAssociateTrainee();
	    }
	    if (null != trainerId && null != traineeId) {
	        logger.info(employeeService.associateTrainerToTrainee(traineeId, trainerId));
	    }
	    logger.info(" Do you want continue the process ?");
	    logger.info(" Press 1 for yes \n Press 2 for no ");
	    int number = getNumberInput();
	    isAssigned = 1 == number;
	}
    }
    
    /**
     * <p>
     * This method is to get unassigned trainee to assign trainer
     * </p>
     * @return String - traineeid
     */
    public String getTraineeToAssociateTrainer() throws DatabaseException {
	String traineeId = "";
	List<Trainee> trainees = employeeService.getUnassignedTrainees();
	if (!trainees.isEmpty()) {
	    int index = 0;
	    for (Trainee trainee : trainees) {
	        index++;
	        logger.info(index + " " + trainee.getName() + " " +trainee.getId());
	    }
	    logger.info(" Enter trainee id : ");
	    traineeId = getAlphaNumericInput();
	} else {
	    logger.info("Sorry, no trainees");
	    traineeId = null;
	}
	return traineeId;
    }	
 
    /**
     * <p>
     * This method is to get available trainer to assign trainees
     * </p>
     * @return String - trainerid
     */
    public String getTrainerToAssociateTrainee() throws DatabaseException {
	String trainerId = "";
	List<Trainer> trainers = employeeService.getTrainers();
	if (!trainers.isEmpty()) {
	    int index = 0;
	    for (Trainer trainer : trainers) {
	        index++;
	        logger.info(index + " " + trainer.getName() + " " + trainer.getId());
	    }
	    logger.info(" Enter trainer id : ");
	    trainerId = getAlphaNumericInput();
        } else { 
	    logger.info(" Sorry, there is no trainers ");
	    return null;
        }
	return trainerId;  
    }
}

    
