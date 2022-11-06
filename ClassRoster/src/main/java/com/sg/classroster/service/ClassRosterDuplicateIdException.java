
package com.sg.classroster.service;

/**
 * @author emilytracey
 * date = 28/10/2022
 */

public class ClassRosterDuplicateIdException extends Exception {

    public ClassRosterDuplicateIdException(String message) {
        super(message); // call parent to handle message error shown to user
    }

    public ClassRosterDuplicateIdException(String message,
            Throwable cause) {
        super(message, cause); // call parent to hand message and show cause error to user
    }

}
