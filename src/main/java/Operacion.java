import java.util.function.DoubleBinaryOperator;

/**
 * Created by Vipi on 02/02/2016.
 */
public enum Operacion {
    SUMA((x, y) -> x + y),
    RESTA((x, y) -> x - y);
    //DIVISION((x, y) -> x / y),
    //MULTIPLICACION((x, y) -> x * y),
    //PORCENTAGE((x, y) -> x % y);

    private DoubleBinaryOperator operador;

    Operacion(DoubleBinaryOperator operador) {
        this.operador = operador;
    }

    public DoubleBinaryOperator getOperador() {
        return operador;
    }
}
