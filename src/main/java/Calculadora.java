import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Double operadorIsquierda;
    private Double operadorDerecha ;
    private Operacion calcOperacion;
    private JPanel CalculadoraView;

    public Calculadora(){
        boton0.addActionListener(new NumeroBtnClicado(boton0.getText()));
        boton1.addActionListener(new NumeroBtnClicado(boton1.getText()));
        boton2.addActionListener(new NumeroBtnClicado(boton2.getText()));
        boton3.addActionListener(new NumeroBtnClicado(boton3.getText()));
        boton4.addActionListener(new NumeroBtnClicado(boton4.getText()));
        boton5.addActionListener(new NumeroBtnClicado(boton5.getText()));
        boton6.addActionListener(new NumeroBtnClicado(boton6.getText()));
        boton7.addActionListener(new NumeroBtnClicado(boton7.getText()));
        boton8.addActionListener(new NumeroBtnClicado(boton8.getText()));
        boton8.addActionListener(new NumeroBtnClicado(boton9.getText()));

        botonsuma.addActionListener(new OperacionBtnClicado(Operacion.SUMA));
        botonres.addActionListener(new OperacionBtnClicado(Operacion.RESTA));
        botonc.addActionListener(new BtnLimpiar());
        botonpunto.addActionListener(new PuntoDecimalBtn());
        botonigual.addActionListener(new BtnIgual());
    }
    private class NumeroBtnClicado implements ActionListener{
        private String valor;
        public NumeroBtnClicado(String valor){
            this.valor=valor;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(operadorIsquierda==null || operadorIsquierda==0.0){
                valor = resultado.getText() +valor;
                System.out.println(valor);
                System.out.println(operadorIsquierda);
            }else{
                operadorDerecha = Double.valueOf(valor);
                System.out.println(operadorDerecha);
            }
            resultado.setText(valor);
            System.out.println(resultado);
        }
    }

    private class OperacionBtnClicado implements ActionListener{
        private Operacion operacion;
        public OperacionBtnClicado(Operacion operacion){
            this.operacion=operacion;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            calcOperacion= operacion;
            operadorIsquierda = Double.valueOf(resultado.getText());
            System.out.println(calcOperacion);
        }
    }

    private class BtnLimpiar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resultado.setText("");
            operadorIsquierda = 0.0;
            operadorDerecha = 0.0;
        }
    }

    private class PuntoDecimalBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resultado.setText(resultado.getText() + ".");

        }
    }

    private class BtnIgual implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Double output = calcOperacion.getOperador().applyAsDouble(operadorIsquierda, operadorDerecha);
            resultado.setText(output%1==0?String.valueOf(output.intValue()):String.valueOf(output));
            operadorIsquierda = 0.0;
            operadorDerecha = 0.0;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora-Xpres 2.0");
        frame.setContentPane(new Calculadora().CalculadoraView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
