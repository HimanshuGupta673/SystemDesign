import ArithmeticExpressionDesign.ArithmeticExpression;
import ArithmeticExpressionDesign.Expression;
import ArithmeticExpressionDesign.Number;
import ArithmeticExpressionDesign.Operation;
import FileSystemDesign.Directory;
import FileSystemDesign.File;
import FileSystemDesign.FileSystem;

public class Main {
    public static void main(String[] args) {
//        FileDirectory-------
//        Directory movieDirectory = new Directory("Movie");
//        FileSystem border = new File("Border");
//        movieDirectory.add(border);
//
//        Directory comedyMovieDirectory = new Directory("ComedyMovie");
//        FileSystem hulchul = new File("Hulchul");
//
//        comedyMovieDirectory.add(hulchul);
//        movieDirectory.add(comedyMovieDirectory);
//
//        movieDirectory.ls();

//        ArithmeticExpression-------------
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression addExpression = new Expression(one,seven, Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(two, addExpression, Operation.MULTIPLY);

        System.out.println(parentExpression.evaluate());
    }
}