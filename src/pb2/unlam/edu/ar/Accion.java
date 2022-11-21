package pb2.unlam.edu.ar;

import java.util.Date;

public class Accion {
    private Integer idAccion;
    private Alarma alarma;
    private Usuario usuario;
    private Date fecha;
    private TipoOperacion tipoOp;

    public Accion(Integer idAccion, Alarma alarma, Usuario usuario, Date fecha, TipoOperacion tipoOp) {
        this.idAccion = idAccion;
        this.alarma = alarma;
        this.usuario = usuario;
        this.fecha = fecha;
        this.tipoOp = tipoOp;
    }
}
