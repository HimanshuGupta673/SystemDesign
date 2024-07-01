public class NumberTerminalExpression implements AbstractExpression{

    String stringValue;

    NumberTerminalExpression(String stingValue) {
        this.stringValue = stingValue;
    }

    @Override
    public int interpret(Context context) {
        return context.get(stringValue);
    }
}
