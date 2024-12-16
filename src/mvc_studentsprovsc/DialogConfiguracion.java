package mvc_studentsprovsc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Dialogo de configuración.
 */
public class DialogConfiguracion extends JDialog {
    private JButton botonCambiarColor;

    public DialogConfiguracion(JFrame parent) {
        super(parent, "Configuración", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Opciones de configuración:");
        botonCambiarColor = new JButton("Cambiar color de fondo");

        // Acción para cambiar el color de fondo de la ventana principal
        botonCambiarColor.addActionListener((ActionEvent e) -> {
            Color nuevoColor = JColorChooser.showDialog(this, "Elige un color", parent.getContentPane().getBackground());
            if (nuevoColor != null) {
                parent.getContentPane().setBackground(nuevoColor);
                System.out.println("Color de fondo cambiado a: " + nuevoColor);
            }
        });

        add(label);
        add(botonCambiarColor);
    }
}
