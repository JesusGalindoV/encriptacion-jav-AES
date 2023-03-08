import java.awt.event.*;
import java.util.Base64;
import javax.swing.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class CipherGUI extends JFrame implements ActionListener {
    private JTextField inputField, outputField, inputFieldDescifrar;
    private JRadioButton encryptButton, decryptButton;
    private JButton processButton,clearButton;

    public CipherGUI() {
        // Crear los componentes de la interfaz
        inputField = new JTextField(40);

        inputFieldDescifrar = new JTextField(40);

        outputField = new JTextField(40);
        outputField.setEditable(false);
        encryptButton = new JRadioButton("Encrypt");
        decryptButton = new JRadioButton("Decrypt");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(encryptButton);
        buttonGroup.add(decryptButton);
        processButton = new JButton("Process");
        processButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });



        // Crear el panel para los botones de cifrado/descifrado
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        // Crear el panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //texto plano
        mainPanel.add(new JLabel("Input:"));
        mainPanel.add(inputField);

        //texto cifrado
        mainPanel.add(new JLabel("Input cifrado:"));
        mainPanel.add(inputFieldDescifrar);

        mainPanel.add(buttonPanel);
        mainPanel.add(processButton);
        mainPanel.add(clearButton);

        mainPanel.add(new JLabel("Output:"));
        mainPanel.add(outputField);

        // Configurar la ventana
        setTitle("PROYECTO ENCRIPTACIÓN - Jesús Galindo");
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
            //if (input.isEmpty()) {
              //  JOptionPane.showMessageDialog(this, "El input de texto a cifrar no puede estar vacio.");
                //return;
            //}
            String output;
            if (encryptButton.isSelected()) {
                output = encrypt(input);
            } else {
                //if (decryptPlainText.isEmpty()) {
                   // JOptionPane.showMessageDialog(this, "El input de texto a decifrar no puede estar vacio.");
                   // return;
                //}
                output = decrypt(decryptPlainText);
            }
            outputField.setText(output);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    private String encrypt(String plaintext) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec("0123456789abcdef".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    private String decrypt(String ciphertext) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec("0123456789abcdef".getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] plaintext = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(plaintext);
    }

    private void clearFields() {
        inputField.setText("");
        outputField.setText("");
        inputFieldDescifrar.setText("");
    }

    public static void main(String[] args) {
        new CipherGUI();
    }
}
