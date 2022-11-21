package pb2.unlam.edu.ar;

import java.util.Objects;

public class Sensor {
    private Integer idSensor;
    private Boolean estado;

    public Sensor(Integer idSensor, Boolean estado) {
        this.idSensor = idSensor;
        this.estado = estado;
    }

    public Integer getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {
        this.idSensor = idSensor;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(idSensor, sensor.idSensor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSensor);
    }
}
