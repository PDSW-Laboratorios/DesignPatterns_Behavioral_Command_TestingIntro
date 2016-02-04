/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.commandpattern_testing;

/**
 *
 * @author estudiante
 */
public class ExcepcionParametrosInvalidos extends Exception {

    public ExcepcionParametrosInvalidos(String message) {
        super(message);
    }

    public ExcepcionParametrosInvalidos(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ExcepcionParametrosInvalidos(Throwable cause) {
        super(cause);
    }

    public ExcepcionParametrosInvalidos(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
