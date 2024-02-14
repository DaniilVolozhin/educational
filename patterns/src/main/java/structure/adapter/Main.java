package structure.adapter;

public class Main {
    public static void main(String[] args) {
        Adapter a = new Adapter(new BankAccount());
        System.out.println(a.getSummaUSD());
    }
}
