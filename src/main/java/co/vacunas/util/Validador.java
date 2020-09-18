package co.vacunas.util;

import co.vacunas.model.exception.BussinessException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Validador {
    public static void objetoNulo(Object objeto, String mensaje) throws BussinessException{
        if(objeto == null){
            throw new BussinessException(mensaje);
        }
    }
    public static void textoVacio (String texto, String mensaje) throws BussinessException{
        if(texto.trim().equals("")){
            throw new BussinessException(mensaje);
        }
    }
    public static void textoNulo (String texto, String mensaje) throws BussinessException{
        if(texto == null){
            throw new BussinessException(mensaje);
        }
    }
    public static void numeroCero (Long numero, String mensaje) throws BussinessException{
        if(numero == 0){
            throw new BussinessException(mensaje);
        }
    }
    public static void numeroNulo (Long numero, String mensaje) throws BussinessException{
        if(numero == null){
            throw new BussinessException(mensaje);
        }
    }
    public static void fechaNula (Date fecha, String mensaje) throws BussinessException{
        if(fecha == null){
            throw new BussinessException(mensaje);
        }
    }
    public static void validarRangoFecha (Date fecha, String mensaje) throws  BussinessException{
        Calendar fechaMaxima = Calendar.getInstance();
        fechaMaxima.add(Calendar.MONTH, - 2);
        if(fecha.before(fechaMaxima.getTime())){
            throw new BussinessException(mensaje);
        }
    }
}
