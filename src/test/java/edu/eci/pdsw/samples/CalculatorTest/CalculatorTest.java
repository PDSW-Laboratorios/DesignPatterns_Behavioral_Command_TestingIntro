/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.CalculatorTest;

import edu.eci.pdsw.commandpattern_testing.CalculadoraTarifas;
import edu.eci.pdsw.commandpattern_testing.ExcepcionParametrosInvalidos;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {
    
    @Test
    public void testClaseEquivUno() throws Exception{
        CalculadoraTarifas ct=new CalculadoraTarifas();
        Assert.assertEquals("Se esta modificando el valor de la tarifa en un "
                + "caso en el que no aplica ningun descuento.",
                new Float(1000),
                new Float(ct.calculoTarifa(1000f, new DateTime(2015, 1, 20, 0, 0), 
                        new DateTime(2015, 1, 20, 0, 0), 30)));
        
    }
    
    /**
    * Pruebas clase de equivalencia Descuento Una Semana: Debería arrojar el valor 
    * de la tarifa base con el descuento del 25% aplicado
    **/
    @Test
    public void testClaseEquivalenciaDescuentoUnaSemana() throws Exception{
        CalculadoraTarifas ct=new CalculadoraTarifas();
        Assert.assertEquals("La tarifa no tiene un descuento del 25% cuando deberia darlo.", 
                new Float(1000*0.75), 
                new Float(ct.calculoTarifa(1000f, new DateTime(2015, 1, 12, 0, 0), 
                        new DateTime(2015, 1, 20, 0, 0), 30)));
    }
    
    /**
    * Pruebas clase de equivalencia Edad Negativa: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar una edad negativa
    **/
    @Test(expected=ExcepcionParametrosInvalidos.class)
    public void testClaseEquivalenciaEdadNegativa() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        float val = ct.calculoTarifa(1000f, new DateTime(2015,1,20,0,0), 
               new DateTime(2015,1,20,0,30), -1);
        System.out.println("Debe lanzar excepcion si se pasa una edad negativa como parametro");
    }
    
    /**
    * Pruebas clase de equivalencia Tarifa Base Igual a Cero: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar una tarifa base igual
    * a cero
    **/
    @Test
    public void testClaseEquivalenciaTarifaIgualACero() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        try {
            float val = ct.calculoTarifa(0f, new DateTime(2015,1,20,0,0), 
               new DateTime(2015,1,20,0,30), 25);
            Assert.fail("Deberia lanzar excepcion la tarifa es igual a cero");
        } catch (ExcepcionParametrosInvalidos e){
        }
    }
    
    /**
    * Pruebas clase de equivalencia Tarifa Base Menor a Cero: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar una tarifa base
    * menor a cero
    **/
    @Test
    public void testClaseEquivalenciaTarifaMenorDeCero() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        
        try {
            float val = ct.calculoTarifa(-1f, new DateTime(2015,1,20,0,0), 
               new DateTime(2015,1,20,0,30), 25);
            Assert.fail("Deberia lanzar excepcion la tarifa es negativa");
        } catch (ExcepcionParametrosInvalidos e){
        }
    }
    
    /**
    * Pruebas clase de equivalencia Fechas Invalidas: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar la fecha actual mayor
    * a la fecha del vuelo
    **/
    @Test
    public void testClaseEquivalenciaFechasInvalidas() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        try {
            float val = ct.calculoTarifa(1000f, new DateTime(2015,1,20,0,0), 
               new DateTime(2015,1,12,0,30), 25);
            Assert.fail("Deberia lanzar excepcion si la fecha actual es mayor a la fecha del vuelo");
        } catch (ExcepcionParametrosInvalidos e){
        }
    }
    
    /**
    * Pruebas clase de equivalencia Fecha Actual Incorrecta: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar alguno de los parametros
    * de fecha con valor incorrecto como Null
    **/
    @Test(expected=ExcepcionParametrosInvalidos.class)
    public void testClaseEquivalenciaFechaActualIncorrecta() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        float val = ct.calculoTarifa(1000f, null, 
               new DateTime(2015,1,20,0,0), 30);
        System.out.println("Debe lanzar excepcion si se pasa una fecha con valor nulo");
    }
    
    /**
    * Pruebas clase de equivalencia Fecha Vuelo Incorrecta: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar alguno de los parametros
    * de fecha con valor incorrecto como Null
    **/
    @Test(expected=ExcepcionParametrosInvalidos.class)
    public void testClaseEquivalenciaFechaVueloIncorrecta() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        float val = ct.calculoTarifa(1000f, new DateTime(2015,1,20,0,0), 
               null, 30);
        System.out.println("Debe lanzar excepcion si se pasa una fecha con valor nulo");
    }
    
    /**
    * Pruebas clase de equivalencia Parametro Incorrecto: Valida que la excepción de
    * Parametros invalidos se genere al momento de ingresar alguno de los parametros
    * de fecha con valor incorrecto como Null
    **/
    @Test(expected=ExcepcionParametrosInvalidos.class)
    public void testClaseEquivalenciaFechasIncorrectas() throws Exception {
        CalculadoraTarifas ct=new CalculadoraTarifas();
        float val = ct.calculoTarifa(1000f, null, 
               null, 30);
        System.out.println("Debe lanzar excepcion si se pasa una fecha con valor nulo");
    }
}
