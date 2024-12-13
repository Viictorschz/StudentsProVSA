/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc_studentsprovsc;
import mvc_studentsprovsc.VistaVSC;

/**
 *
 * @author Víctor
 */
/**
 * Clase principal del proyecto.
 */
public class MVC_StudentsProVSC {
    public static void main(String[] args) {
        PantallaCarga carga = new PantallaCarga();
        carga.mostrarYCerrar(() -> {
            ModeloVSC modelo = new ModeloVSC();
            VistaVSC vista = new VistaVSC();
            ControladorVSC controlador = new ControladorVSC(modelo, vista);
        });
    }
}

