import javax.swing.*;

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
    private final CalculadoraTarifa calculadoraTarifa;
    private static final Producto mouse = new Producto(1, "Mouse", 30000, 0.19);
    private static final Producto teclado = new Producto(2, "Teclado", 100000, 0.19);
    private static final Producto monitor = new Producto(3, "Monitor", 500000, 0.19);
    private static final Cliente jaime = new Cliente("Jaime", 110532);
    private static final Cliente ana = new Cliente("Ana", 130546);

    private void actualizarTarifaTextLabel(Producto producto){
        tarifaTextField.setText("$"+(calculadoraTarifa.calcularTarifa(clienteactual, producto)));
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

        anaRadioButton.addActionListener(e -> clienteactual = ana);
        jaimeRadioButton.addActionListener(e -> clienteactual = jaime);
        mouseButton.addActionListener(e -> actualizarTarifaTextLabel(mouse));
        tecladoButton.addActionListener(e -> actualizarTarifaTextLabel(teclado));
        monitorButton.addActionListener(e -> actualizarTarifaTextLabel(monitor));
    }

    public static void main(String[] args) {
        JFrame gui = new GUITarifa("CalculadoraTarifa");
        gui.setVisible(true);
    }


}
