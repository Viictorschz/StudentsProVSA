package mvc_studentsprovsc;

/**
 * Clase que representa a un alumno.
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private String curso;

    public Alumno(String nombre, String apellidos, String curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + curso;
    }
}
