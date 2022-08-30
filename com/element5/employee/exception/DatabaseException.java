package com.element5.employee.exception;

/**
 * <h1>
 * DatabaseException class
 * </h1>
 *
 * <p>
 * This is class is to handle the all the database exceptions
 * in database and referenced class
 * </p>
 *
 * @author Ashok Kumar M
 *
 * @since 24/08/2022
 */
public class DatabaseException extends Exception {

    public DatabaseException(String exception) {
	super(exception);
    }
}