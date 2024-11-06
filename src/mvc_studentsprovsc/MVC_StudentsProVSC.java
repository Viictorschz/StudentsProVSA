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
// Main.java
public class MVC_StudentsProVSC {
    public static void main(String[] args) {
        ModeloVSC modelo = new ModeloVSC();
        VistaVSC vista = new VistaVSC();
        ControladorVSC controladorVSC = new ControladorVSC(modelo, vista);
    }
}

