package pb2.unlam.edu.ar;

public class Administrador extends Usuario {

    public Administrador(Integer dni, String nombre) {
        super(dni, nombre);
    }

    public Boolean registrarAlarmaEnLaCentral(Central central, Alarma alarma) throws UsuarioNoRegistradoException {
        if (central.getUsuarios().contains(this)){
            central.registrarAlarma(alarma);
            alarma.registrarUsuario(this);
            return true;
        } else {
            throw new UsuarioNoRegistradoException("El usuario no está registrado en la central");
        }
    }

    public Boolean registrarUsuarioEnLaCentral(Central central, Usuario usuarioConf) throws UsuarioYaRegistradoException {
        central.registrarUsuario(usuarioConf);
        return true;
    }

    public Boolean registrarUsuarioEnLaAlarma(Alarma alarma, Usuario usuarioConf) {
        alarma.registrarUsuario(usuarioConf);
        return true;
    }

    public void registrarUsuarioEnLaAlarmaConCod(Central central, Integer dniUsuario, Integer idAlarma, String codConf) throws CodigoAlarmaIncorrectoException, UsuarioNoEncontradoException {
        if(central.buscarAlarma(idAlarma)){
            Alarma alarma = central.obtenerAlarmaPorCodConf(codConf);
            alarma.registrarUsuario(central.obtenerUsuarioPorDni(dniUsuario));
        }
    }

    public Boolean agregarSensorAUnaAlarma(Alarma a, Sensor s) throws SensorDuplicadoException {
        if (!(a.getSensores().contains(s))){
            a.getSensores().add(s);
            return true;
        } else {
            throw new SensorDuplicadoException("El sensor está duplicado");
        }
    }

    public void actDesactAlarma(Central central, Integer idAlarma, String codActDesact) throws IdAlarmaIncorrectoException {
        Alarma alarma = central.obtenerAlarmaPorId(idAlarma);
    }
}
