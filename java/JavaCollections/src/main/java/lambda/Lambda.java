package lambda;

public class Lambda {

    public static void main(String[] args) {
        Printable meow = s -> "Meow" + s;
        printable(meow);
    }

    private static void printable(Printable thing) {
        thing.print("!");
    }
}
