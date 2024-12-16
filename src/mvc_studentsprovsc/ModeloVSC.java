package mvc_studentsprovsc;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Modelo que gestiona los datos y la lógica de negocio.
 */
public class ModeloVSC {
    private ArrayList<Alumno> alumnos;

    public ModeloVSC() {
        alumnos = new ArrayList<>();
        cargarAlumnosDesdeArchivo();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        guardarAlumnosEnArchivo();
    }

    public void eliminarAlumnoPorDescripcion(String descripcion) {
        alumnos.removeIf(alumno -> (alumno.getNombre() + " " + alumno.getApellidos() + " - " + alumno.getCurso()).equals(descripcion));
        guardarAlumnosEnArchivo();
    }

    public ArrayList<Alumno> buscarAlumno(String texto) {
        return alumnos.stream()
                .filter(alumno -> (alumno.getNombre() + " " + alumno.getApellidos() + " " + alumno.getCurso()).toLowerCase()
                        .contains(texto.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void cargarAlumnosDesdeArchivo() {
        File archivo = new File("alumnos.txt");
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    if (partes.length == 3) {
                        Alumno alumno = new Alumno(partes[0], partes[1], partes[2]);
                        alumnos.add(alumno);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo de alumnos: " + e.getMessage());
            }
        }
    }

    private void guardarAlumnosEnArchivo() {
        File archivo = new File("alumnos.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Alumno alumno : alumnos) {
                bw.write(alumno.getNombre() + ";" + alumno.getApellidos() + ";" + alumno.getCurso());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de alumnos: " + e.getMessage());
        }
    }
}
