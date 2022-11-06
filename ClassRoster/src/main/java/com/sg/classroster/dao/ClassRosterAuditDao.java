
package com.sg.classroster.dao;

/**
 * @author emilytracey
 * date = 28/10/2022
 */

public interface ClassRosterAuditDao {
   
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
   
}
