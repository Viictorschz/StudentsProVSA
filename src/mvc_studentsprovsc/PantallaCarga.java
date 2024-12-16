package mvc_studentsprovsc;

import javax.swing.*;
import java.awt.*;

/**
 * Pantalla de carga inicial con imagen de fondo.
 */
public class PantallaCarga extends JWindow {
    public PantallaCarga(String rutaImagen) {
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel fondoLabel = new JLabel(new ImageIcon(rutaImagen));
        fondoLabel.setLayout(new BorderLayout());

        JLabel mensaje = new JLabel("Cargando...", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        mensaje.setForeground(Color.BLACK);

        fondoLabel.add(mensaje, BorderLayout.SOUTH);
        add(fondoLabel);
    }

    public void mostrarYCerrar(Runnable callback) {
        setVisible(true);
        new Timer(3000, e -> {
            setVisible(false);
            dispose();
            callback.run();
        }).start();
    }
}
