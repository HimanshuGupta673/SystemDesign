public class Main {
    public static void main(String[] args) {
//        this is the data i want to write into the word processor
//        total 58 character
//            t = 7times
//                h = 3 times
//                a = 3 times and so on

        ILetter object1 = LetterFactory.createLetter('t');
        object1.display(0,0);

        ILetter object2 = LetterFactory.createLetter('h');
        object2.display(0,1);
    }
}