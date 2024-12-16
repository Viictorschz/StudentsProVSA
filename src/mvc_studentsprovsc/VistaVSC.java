package mvc_studentsprovsc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Ventana principal con "espía" de clics del ratón.
 */
public class VistaVSC extends JFrame {
    private static VistaVSC instancia;

    private JMenuItem menuItemConfiguracion;
    private JMenuItem menuItemEliminarAlumno;
    private JMenuItem menuItemModificarAlumno;
    private JMenuItem menuItemExportarLista;
    private JMenuItem menuItemBuscarAlumno;
    private JButton botonAgregarAlumno;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaAlumnos;

    private VistaVSC(String rutaImagen) {
        setTitle("Gestión de Alumnos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fondo de la ventana
        JPanel fondoPanel = new JPanel() {
            private final Image imagenFondo = new ImageIcon(rutaImagen).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        fondoPanel.setLayout(new BorderLayout());

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuAlumnado = new JMenu("Alumnado");

        // Espía para el menú "Alumnado"
        registrarClicEspia(menuAlumnado, "Menú Alumnado");

        menuItemConfiguracion = new JMenuItem("Configuración");
        menuItemEliminarAlumno = new JMenuItem("Eliminar Alumno");
        menuItemModificarAlumno = new JMenuItem("Modificar Alumno");
        menuItemExportarLista = new JMenuItem("Exportar Lista");
        menuItemBuscarAlumno = new JMenuItem("Buscar Alumno");

        // Espías para los ítems del menú
        registrarClicEspia(menuItemConfiguracion, "Menú Configuración");
        registrarClicEspia(menuItemEliminarAlumno, "Menú Eliminar Alumno");
        registrarClicEspia(menuItemModificarAlumno, "Menú Modificar Alumno");
        registrarClicEspia(menuItemExportarLista, "Menú Exportar Lista");
        registrarClicEspia(menuItemBuscarAlumno, "Menú Buscar Alumno");

        menuAlumnado.add(menuItemConfiguracion);
        menuAlumnado.add(menuItemEliminarAlumno);
        menuAlumnado.add(menuItemModificarAlumno);
        menuAlumnado.add(menuItemBuscarAlumno);
        menuAlumnado.add(menuItemExportarLista);

        menuBar.add(menuAlumnado);
        setJMenuBar(menuBar);

        // Lista de alumnos
        modeloLista = new DefaultListModel<>();
        listaAlumnos = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaAlumnos);

        // Botón para agregar alumno
        botonAgregarAlumno = new JButton("Agregar Alumno");

        fondoPanel.add(scrollPane, BorderLayout.CENTER);
        fondoPanel.add(botonAgregarAlumno, BorderLayout.SOUTH);

        setContentPane(fondoPanel);

        // Registrar espía solo para clics
        registrarClicEspia(fondoPanel, "Fondo de la ventana");
        registrarClicEspia(botonAgregarAlumno, "Botón Agregar Alumno");
        registrarClicEspia(listaAlumnos, "Lista de Alumnos");
        registrarClicEspia(menuItemConfiguracion, "Menú Configuración");
        registrarClicEspia(menuItemEliminarAlumno, "Menú Eliminar Alumno");
        registrarClicEspia(menuItemModificarAlumno, "Menú Modificar Alumno");
        registrarClicEspia(menuItemExportarLista, "Menú Exportar Lista");
        registrarClicEspia(menuItemBuscarAlumno, "Menú Buscar Alumno");
    }

    public static VistaVSC getInstancia(String rutaImagen) {
        if (instancia == null) {
            instancia = new VistaVSC(rutaImagen);
        }
        return instancia;
    }

    public void actualizarLista(ArrayList<Alumno> alumnos) {
        modeloLista.clear();
        for (Alumno alumno : alumnos) {
            modeloLista.addElement(alumno.getNombre() + " " + alumno.getApellidos() + " - " + alumno.getCurso());
        }
    }

    public JMenuItem getMenuItemBuscarAlumno() {
        return menuItemBuscarAlumno;
    }

    public JMenuItem getMenuItemEliminarAlumno() {
        return menuItemEliminarAlumno;
    }

    public JButton getBotonAgregarAlumno() {
        return botonAgregarAlumno;
    }

    public JList<String> getListaAlumnos() {
        return listaAlumnos;
    }

    public void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public String mostrarDialogoEliminarAlumno(ArrayList<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay alumnos disponibles para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        JComboBox<String> comboBox = new JComboBox<>();
        for (Alumno alumno : alumnos) {
            comboBox.addItem(alumno.getNombre() + " " + alumno.getApellidos() + " - " + alumno.getCurso());
        }

        int result = JOptionPane.showConfirmDialog(
            this,
            comboBox,
            "Seleccione un alumno para eliminar",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION && comboBox.getSelectedItem() != null) {
            return comboBox.getSelectedItem().toString();
        }
        return null;
    }
    
    public Alumno mostrarDialogoAgregarAlumno() {
    JPanel panel = new JPanel(new GridLayout(3, 2));

    JTextField nombreField = new JTextField();
    JTextField apellidosField = new JTextField();
    JComboBox<String> cursoComboBox = new JComboBox<>(new String[]{
        "1º Informática", "1º Marketing Digital", "1º Deportes",
        "2º Informática", "2º Marketing Digital", "2º Deportes"
    });

    panel.add(new JLabel("Nombre:"));
    panel.add(nombreField);
    panel.add(new JLabel("Apellidos:"));
    panel.add(apellidosField);
    panel.add(new JLabel("Curso:"));
    panel.add(cursoComboBox);

    int result = JOptionPane.showConfirmDialog(
        this,
        panel,
        "Agregar Alumno",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
        String nombre = nombreField.getText().trim();
        String apellidos = apellidosField.getText().trim();
        String curso = (String) cursoComboBox.getSelectedItem();

        if (!nombre.isEmpty() && !apellidos.isEmpty() && curso != null) {
            return new Alumno(nombre, apellidos, curso);
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    return null;
}
    
    /**
 * Muestra un cuadro de diálogo para buscar un alumno.
 * @return El criterio de búsqueda ingresado por el usuario o null si se cancela.
 */
public String mostrarDialogoBuscarAlumno() {
    return JOptionPane.showInputDialog(
        this,
        "Ingrese el nombre, apellidos o curso para buscar:",
        "Buscar Alumno",
        JOptionPane.PLAIN_MESSAGE
    );
}



    /**
     * Método para registrar eventos de clic del ratón en un componente.
     *
     * @param componente El componente al que se añade el espía.
     * @param nombre     Nombre descriptivo del componente (para los logs).
     */
    private void registrarClicEspia(JComponent componente, String nombre) {
    componente.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clic detectado en: " + nombre + " | Coordenadas: (" + e.getX() + ", " + e.getY() + ")");
        }
    });
}

}
