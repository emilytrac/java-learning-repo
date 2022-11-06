
package com.sg.classroster.dao;

/**
 * @author emilytracey
 * date = 25/10/2022
 */

public class ClassRosterPersistenceException extends Exception {
    
    public ClassRosterPersistenceException(String message) {
        super(message);
    }
    
    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
