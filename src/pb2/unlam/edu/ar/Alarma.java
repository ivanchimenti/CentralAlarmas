package pb2.unlam.edu.ar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Alarma {
    private Integer idAlarm;
    private String codActDesact;
    private String codConf;
    private String nombre;
    private ArrayList<Usuario> usuariosValidos;
    private ArrayList<Accion> acciones;
    private Set<Sensor> sensores;

    public Alarma(Integer idAlarm, String codActDesact, String codConf, String nombre) {
        this.idAlarm = idAlarm;
        this.codActDesact = codActDesact;
        this.codConf = codConf;
        this.nombre = nombre;
        this.usuariosValidos = new ArrayList<>();
        this.acciones = new ArrayList<>();
        this.sensores = new HashSet<>();
    }

    public Integer getIdAlarm() {
        return idAlarm;
    }

    public String getCodActDesact() {
        return codActDesact;
    }

    public String getCodConf() {
        return codConf;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Usuario> getUsuariosValidos() {
        return usuariosValidos;
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public Set<Sensor> getSensores() {
        return sensores;
    }

    public void registrarUsuario(Usuario usuario){
        this.usuariosValidos.add(usuario);
    }

    public void registrarAccion(Accion accion){
        this.acciones.add(accion);
    }

    public void registrarSensor(Sensor sensor){
        this.sensores.add(sensor);
    }

}
