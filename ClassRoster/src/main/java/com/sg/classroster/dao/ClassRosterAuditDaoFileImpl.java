
package com.sg.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * @author emilytracey
 * date = 28/10/2022
 */

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
    
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
        
        // true does it in append mode so that not everything is overwritten
        
        try {
            out = new PrintWriter( new FileWriter(AUDIT_FILE, true));
        } catch(IOException e) {
            throw new ClassRosterPersistenceException("Could not persist"
                    + " audit infomration.", e);
        }
        
        // Java Date-Time API 
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }

}
