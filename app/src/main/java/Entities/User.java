package Entities;


public class User {
    private int Id;
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Clave;

    public User(){

    }

    public User(int id, String cedula, String nombre, String apellido, String correo, String clave) {
        Id = id;
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Clave = clave;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}