package co.vacunas.model;

import co.vacunas.model.exception.BussinessException;
import co.vacunas.util.Mensajes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HistoricoVacunaTest {

    Date fecha = new Date();

    @Test
    public void registrarHistorico(){
        try{
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l)
                    .setNombre("Rushia")
                    .setNombreDueno("Yagoo")
                    .setEspecie("Neko")
                    .setRaza("Angora")
                    .setTelefono(231399499l)
                    .build();
            Vacuna vacuna = new Vacuna.VacunaBuilder()
                    .setIdVacuna(1l)
                    .setNombre("Vacuna trivalente")
                    .setFechaCaducidad(fecha)
                    .build();
            HistoricoVacuna historicoVacuna = new HistoricoVacuna.HistoricoVacunaBuilder()
                    .setPaciente(paciente)
                    .setIdHistorico(1l)
                    .setVacuna(vacuna)
                    .setFechaAplicación(fecha)
                    .build();
            assertNotEquals(null, historicoVacuna);
        }
        catch (BussinessException ex){
                System.out.println(ex);
        }
    }

    @Test
    public void requerirPaciente(){
        try{
            Vacuna vacuna = new Vacuna.VacunaBuilder()
                    .setIdVacuna(1l)
                    .setNombre("Vacuna trivalente")
                    .setFechaCaducidad(fecha)
                    .build();
            HistoricoVacuna historicoVacuna = new HistoricoVacuna.HistoricoVacunaBuilder()
                    .setVacuna(vacuna)
                    .setIdHistorico(1l)
                    .setFechaAplicación(fecha)
                    .build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.PACIENTE_NO_NULO,ex.getMessage());
        }
    }

    @Test
    public void requerirVacuna(){
        try{
            Paciente paciente = new Paciente.PacienteBuilder()
                    .setIdPaciente(1l)
                    .setNombre("Rushia")
                    .setNombreDueno("Yagoo")
                    .setEspecie("Neko")
                    .setRaza("Angora")
                    .setTelefono(231399499l)
                    .build();
            HistoricoVacuna historicoVacuna = new HistoricoVacuna.HistoricoVacunaBuilder()
                    .setIdHistorico(1l)
                    .setPaciente(paciente)
                    .setFechaAplicación(fecha)
                    .build();
        }
        catch (BussinessException ex){
            assertEquals(Mensajes.VACUNA_NO_NULA, ex.getMessage());
        }
    }

}