package mvc_studentsprovsc;

import javax.swing.*;
import java.awt.*;

public class VistaVSC extends JFrame {
    private JLabel labelBienvenida;

    public VistaVSC() {
        setTitle("Students Pro VSA");
        setSize(400, 300); // Tamaño inicial
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Crear el JLabel con el mensaje de bienvenida
        labelBienvenida = new JLabel("Bienvenido a Students Pro VSA", SwingConstants.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 16)); // Estilo de la fuente
        labelBienvenida.setForeground(Color.BLACK); // Color del texto

        // Panel personalizado para el fondo
        FondoPanel fondoPanel = new FondoPanel("fondo.jpg");
        fondoPanel.setLayout(new BorderLayout());
        fondoPanel.add(labelBienvenida, BorderLayout.CENTER);

        // Añadir el panel de fondo a la ventana
        add(fondoPanel);

        // Hacer la ventana visible
        setVisible(true);
    }

    // Clase interna para crear un panel con una imagen de fondo
    private class FondoPanel extends JPanel {
        private Image imagen;

        public FondoPanel(String rutaImagen) {
            ImageIcon icono = new ImageIcon(rutaImagen);
            imagen = icono.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                // Escalar la imagen al tamaño del panel y ajustar transparencia
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // 50% de opacidad
                g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        }
    }
}
