
package com.sg.classroster.ui;

import java.util.Scanner;

/**
 * @author emilytracey
 * date = 25/10/2022
 */

public class UserIOConsoleImpl implements UserIO {
        
    final private Scanner console = new Scanner(System.in);
    
    // print a given String to the console

    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    // display a given message String to prompt the user to enter in a String, then read in the user response as a String and return that value

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    // display a given message String to prompt the user to enter in an integer, then read in the user response and return that integer value
    
    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int response = 0;
        while (invalidInput) {
            try {
                String stringValue = this.readString(prompt);
                response = Integer.parseInt(stringValue);
                break;
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return response;
    }
    
    // display a prompt to the user to enter an integer between a specified min and max range, and read in an integer.

    @Override
    public int readInt(String prompt, int min, int max) {
        int response = 0;
        do {
            response = readInt(prompt);
        } while(response < min || response > max);
        
        return response;
    }
    
    // display a given message String to prompt the user to enter in a double, then read in the user response and return that double value
    
    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }    
    }
    
    // display a prompt to the user to enter a double between a specified min and max range, and read in a double

    @Override
    public double readDouble(String prompt, double min, double max) {
        double response = 0;
        do {
            response = readInt(prompt);
        } while(response < min || response > max);
        
        return response;
    }
    
    // display a given message String to prompt the user to enter a float and then read in the user response and return that float value

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }    
    }
    
    // display a prompt to the user to enter a float between a specified min and max range, and read in a float.

    @Override
    public float readFloat(String prompt, float min, float max) {
        float response = 0;
        do {
            response = readInt(prompt);
        } while(response < min || response > max);
        
        return response;
    }
    
    // display a given message String to prompt the user to enter a long and then read in the user response and return that long value

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }  
    }
    
    // display a prompt to the user to enter a long between a specified min and max range, and read in a long.

    @Override
    public long readLong(String prompt, long min, long max) {
        long response = 0;
        do {
            response = readInt(prompt);
        } while(response < min || response > max);
        
        return response;
    }
}
