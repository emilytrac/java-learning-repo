
package com.sg.classroster.service;

/**
 * @author emilytracey
 * date = 28/10/2022
 */

public class ClassRosterDataValidationException extends Exception {

    public ClassRosterDataValidationException(String message) {
        super(message);
    }
    
    public ClassRosterDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
