package co.vacunas.model;

import co.vacunas.model.exception.BussinessException;
import co.vacunas.util.Mensajes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VacunaTest {

    @Test
    public void requerirNombreVacuna () {
        try {
            Vacuna vacuna = new Vacuna.VacunaBuilder()
                    .setIdVacuna(1l)
                    .build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.NOMBRE_NULO_VACUNA, ex.getMessage());
        }
    }

    @Test
    public void requerirNombreVacunaCasoVacio (){
        try{
            Vacuna vacuna = new Vacuna.VacunaBuilder()
                    .setIdVacuna(1l)
                    .setNombre("            ")
                    .build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.NOMBRE_VACIO_VACUNA,ex.getMessage());
        }
    }

    @Test
    public void requerirFecha (){
        try{
            Vacuna vacuna = new Vacuna.VacunaBuilder()
                    .setIdVacuna(1l)
                    .setNombre("COSA")
                    .build();
        }
        catch (BussinessException ex) {
            assertEquals(Mensajes.FECHA_NULA_VACUNA, ex.getMessage());
        }
    }

    @Test
    public void verDatosVacuna(){
        try{
            Calendar fechaAEnviar = Calendar.getInstance();
            fechaAEnviar.set(2020,01,07,0,0,0);
            Date fecha = fechaAEnviar.getTime();
            Vacuna vacuna = new Vacuna.VacunaBuilder()
                    .setIdVacuna(1l)
                    .setNombre("COSA")
                    .setFechaCaducidad(fecha)
                    .build();
            assertEquals("1COSA"+fechaAEnviar.getTime().toString(), vacuna.getIdVacuna()+vacuna.getNombre()+vacuna.getFechaCaducidad().toString());
        }
        catch (BussinessException ex){

        }
    }
}