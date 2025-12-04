import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameKalkulator extends JFrame {

    private JTextField field;
    private JLabel label;
    private JButton button;

    public FrameKalkulator() {
        super("Izraz");

        this.setSize(400, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        label = new JLabel("Unesite izraz:");
        this.add(label);

        field = new JTextField(20);
        this.add(field);

        button = new JButton("Izracunaj");
        this.add(button);

        EventHandler obradjivanjeDogadjaja = new EventHandler();
        button.addActionListener(obradjivanjeDogadjaja);
    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button) {

                String izraz = field.getText();
                String rjesenje = Integer.toString(racunaj(izraz));
                JOptionPane.showMessageDialog(null, rjesenje);

            }
        }
    }

    public static int racunaj(String operacija) {

        String operand = "";

        if (operacija.contains("+")) {
            operand = "+";
        }
        if (operacija.contains("-")) {
            operand = "-";
        }
        if (operacija.contains("*")) {
            operand = "*";
        }
        if (operacija.contains("/")) {
            operand = "/";
        }

        int operandIndex = operacija.indexOf(operand);
        int vrijednost = 0;

        int br1 = Integer.parseInt(operacija.substring(0, operandIndex));
        int br2 = Integer.parseInt(operacija.substring(operandIndex + 1));

        if (operand == "+") {
            vrijednost = br1 + br2;
        }
        if (operand == "-") {
            vrijednost = br1 - br2;
        }
        if (operand == "*") {
            vrijednost = br1 * br2;
        }
        if (operand == "/") {
            vrijednost = br1 / br2;
        }

        return vrijednost;
    }

    public static void main(String[] args) {

        FrameKalkulator forma = new FrameKalkulator();
        forma.setVisible(true);

    }
}
