public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.put("a",2);
        context.put("b",5);
        context.put("c",8);
        context.put("d",9);

        AbstractExpression expression1 = new MultiplyNonTerminalExpression(new NumberTerminalExpression("a"), new NumberTerminalExpression("b"));

        System.out.println(expression1.interpret(context));

        AbstractExpression expression2 = new SumNonTerminalExpression(new MultiplyNonTerminalExpression(new NumberTerminalExpression("a"),new NumberTerminalExpression("b")),new MultiplyNonTerminalExpression(new NumberTerminalExpression("c"),new NumberTerminalExpression("d")));
        System.out.println(expression2.interpret(context));
    }
}