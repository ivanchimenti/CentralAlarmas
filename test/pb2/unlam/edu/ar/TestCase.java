package pb2.unlam.edu.ar;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCase {
    @Test
    public void queSePuedaRegistrarUnaAlarmaEnLaCentral() throws UsuarioYaRegistradoException, UsuarioNoRegistradoException {
        Central central = new Central("PAS Seguridad");
        Usuario usuarioAdm = new Administrador(16996589, "Antonio");
        Alarma alarma = new Alarma(1174, "I1912A", "T1416M", "Casa");
        central.registrarUsuario(usuarioAdm);
        assertTrue(((Administrador) usuarioAdm).registrarAlarmaEnLaCentral(central, alarma));
    }

    @Test
    public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws UsuarioYaRegistradoException, UsuarioNoRegistradoException {
        Central central = new Central("PAS Seguridad");
        Usuario usuarioAdm = new Administrador(16996589, "Antonio");
        Alarma alarma = new Alarma(1174, "I1912A", "T1416M", "Casa");
        Usuario usuarioConf = new Configurador(22862944, "Marta");

        central.registrarUsuario(usuarioAdm);
        assertTrue(((Administrador) usuarioAdm).registrarAlarmaEnLaCentral(central, alarma));
        assertTrue(((Administrador) usuarioAdm).registrarUsuarioEnLaCentral(central, usuarioConf));
        assertTrue(((Administrador) usuarioAdm).registrarUsuarioEnLaAlarma(alarma, usuarioConf));
    }

    @Test (expected = CodigoAlarmaIncorrectoException.class)
    public void queAlAgregarUnUsuarioAUnaAlarmaConCodDeConfDeAlarmaInvalidoSeLanceUnaExcepcion() throws CodigoAlarmaIncorrectoException, UsuarioYaRegistradoException, UsuarioNoRegistradoException, UsuarioNoEncontradoException {
        Central central = new Central("PAS Seguridad");
        Usuario usuarioAdm = new Administrador(16996589, "Antonio");
        Alarma alarma = new Alarma(1174, "I1912A", "T1416M", "Casa");
        Usuario usuarioConf = new Configurador(22862944, "Marta");

        central.registrarUsuario(usuarioAdm);
        ((Administrador) usuarioAdm).registrarAlarmaEnLaCentral(central, alarma);
        ((Administrador) usuarioAdm).registrarUsuarioEnLaCentral(central, usuarioConf);
        ((Administrador) usuarioAdm).registrarUsuarioEnLaAlarmaConCod(central, 22862944, 1174, "XXXXX");
    }

    @Test (expected = SensorDuplicadoException.class)
    public void queAlAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaExcepcion() throws SensorDuplicadoException {
        Central central = new Central("PAS Seguridad");
        Usuario usuarioAdm = new Administrador(16996589, "Antonio");
        Alarma alarma = new Alarma(1174, "I1912A", "T1416M", "Casa");
        Sensor sensor1 = new Sensor(4462, true);
        Sensor sensor2 = new Sensor(2823, true);
        Sensor sensor3 = new Sensor(4462, true);

        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor1);
        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor2);
        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor3);
    }

    @Test
    public void queNoSePuedaActivarLaAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDuplicadoException, IdAlarmaIncorrectoException {
        Central central = new Central("PAS Seguridad");
        Usuario usuarioAdm = new Administrador(16996589, "Antonio");
        Alarma alarma = new Alarma(1174, "IA1912", "TM1416", "Casa");
        Sensor sensor1 = new Sensor(4462, true);
        Sensor sensor2 = new Sensor(2823, true);
        Sensor sensor3 = new Sensor(6455, false);
        Sensor sensor4 = new Sensor(6532, true);

        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor1);
        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor2);
        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor3);
        ((Administrador) usuarioAdm).agregarSensorAUnaAlarma(alarma, sensor4);

        ((Administrador) usuarioAdm).actDesactAlarma(central, 1174, "IA1912");


    }
}
