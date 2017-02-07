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
package edu.eci.pdsw.commandpattern_testing;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class CalculadoraTarifas {

    /**
     * calcular la tarifa de cada billete segun el trayecto, la antelacion en la
     * que se obtiene el billete y la edad del pasajero, de acuerdo con la
     * normativa 005:
     * 
     * 	Normativa 005, sobre los descuentos:
     *   15% de descuento sacando el billete con antelacion superior a 1 semana 
     *    y 25% con antelacion superior a 1 mes (30 dias). 
     *   30% a los pasajeros con edad inferior a 25 anos y 40% a los pasajeros 
     *    con edad superior a 65 anos.
     * 
     *  Los descuentos no son acumulables y siempre se aplicara el de mayor 
     *  valor.
     *
     * @param tarifaBase valor base del vuelo
     * @param fechaActual la fecha a partir de la cual se realiza el calculo
     * @param fechaVuelo fecha del vuelo reservado
     * @param edad - edad del pasajero
     * @return la tarifa ajustada
     * @throws ExcepcionParametrosInvalidos [XXXXXXXXXXXXXXXXXXXXXXXXXXX]
 *
     */
    public float calculoTarifa(float tarifaBase, DateTime fechaActual, DateTime fechaVuelo, int edad) throws ExcepcionParametrosInvalidos{
        float descuentoTarifaBaseFecha=tarifaBase;
        float descuentoTarifaBaseEdad=tarifaBase;
        
        if (Days.daysBetween(fechaActual, fechaVuelo).getDays()>7){
            descuentoTarifaBaseFecha=tarifaBase-(tarifaBase*0.15f);
        }
        else if(Days.daysBetween(fechaActual, fechaVuelo).getDays()>30){
            descuentoTarifaBaseFecha=tarifaBase-(tarifaBase*0.25f);
        }        
        else if (edad<25){
            descuentoTarifaBaseEdad=tarifaBase-(tarifaBase*0.3f);
        }
        else if (edad <25 && edad>65){
            descuentoTarifaBaseEdad=tarifaBase-(tarifaBase*0.4f);
        }        
        
        if (descuentoTarifaBaseFecha>descuentoTarifaBaseEdad){
            return descuentoTarifaBaseFecha;
        }
        else{
            return descuentoTarifaBaseEdad;
        }
        
    }

}
