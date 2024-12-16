package mvc_studentsprovsc;

import java.util.ArrayList;

/**
 * Controlador para gestionar la lógica del programa.
 */
public class ControladorVSC {
    private VistaVSC vista;
    private ModeloVSC modelo;

    public ControladorVSC(VistaVSC vista, ModeloVSC modelo) {
        this.vista = vista;
        this.modelo = modelo;

        inicializarControlador();
    }

    private void inicializarControlador() {
        vista.getBotonAgregarAlumno().addActionListener(e -> agregarAlumno());
        vista.getMenuItemEliminarAlumno().addActionListener(e -> eliminarAlumno());
        vista.getMenuItemBuscarAlumno().addActionListener(e -> buscarAlumno());

        vista.actualizarLista(modelo.getAlumnos());
    }

    private void agregarAlumno() {
    Alumno nuevoAlumno = vista.mostrarDialogoAgregarAlumno(); // Llamada correcta
    if (nuevoAlumno != null) { // Validación de que no sea nulo
        modelo.agregarAlumno(nuevoAlumno); // Lógica del modelo para agregar
        vista.actualizarLista(modelo.getAlumnos()); // Actualización de la lista en la Vista
        System.out.println("Alumno agregado: " + nuevoAlumno);
    }
}



    private void eliminarAlumno() {
        String alumnoSeleccionado = vista.mostrarDialogoEliminarAlumno(modelo.getAlumnos());
        if (alumnoSeleccionado != null) {
            modelo.eliminarAlumnoPorDescripcion(alumnoSeleccionado);
            vista.actualizarLista(modelo.getAlumnos());
            System.out.println("Alumno eliminado: " + alumnoSeleccionado);
        }
    }

    private void buscarAlumno() {
        String criterio = vista.mostrarDialogoBuscarAlumno();
        if (criterio != null && !criterio.trim().isEmpty()) {
            ArrayList<Alumno> resultados = modelo.buscarAlumno(criterio);
            if (!resultados.isEmpty()) {
                StringBuilder sb = new StringBuilder("Resultados de la búsqueda:\n");
                for (Alumno alumno : resultados) {
                    sb.append(alumno.getNombre()).append(" ").append(alumno.getApellidos()).append(" - ").append(alumno.getCurso()).append("\n");
                }
                vista.mostrarMensaje(sb.toString(), "Resultados");
            } else {
                vista.mostrarMensaje("No se encontraron alumnos con ese criterio.", "Sin resultados");
            }
        }
    }
}
