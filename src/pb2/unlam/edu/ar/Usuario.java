package pb2.unlam.edu.ar;

public class Usuario {
    protected Integer dniUser;
    protected String nombreUser;

    public Usuario(Integer dniUser, String nombreUser) {
        this.dniUser = dniUser;
        this.nombreUser = nombreUser;
    }

    public Integer getDniUser() {
        return dniUser;
    }

    public void setDniUser(Integer dniUser) {
        this.dniUser = dniUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }
}
