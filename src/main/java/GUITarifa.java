import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITarifa extends JFrame{
    private JPanel mainPanel;
    private JLabel TarifaLabel;
    private JLabel usuarioLabel;
    private JPanel usuarioPanel;
    private JRadioButton jaimeRadioButton;
    private JRadioButton anaRadioButton;
    private JButton mouseButton;
    private JButton tecladoButton;
    private JButton monitorButton;
    private JTextField tarifaTextField;
    private Cliente clienteactual;
    private CalculadoraTarifa calculadoraTarifa;
    private static final Producto mouse = new Producto(1, "Mouse", 30000, 0.19);
    private static final Producto teclado = new Producto(2, "Teclado", 100000, 0.19);
    private static final Producto monitor = new Producto(3, "Monitor", 500000, 0.19);
    private static final Cliente jaime = new Cliente("Jaime", 110532);
    private static final Cliente ana = new Cliente("Ana", 130546);

    private void actualizarTarifaTextLabel(Producto producto){
        tarifaTextField.setText("$"+String.valueOf(calculadoraTarifa.calcularTarifa(clienteactual, producto)));
    }

    public GUITarifa(String tarifaLabel) {
        super(tarifaLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        SistemaDescuento SDsimulado = new SistemaDescuento();
        TablaTarifa TTsimulado = new TablaTarifa();
        clienteactual=jaime;
        calculadoraTarifa = new CalculadoraTarifa(SDsimulado, TTsimulado);

        anaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteactual = ana;
            }
        });
        jaimeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteactual = jaime;
            }
        });
        mouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTarifaTextLabel(mouse);
            }
        });
        tecladoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTarifaTextLabel(teclado);
            }
        });
        monitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTarifaTextLabel(monitor);
            }
        });
    }

    public static void main(String[] args) {
        JFrame gui = new GUITarifa("CalculadoraTarifa");
        gui.setVisible(true);
    }


}
