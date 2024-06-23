import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Inventario extends JFrame implements ActionListener {

    private JLabel descLabel, ctLabel, muLabel, fechaLabel, nfLabel, ciLabel;
    private JTextField descField, ctField, muField, fechaField, nfField, ciField;
    private JButton submitButton, exitButton;
    private JTextArea outputArea;
    private String formato;

    public Inventario() {
        super("Inventario");

        // Create labels
        descLabel = new JLabel("Descripción del equipo:");
        ctLabel = new JLabel("Cantidad de equipos:");
        muLabel = new JLabel("Costo unitario:");
        fechaLabel = new JLabel("Fecha (DD/MM/AAAA):");
        nfLabel = new JLabel("Número de factura:");
        ciLabel = new JLabel("Cédula de identidad:");

        // Create text fields
        descField = new JTextField();
        ctField = new JTextField();
        muField = new JTextField();
        fechaField = new JTextField();
        nfField = new JTextField();
        ciField = new JTextField();

        // Create buttons
        submitButton = new JButton("Registrar");
        exitButton = new JButton("Salir");

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Set layout
        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        panel.add(descLabel);
        panel.add(descField);
        panel.add(ctLabel);
        panel.add(ctField);
        panel.add(muLabel);
        panel.add(muField);
        panel.add(fechaLabel);
        panel.add(fechaField);
        panel.add(nfLabel);
        panel.add(nfField);
        panel.add(ciLabel);
        panel.add(ciField);
        panel.add(submitButton);
        panel.add(exitButton);
        panel.add(new JLabel());
        panel.add(outputArea);

        add(panel);

        // Register action listeners
        submitButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Set window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String desc = descField.getText();
            int ct = Integer.parseInt(ctField.getText());
            float mu = Float.parseFloat(muField.getText());
            String fecha = fechaField.getText();
            String nf = nfField.getText();
            String ci = ciField.getText();

            formato = "\n" + "Descripción: " + desc + ". Cant. de Equipos: " + ct + ". Costo x unidad: " + mu + ". Fecha: " + fecha + ". Num. factura: " + nf + ". C.I: " + ci;

            outputArea.setText(formato);

            try {
                FileWriter writer = new FileWriter("inventario.txt", true);
                writer.write(formato);
                writer.close();
                outputArea.append("\nBase de datos actualizada.");
            } catch (IOException ex) {
                outputArea.append("\nError: " + ex.getMessage());
            }

            // Clear fields after submission
            descField.setText("");
            ctField.setText("");
            muField.setText("");
            fechaField.setText("");
            nfField.setText("");
            ciField.setText("");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Inventario();
    }
}