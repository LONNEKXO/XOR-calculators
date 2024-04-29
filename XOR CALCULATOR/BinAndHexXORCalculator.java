import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinAndHexXORCalculator extends JFrame {
    private JTextField binField1, binField2, xorResultField, bitDifferenceField;
    private JButton calculateButton;

    public BinAndHexXORCalculator() {
        setTitle("Binary to hex XOR Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        binField1 = new JTextField(8);
        binField2 = new JTextField(8);
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
        panel.add(new JLabel("Binary Value 1: "));
        panel.add(binField1);
        panel.add(new JLabel("Binary Value 2: "));
        panel.add(binField2);
        panel.add(new JLabel("XOR Result (Hex): "));
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
            String bin1 = binField1.getText();
            String bin2 = binField2.getText();

            if (!bin1.matches("[01]+") || !bin2.matches("[01]+")) {
                JOptionPane.showMessageDialog(this, "Invalid binary input!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            long num1 = Long.parseLong(bin1, 2);
            long num2 = Long.parseLong(bin2, 2);

            long xorResult = num1 ^ num2;
            long bitDifference = Long.bitCount(xorResult);

            xorResultField.setText(Long.toHexString(xorResult).toUpperCase());
            bitDifferenceField.setText(Long.toString(bitDifference));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid binary input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BinAndHexXORCalculator().setVisible(true);
            }
        });
    }
}
