package other;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(String a, String b) {
        int numA = Integer.parseInt(a);
        int numB = Integer.parseInt(b);
        return numA + numB;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public double multiple(double a, double b) {
        return a * b;
    }


    public double divide(double a, double b) {
        return a / b;
    }

    public double divide(String a, String b) {
        double dubA = Double.parseDouble(a);
        double dubB = Double.parseDouble(b);
        return dubA / dubB;
    }


    public double square(double a) {
        return a * a;
    }

}
