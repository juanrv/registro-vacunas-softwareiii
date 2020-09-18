package co.vacunas.model;

import co.vacunas.model.exception.BussinessException;
import co.vacunas.util.Mensajes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteTest {

    @Test
    public void requeriIdCasoCero(){
        try{
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(0l)
                    .build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.ID_CERO_PACIENTE,ex.getMessage());
        }
    }

    @Test
    public void requerirIdCasoNulo (){
        try{
            Paciente paciente = new Paciente.PacienteBuilder().build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.ID_NULO_PACIENTE, ex.getMessage());
        }
    }

    @Test
    public void nombrePacienteNulo (){
        try{
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l).build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.NOMBRE_NULO_PACIENTE, ex.getMessage());
        }
    }
    @Test
    public void requerirRazaCasoNulo (){
        try {
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l)
                    .setNombre("Luna")
                    .setEspecie("Felino")
                    .build();
        }catch (BussinessException ex){
            assertEquals(Mensajes.RAZA_NULO_PACIENTE,ex.getMessage());
        }
    }
    @Test
    public void requerirNombreResponsable(){
        try{
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l)
                    .setNombre("Coco")
                    .setEspecie("Dragon")
                    .setRaza("Wyvern")
                    .setTelefono(26469714l)
                    .build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.NOMBRE_DUENO_NULO, ex.getMessage());
        }
    }
    @Test
    public void requerirRazaCasoVacio (){
        try {
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l)
                    .setNombre("Luna")
                    .setEspecie("Felino")
                    .setRaza("        ")
                    .build();
        }catch (BussinessException ex){
            assertEquals(Mensajes.RAZA_VACIO_PACIENTE,ex.getMessage());
        }
    }
    @Test
    public void verDatosPaciente(){

        try{
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l)
                    .setNombre("Luna")
                    .setEspecie("Felino")
                    .setRaza("Angora")
                    .setNombreDueno("Yagoo")
                    .setTelefono(42424244l)
                    .build();
            assertEquals("1LunaFelinoAngoraYagoo42424244",paciente.getIdPaciente()+
                    paciente.getNombre()+paciente.getEspecie()+paciente.getRaza()+paciente.getNombreDueno()+paciente.getTelefono());
        }
        catch (BussinessException ex){

        }
    }
}