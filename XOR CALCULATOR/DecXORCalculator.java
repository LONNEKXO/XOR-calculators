import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DecXORCalculator extends JFrame {
    private JTextField decField1, decField2, xorResultField, bitDifferenceField;
    private JButton calculateButton;

    public DecXORCalculator() {
        setTitle("Decimal XOR Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        decField1 = new JTextField(8);
        decField2 = new JTextField(8);
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
        panel.add(new JLabel("Decimal Value 1: "));
        panel.add(decField1);
        panel.add(new JLabel("Decimal Value 2: "));
        panel.add(decField2);
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
            int num1 = Integer.parseInt(decField1.getText());
            int num2 = Integer.parseInt(decField2.getText());

            int xorResult = num1 ^ num2;
            int bitDifference = Integer.bitCount(xorResult);

            xorResultField.setText(Integer.toString(xorResult));
            bitDifferenceField.setText(Integer.toString(bitDifference));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid decimal input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DecXORCalculator().setVisible(true);
            }
        });
    }
}
