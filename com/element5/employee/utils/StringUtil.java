/**
 * <p>Package for String Util class</p>
 *
 * @Copyright 2022 Element5
 */
package com.element5.employee.utils;

import com.element5.employee.utils.CommonUtil;

/**
 * <h1>
 * This is StringUtil class 
 * </h1>
 *
 * <p> 
 * This class have the String validating methods 
 * and all the methods are static 
 * </p>
 *
 * @author  Ashok Kumar M
 *
 * @since  07 / 07 / 2022
 */
public class StringUtil {

    /**
     * <p>
     * This method is to validate Email Id
     * </p>
     * @param String emailId - this email id is to valid with the pattern.
     *
     * @return boolean - returns true if the given email Id is matches the given pattern
     */
    public static boolean isValidEmailId(String emailId) {
        return (emailId.matches(CommonUtil.emailPattern));
    }

    /**
     * <p>
     * This method is to validate Strings with the given pattern
     * </p>
     *
     * @param String words - this words to validate with the pattern
     *
     * @return boolean - returns true if the given words is matches the condition
     */
    public  static boolean isValidString(String words) {
	return words.matches(CommonUtil.stringPattern);
    }
   
    /**
     * <p>
     * This method is to validate Alpha Numeric
     * </p>
     *
     * @param String words - this words is to validate with the alpha numeric
     *
     * @return boolean - returns true if the given words is matches the condition
     */
    public  static boolean isValidAlphaNumeric(String words) {
	return words.matches(CommonUtil.alphaNumericPattern) ? true : false;
    }

   /**
     * <p>
     * This method is to validate gender
     * </p>
     *
     * @param String gender - this gender is to validate .
     *
     * @return boolean - returns true if the given gender is matches the condition
     */
   public static boolean isValidGender(String gender) {
	return ((gender.toLowerCase().equals("female")) || (gender.toLowerCase().equals("male"))
                  || (gender.toLowerCase().equals("transgender"))) ? true : false;
   }

}