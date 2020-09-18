package co.vacunas.model;

import co.vacunas.model.exception.BussinessException;
import co.vacunas.util.Mensajes;
import co.vacunas.util.Validador;

import java.util.Date;

public class HistoricoVacuna {
    private Long idHistorico;
    private Paciente paciente;
    private Vacuna vacuna;
    private Date fechaAplicación;

    private HistoricoVacuna (){
        super();
    }

    public static class HistoricoVacunaBuilder{
        private Long idHistorico;
        private Paciente paciente;
        private Vacuna vacuna;
        private Date fechaAplicación;

        public HistoricoVacunaBuilder setIdHistorico(Long idHistorico) {
            this.idHistorico = idHistorico;
            return this;
        }

        public HistoricoVacunaBuilder setPaciente(Paciente paciente) {
            this.paciente = paciente;
            return this;
        }

        public HistoricoVacunaBuilder setVacuna(Vacuna vacuna) {
            this.vacuna = vacuna;
            return this;
        }

        public HistoricoVacunaBuilder setFechaAplicación(Date fechaAplicación) {
            this.fechaAplicación = fechaAplicación;
            return this;
        }
        public HistoricoVacuna build() throws BussinessException {
            HistoricoVacuna historicoVacuna = new HistoricoVacuna();
            Validador.numeroNulo(idHistorico, Mensajes.ID_NULO_HISTORICO);
            Validador.numeroCero(idHistorico, Mensajes.ID_CERO_HISTORICO);
            historicoVacuna.idHistorico = idHistorico;
            Validador.objetoNulo(paciente, Mensajes.PACIENTE_NO_NULO);
            historicoVacuna.paciente = paciente;
            Validador.objetoNulo(vacuna, Mensajes.VACUNA_NO_NULA);
            historicoVacuna.vacuna = vacuna;
            Validador.fechaNula(fechaAplicación, Mensajes.FECHA_APLICACIÓN_NULA);
            historicoVacuna.fechaAplicación = fechaAplicación;
            return historicoVacuna;
        }
    }

    public Long getIdHistorico() {
        return idHistorico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public Date getFechaAplicación() {
        return fechaAplicación;
    }
}
