/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_studentsprovsc;

/**
 *
 * @author dam2
 */
import javax.swing.*;
import java.awt.*;

public class VistaVSC extends JFrame {
    private JLabel labelBienvenida;

    public VistaVSC() {
        setTitle("Students Pro VSA");
        setSize(400, 200); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Crear el JLabel con el mensaje de bienvenida
        labelBienvenida = new JLabel("Bienvenido a Students Pro VSA", SwingConstants.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 16)); // Estilo de la fuente

        // Añadir el JLabel a la ventana
        add(labelBienvenida);

        // Hacer la ventana visible
        setVisible(true);
    }
}