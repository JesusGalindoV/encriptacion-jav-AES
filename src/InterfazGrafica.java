import java.awt.event.*;
import javax.swing.*;

public class InterfazGrafica extends JFrame implements ActionListener {
    private JTextField inputField, outputField, inputFieldDescifrar;
    private JRadioButton encryptButton, decryptButton;
    private JButton processButton,clearButton;

    Encriptar_Decriptar methods = new Encriptar_Decriptar();

    public InterfazGrafica() {

        inputField = new JTextField(40);

        inputFieldDescifrar = new JTextField(40);

        outputField = new JTextField(40);
        outputField.setEditable(false);
        encryptButton = new JRadioButton("Encriptar");
        decryptButton = new JRadioButton("Decriptar");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(encryptButton);
        buttonGroup.add(decryptButton);
        processButton = new JButton("Procesar");
        processButton.addActionListener(this);

        clearButton = new JButton("Limpiar Interfaz");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(new JLabel("Input:"));
        mainPanel.add(inputField);

        mainPanel.add(new JLabel("Input cifrado:"));
        mainPanel.add(inputFieldDescifrar);

        mainPanel.add(buttonPanel);
        mainPanel.add(processButton);
        mainPanel.add(clearButton);

        mainPanel.add(new JLabel("Output:"));
        mainPanel.add(outputField);

        setTitle("Proyecto Encriptación - Jesús Galindo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String input = inputField.getText();
            String decryptPlainText = inputFieldDescifrar.getText();

            String output;

            if (encryptButton.isSelected()) {
                output = methods.encrypt(input);
            } else {

                output = methods.decrypt(decryptPlainText);
            }
            outputField.setText(output);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {

        inputField.setText("");

        outputField.setText("");

        inputFieldDescifrar.setText("");

    }

    public static void main(String[] args) {

        new InterfazGrafica();

    }
}
