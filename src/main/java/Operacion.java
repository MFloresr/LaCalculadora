import java.util.function.DoubleBinaryOperator;


public enum Operacion {
    SUMA((x, y) -> x + y),
    RESTA((x, y) -> x - y);

    private DoubleBinaryOperator operador;

    Operacion(DoubleBinaryOperator operador) {
        this.operador = operador;
    }

    public DoubleBinaryOperator getOperador() {
        return operador;
    }
}
