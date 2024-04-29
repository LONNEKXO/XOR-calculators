import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HexXORCalculator extends JFrame {
    private JTextField hexField1, hexField2, xorResultField, bitDifferenceField;
    private JButton calculateButton;

    public HexXORCalculator() {
        setTitle("Hex XOR Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        hexField1 = new JTextField(8);
        hexField2 = new JTextField(8);
        xorResultField = new JTextField(8);
        xorResultField.setEditable(false);
        bitDifferenceField = new JTextField(8);
        bitDifferenceField.setEditable(false);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateXORAndDifference();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Hex Value 1: "));
        panel.add(hexField1);
        panel.add(new JLabel("Hex Value 2: "));
        panel.add(hexField2);
        panel.add(new JLabel("XOR Result: "));
        panel.add(xorResultField);
        panel.add(new JLabel("Bit Difference: "));
        panel.add(bitDifferenceField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void calculateXORAndDifference() {
        try {
            String hex1 = hexField1.getText();
            String hex2 = hexField2.getText();

            if (!hex1.matches("[0-9A-Fa-f]+") || !hex2.matches("[0-9A-Fa-f]+")) {
                JOptionPane.showMessageDialog(this, "Invalid hex input!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            long num1 = Long.parseLong(hex1, 16);
            long num2 = Long.parseLong(hex2, 16);

            long xorResult = num1 ^ num2;
            long bitDifference = Long.bitCount(xorResult);

            xorResultField.setText(Long.toHexString(xorResult).toUpperCase());
            bitDifferenceField.setText(Long.toString(bitDifference));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid hex input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HexXORCalculator().setVisible(true);
            }
        });
    }
}
