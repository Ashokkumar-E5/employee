/**
 * <p>Package for Date Util class</p>
 * @Copyright 2022 Element5
 */
package com.element5.employee.utils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

/**
 * <h1><b>This is DateUtil class </b></h1>
 * <p> 
 * This class have the years calculating methods and date validating methods 
 * and all the methods are static 
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  10 / 08 / 2022
 */
public class DateUtil {

    /**
     * <p>
     * This method is to calculate the years
     * </p>
     *
     * @param String date - this date to calculate the years.
     *
     * @return int - returns years
     */
    public static int calculateYears(String date) {
        String currentDate = LocalDate.now().toString();
	String givenDate = date.split("-")[2];
	String year = date.split("-")[0];
	int years = Integer.parseInt(year) - Integer.parseInt(givenDate);
	return years;
    }
 
    /**
     * <p>
     * This method is to validate date format
     * </p>
     *
     * @param String date - this date to validate with pattern.
     *
     * @return boolean - returns true if the given date is matches the given pattern.
     */
    public static LocalDate isValidDateFormat(String date) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	return LocalDate.parse(date,formatter);
    }
}