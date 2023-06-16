public class Llamada {
    //Variables para el registro
    private String contacto;
    private String compania;
    private String horario;
    private String zona;
    private String ISBN;

    public Llamada() {
    }

    //Este constructor no se utiliza
    //pero se puede utilizar para crear un registro
    public Llamada(String contacto, String compania, String horario, String zona, String ISBN) {
        this.contacto = contacto;
        this.compania = compania;
        this.horario = horario;
        this.zona = zona;
        this.ISBN = ISBN;
    }

    //Se generan todos los GET and SET
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}

