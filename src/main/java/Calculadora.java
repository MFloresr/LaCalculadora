import javax.swing.*;
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
    private String operadorUno;
    private Double operadorIsquierda;
    private Double operadorDerecha ;
    private JPanel CalculadoraView;
    private Double resultadocalculo = 0.0;
    private String signo;
    ArrayList <Double> numeros= new ArrayList<Double>();
    ArrayList <String> signos= new ArrayList<String>();

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
        boton9.addActionListener(new NumeroBtnClicado(boton9.getText()));
        botonpunto.addActionListener(new NumeroBtnClicado(botonpunto.getText()));

        botonsuma.addActionListener(new OperacionBtnClicado(botonsuma.getText()));
        botonres.addActionListener(new OperacionBtnClicado(botonres.getText()));

        botonc.addActionListener(new BtnLimpiar());
        botonigual.addActionListener(new BtnIgual());
    }
    private class NumeroBtnClicado implements ActionListener{
        private String valor;
        public NumeroBtnClicado(String valor){
            this.valor=valor;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (operadorUno == null && valor != ".") {
                operadorUno = valor;
                resultado.setText(resultado.getText()+valor);
            } else {
                if(operadorUno!=null){
                    if(valor=="."){
                        if(operadorUno.contains(valor)){
                            botonpunto.setEnabled(false);
                        }else{
                            operadorUno = operadorUno+valor;
                            resultado.setText(resultado.getText() +valor);
                        }
                    }else{
                        operadorUno = operadorUno+valor;
                        resultado.setText(resultado.getText() +valor);
                    }
                }
            }
        }
    }

    private class OperacionBtnClicado implements ActionListener{
        private String valor;
        public OperacionBtnClicado(String valor){
            this.valor=valor;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(operadorUno!=null && (valor.equals("+")|| valor.equals("-"))){
                if(valor.equals("+")){
                    resultadocalculo= resultadocalculo +Double.valueOf(operadorUno);
                    resultado.setText(resultado.getText() +valor);
                    operadorUno=null;
                    signo="+";
                }if(valor.equals("-")){
                    resultadocalculo= resultadocalculo -Double.valueOf(operadorUno);
                    resultado.setText(resultado.getText() +valor);
                    operadorUno=null;
                    signo="-";
                }
                System.out.println(resultadocalculo);
            }
        }
    }
    private class BtnLimpiar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resultado.setText("");
            operadorUno=null;
            resultadocalculo=0.0;
        }
    }
    private class BtnIgual implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(signo.equals("+")){
                resultadocalculo = resultadocalculo+Double.valueOf(operadorUno);
            }else{
                resultadocalculo = resultadocalculo-Double.valueOf(operadorUno);
            }
            resultado.setText(String.valueOf(resultadocalculo));
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
