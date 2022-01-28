package structure.adapter;

import structure.adapter.Adapter;
import structure.adapter.BankAccount;

public class Main {
    public static void main(String[] args) {
        Adapter a = new Adapter(new BankAccount());
        System.out.println(a.getSummaUSD());
    }
}
