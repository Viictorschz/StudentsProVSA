package mvc_studentsprovsc;

/**
 * Clase principal del proyecto.
 */
public class MVC_StudentsProVSC {
    public static void main(String[] args) {
        // Ruta de la imagen de fondo
        String rutaImagen = "fondo.jpg";

        // Crear las instancias del modelo, vista y controlador
        ModeloVSC modelo = new ModeloVSC();
        VistaVSC vista = VistaVSC.getInstancia(rutaImagen);
        new ControladorVSC(vista, modelo);

        // Mostrar la ventana principal
        vista.setVisible(true);
    }
}
