package co.vacunas.model;

import co.vacunas.model.exception.BussinessException;
import co.vacunas.util.Mensajes;
import co.vacunas.util.Validador;

public class Paciente {
    private Long idPaciente;
    private String nombre;
    private String especie;
    private String raza;
    private String nombreDueno;
    private Long telefono;

    private Paciente (){
        super();
    }

    public static class PacienteBuilder{
        private Long idPaciente;
        private String nombre;
        private String especie;
        private String raza;
        private String nombreDueno;
        private Long telefono;

        public PacienteBuilder setIdPaciente(Long idPaciente) {
            this.idPaciente = idPaciente;
            return this;
        }

        public PacienteBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public PacienteBuilder setEspecie(String especie) {
            this.especie = especie;
            return this;
        }

        public PacienteBuilder setRaza(String raza) {
            this.raza = raza;
            return this;
        }

        public PacienteBuilder setNombreDueno(String nombreDueno) {
            this.nombreDueno = nombreDueno;
            return this;
        }

        public PacienteBuilder setTelefono(Long telefono) {
            this.telefono = telefono;
            return this;
        }
        public Paciente build() throws BussinessException {
            Paciente paciente = new Paciente();
            Validador.numeroNulo(idPaciente,Mensajes.ID_NULO_PACIENTE);
            Validador.numeroCero(idPaciente,Mensajes.ID_CERO_PACIENTE);
            paciente.idPaciente = idPaciente;
            Validador.textoNulo(nombre,Mensajes.NOMBRE_NULO_PACIENTE);
            Validador.textoVacio(nombre,Mensajes.NOMBRE_VACIO_PACIENTE);
            paciente.nombre = nombre;
            Validador.textoNulo(especie, Mensajes.ESPECIE_NULO_PACIENTE);
            Validador.textoVacio(especie, Mensajes.ESPECIE_VACIO_PACIENTE);
            paciente.especie = especie;
            Validador.textoNulo(raza, Mensajes.RAZA_NULO_PACIENTE);
            Validador.textoVacio(raza,Mensajes.RAZA_VACIO_PACIENTE);
            paciente.raza = raza;
            Validador.textoNulo(nombreDueno,Mensajes.NOMBRE_DUENO_NULO);
            Validador.textoVacio(nombreDueno,Mensajes.NOMBRE_DUENO_VACIO);
            paciente.nombreDueno = nombreDueno;
            Validador.numeroNulo(telefono,Mensajes.TELEFONO_NULO_PACIENTE);
            Validador.numeroCero(telefono,Mensajes.TELEFONO_CERO_PACIENTE);
            paciente.telefono = telefono;
            return paciente;
        }
    }
    public Long getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public Long getTelefono() {
        return telefono;
    }
}
