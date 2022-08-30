package com.element5.employee.utils;

import java.util.regex.Pattern;

/**
 * <h1> Constant Util class </h1>
 * <p>
 * This constant util class have the common pattern for the validation
 * methods to validate the value with this pattern
 * </p>
 *
 * @author M Ashok Kumar
 *
 * @since 05/08/2022
 */ 
public class CommonUtil {
    static Pattern datePattern = Pattern.compile("(([12][0-9]|3[01]|0?[1-9])/(0?[1-9]|1[012])/(?:19|20)\\d\\d)");
    static String emailPattern = "^[a-zA-Z]+[0-9]{4}+[@]+[gmail]+[.]+[a-z]{3}$";
    static String alphaNumericPattern = "^[E]+[0-9]{5}$";
    static String stringPattern = "[a-zA-z]+";
}