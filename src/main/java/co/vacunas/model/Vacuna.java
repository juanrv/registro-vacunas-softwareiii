package co.vacunas.model;

import co.vacunas.model.exception.BussinessException;
import co.vacunas.util.Mensajes;
import co.vacunas.util.Validador;

import java.util.Date;

public class Vacuna {
    private Long idVacuna;
    private String nombre;
    private Date fechaCaducidad;

    private Vacuna (){
        super();
    }

    public static class VacunaBuilder{
        private Long idVacuna;
        private String nombre;
        private Date fechaCaducidad;

        public VacunaBuilder setIdVacuna(Long idVacuna) {
            this.idVacuna = idVacuna;
            return this;
        }

        public VacunaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public VacunaBuilder setFechaCaducidad(Date fechaCaducidad) {
            this.fechaCaducidad = fechaCaducidad;
            return this;
        }
        public Vacuna build() throws BussinessException{
            Vacuna vacuna = new Vacuna();
            Validador.numeroNulo(idVacuna, Mensajes.ID_NULO_VACUNA);
            Validador.numeroCero(idVacuna,Mensajes.ID_CERO_VACUNA);
            vacuna.idVacuna = idVacuna;
            Validador.textoNulo(nombre,Mensajes.NOMBRE_NULO_VACUNA);
            Validador.textoVacio(nombre,Mensajes.NOMBRE_VACIO_VACUNA);
            vacuna.nombre = nombre;
            Validador.fechaNula(fechaCaducidad, Mensajes.FECHA_NULA_VACUNA);
            vacuna.fechaCaducidad = fechaCaducidad;
            return vacuna;
        }
    }

    public Long getIdVacuna() {
        return idVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }
}
