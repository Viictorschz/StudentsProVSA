/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_studentsprovsc;

/**
 *
 * @author Víctor
 */
import javax.swing.*;
import java.awt.*;

/**
 * Ventana de presentación con temporizador.
 */
public class PantallaCarga extends JWindow {
    public PantallaCarga() {
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Contenido
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        JLabel mensaje = new JLabel("Cargando...", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        mensaje.setForeground(Color.WHITE);

        panel.add(mensaje, BorderLayout.CENTER);
        add(panel);
    }

    /**
     * Muestra la pantalla de carga durante unos segundos.
     * @param callback Acción a ejecutar tras la carga.
     */
    public void mostrarYCerrar(Runnable callback) {
        setVisible(true);

        // Temporizador para cerrar la ventana
        new Timer(3000, e -> {
            setVisible(false);
            dispose();
            callback.run();
        }).start();
    }
}