package pb2.unlam.edu.ar;

import java.util.ArrayList;

public class Central {
    private String nombreCentral;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Alarma> alarmas;

    public Central(String nombreCentral) {
        this.nombreCentral = nombreCentral;
        this.usuarios = new ArrayList<>();
        this.alarmas = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Alarma> getAlarmas() {
        return alarmas;
    }

    public void registrarUsuario(Usuario usuario) throws UsuarioYaRegistradoException {
        if (!(usuarios.contains(usuario))){
            this.usuarios.add(usuario);
        } else {
            throw new UsuarioYaRegistradoException("El usuario ya está registrado");
        }
    }

    public void registrarAlarma(Alarma alarma) {
        this.alarmas.add(alarma);
    }

    public Boolean buscarAlarma(Integer idAlarma) {
        for (Alarma a : alarmas){
            if (a.getIdAlarm().equals(idAlarma)){
                    return true;
            }
        }
        return false;
    }

    public Alarma obtenerAlarmaPorCodConf(String codConf) throws CodigoAlarmaIncorrectoException {
        for (Alarma a : alarmas) {
            if (a.getCodConf().equals(codConf)){
                return a;
            }
        }
        throw new CodigoAlarmaIncorrectoException("El codigo de confirmacion ingresado es incorrecto");
    }

    public Usuario obtenerUsuarioPorDni(Integer dniUsuario) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getDniUser().equals(dniUsuario)){
                return u;
            }
        }
        throw new UsuarioNoEncontradoException("El usuario buscado no fue encontrado");
    }

    public Alarma obtenerAlarmaPorId(Integer idAlarma) throws IdAlarmaIncorrectoException {
        for (Alarma a : alarmas) {
            if (a.getIdAlarm().equals(idAlarma)){
                return a;
            }
        }
        throw new IdAlarmaIncorrectoException("El id de la alarma ingresado es incorrecto");
    }
}
