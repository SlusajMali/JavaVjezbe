import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Konvertor extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private double EUR_USD;
    private double EUR_GBP;
    private double USD_GBP;

    public Konvertor() {
        super("Konvertor Valuta");

        loadRatesFromJson("./src/rates.json");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 170);
        setLayout(new java.awt.GridLayout(3, 2, 5, 5));

        label1 = new JLabel("EUR");
        add(label1);
        textField1 = new JTextField(30);
        add(textField1);

        label2 = new JLabel("USD");
        add(label2);
        textField2 = new JTextField(30);
        add(textField2);

        label3 = new JLabel("GBP");
        add(label3);
        textField3 = new JTextField(30);
        add(textField3);

        EventHandler handler = new EventHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
    }

    private void loadRatesFromJson(String fileName) {

        EUR_USD = 1.17;
        EUR_GBP = 0.87;
        USD_GBP = 0.74;

        try {
            String json = new String(Files.readAllBytes(Paths.get(fileName)));
            json = json.replace("{", "").replace("}", "").trim();

            String[] parovi = json.split(",");
            for (String par : parovi) {
                String[] kv = par.split(":");
                if (kv.length != 2) continue;

                String key = kv[0].replace("\"", "").trim();
                String valueStr = kv[1].trim();
                double value = Double.parseDouble(valueStr);

                if (key.equals("EUR_USD")) {
                    EUR_USD = value;
                } else if (key.equals("EUR_GBP")) {
                    EUR_GBP = value;
                } else if (key.equals("USD_GBP")) {
                    USD_GBP = value;
                }
            }

            System.out.println("Učitani kursevi iz JSON-a: EUR_USD = " + EUR_USD +
                    ", EUR_GBP = " + EUR_GBP + ", USD_GBP = " + USD_GBP);

        } catch (Exception e) {
            System.out.println("Greška pri čitanju/parsiranju JSON fajla, koristim podrazumijevane vrijednosti.");
            JOptionPane.showMessageDialog(
                    null,
                    "Nije moguće učitati " + fileName + ".\nKoristim podrazumijevane kurseve.",
                    "Upozorenje",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                if (e.getSource() == textField1) {

                    double eurValue = Double.parseDouble(textField1.getText());
                    double usdValue = eurValue * EUR_USD;
                    double gbpValue = eurValue * EUR_GBP;

                    textField2.setText(String.format("%.2f", usdValue));
                    textField3.setText(String.format("%.2f", gbpValue));

                } else if (e.getSource() == textField2) {

                    double usdValue = Double.parseDouble(textField2.getText());
                    double eurValue = usdValue / EUR_USD;
                    double gbpValue = usdValue * USD_GBP;

                    textField1.setText(String.format("%.2f", eurValue));
                    textField3.setText(String.format("%.2f", gbpValue));

                } else if (e.getSource() == textField3) {

                    double gbpValue = Double.parseDouble(textField3.getText());
                    double eurValue = gbpValue / EUR_GBP;
                    double usdValue = gbpValue / USD_GBP;

                    textField1.setText(String.format("%.2f", eurValue));
                    textField2.setText(String.format("%.2f", usdValue));
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Molimo unesite ispravan broj.",
                        "Greška pri unosu",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void main(String[] args) {

        Konvertor forma = new Konvertor();
        forma.setVisible(true);

    }
}
