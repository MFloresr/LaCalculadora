import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Vipi on 02/02/2016.
 */
public class Calculadora {
    private JTextField resultado;
    private JButton botonc;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton botonres;
    private JButton botonsuma;
    private JButton boton3;
    private JButton boton2;
    private JButton boton1;
    private JButton boton0;
    private JButton botonpunto;
    private JButton botonigual;
    private JPanel CalculadoraView;
    private String operadorUno;
    private Double resultadocalculo = 0.0;
    private String signo;

    public Calculadora() {
        boton0.addActionListener(new NumeroBtnClicado(boton0.getText()));
        boton1.addActionListener(new NumeroBtnClicado(boton1.getText()));
        boton2.addActionListener(new NumeroBtnClicado(boton2.getText()));
        boton3.addActionListener(new NumeroBtnClicado(boton3.getText()));
        boton4.addActionListener(new NumeroBtnClicado(boton4.getText()));
        boton5.addActionListener(new NumeroBtnClicado(boton5.getText()));
        boton6.addActionListener(new NumeroBtnClicado(boton6.getText()));
        boton7.addActionListener(new NumeroBtnClicado(boton7.getText()));
        boton8.addActionListener(new NumeroBtnClicado(boton8.getText()));
        boton9.addActionListener(new NumeroBtnClicado(boton9.getText()));
        botonpunto.addActionListener(new NumeroBtnClicado(botonpunto.getText()));

        botonsuma.addActionListener(new OperacionBtnClicado(botonsuma.getText()));
        botonres.addActionListener(new OperacionBtnClicado(botonres.getText()));

        botonc.addActionListener(new BtnLimpiar());
        botonigual.addActionListener(new BtnIgual());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        CalculadoraView = new JPanel();
        CalculadoraView.setLayout(new GridBagLayout());
        CalculadoraView.setBackground(new Color(-1838593));
        CalculadoraView.setEnabled(false);
        CalculadoraView.setForeground(new Color(-1282));
        resultado = new JTextField();
        resultado.setBackground(new Color(-16579837));
        resultado.setFont(new Font(resultado.getFont().getName(), resultado.getFont().getStyle(), 20));
        resultado.setForeground(new Color(-1));
        resultado.setHorizontalAlignment(11);
        resultado.setText("");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 40;
        CalculadoraView.add(resultado, gbc);
        boton7 = new JButton();
        boton7.setBackground(new Color(-6690631));
        boton7.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton7, gbc);
        boton8 = new JButton();
        boton8.setBackground(new Color(-6690631));
        boton8.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton8, gbc);
        boton9 = new JButton();
        boton9.setBackground(new Color(-6690631));
        boton9.setText("9");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton9, gbc);
        boton4 = new JButton();
        boton4.setBackground(new Color(-6690631));
        boton4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton4, gbc);
        boton5 = new JButton();
        boton5.setBackground(new Color(-6690631));
        boton5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton5, gbc);
        boton6 = new JButton();
        boton6.setBackground(new Color(-6690631));
        boton6.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton6, gbc);
        boton3 = new JButton();
        boton3.setBackground(new Color(-6690631));
        boton3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton3, gbc);
        boton2 = new JButton();
        boton2.setBackground(new Color(-6690631));
        boton2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton2, gbc);
        boton1 = new JButton();
        boton1.setBackground(new Color(-6690631));
        boton1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton1, gbc);
        botonigual = new JButton();
        botonigual.setBackground(new Color(-6690631));
        botonigual.setText("=");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(botonigual, gbc);
        botonc = new JButton();
        botonc.setBackground(new Color(-7733249));
        botonc.setIcon(new ImageIcon(getClass().getResource("/com/sun/deploy/resources/image/cautionshield48s.png")));
        botonc.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 6;
        CalculadoraView.add(botonc, gbc);
        botonres = new JButton();
        botonres.setBackground(new Color(-6690631));
        botonres.setText("-");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(botonres, gbc);
        botonpunto = new JButton();
        botonpunto.setBackground(new Color(-6690631));
        botonpunto.setText(".");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(botonpunto, gbc);
        boton0 = new JButton();
        boton0.setBackground(new Color(-6690631));
        boton0.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        CalculadoraView.add(boton0, gbc);
        botonsuma = new JButton();
        botonsuma.setBackground(new Color(-6690631));
        botonsuma.setText("+");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 50;
        gbc.ipady = 66;
        CalculadoraView.add(botonsuma, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return CalculadoraView;
    }


    private class NumeroBtnClicado implements ActionListener {
        private String valor;

        public NumeroBtnClicado(String valor) {
            this.valor = valor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (operadorUno == null && valor != ".") {
                operadorUno = valor;
                resultado.setText(resultado.getText() + valor);
            } else {
                if (operadorUno != null) {
                    if (valor == ".") {
                        if (operadorUno.contains(valor)) {
                            botonpunto.setEnabled(false);
                        } else {
                            operadorUno = operadorUno + valor;
                            resultado.setText(resultado.getText() + valor);
                        }
                    } else {
                        operadorUno = operadorUno + valor;
                        resultado.setText(resultado.getText() + valor);
                    }
                }
            }
        }
    }

    private class OperacionBtnClicado implements ActionListener {
        private String valor;

        public OperacionBtnClicado(String valor) {
            this.valor = valor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (operadorUno != null && (valor.equals("+") || valor.equals("-"))) {
                if (valor.equals("+")) {
                    resultadocalculo = resultadocalculo + Double.valueOf(operadorUno);
                    resultado.setText(resultado.getText() + valor);
                    operadorUno = null;
                    signo = "+";
                }
                if (valor.equals("-")) {
                    resultadocalculo = resultadocalculo - Double.valueOf(operadorUno);
                    resultado.setText(resultado.getText() + valor);
                    operadorUno = null;
                    signo = "-";
                }

            }
            botonpunto.setEnabled(true);
        }
    }

    private class BtnLimpiar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resultado.setText("");
            operadorUno = null;
            resultadocalculo = 0.0;
            botonpunto.setEnabled(true);
        }
    }

    private class BtnIgual implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (signo.equals("+")) {
                resultadocalculo = resultadocalculo + Double.valueOf(operadorUno);
            } else {
                resultadocalculo = resultadocalculo - Double.valueOf(operadorUno);
            }

            if (resultadocalculo.equals(666.0)) {
                resultado.setText(String.valueOf("Error"));
                operadorUno = null;
                resultadocalculo = 0.0;
            } else {
                resultado.setText(String.valueOf(resultadocalculo));
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora-Xpres 2.0");
        frame.setContentPane(new Calculadora().CalculadoraView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanopantalla = miPantalla.getScreenSize();
        int alturapantalla = tamanopantalla.height;
        int anchurapantalla = tamanopantalla.width;

        frame.setLocation(anchurapantalla / 4, alturapantalla / 4);
    }
}
