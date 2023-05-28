package org.example.composition;

public class SalesDepartment implements Department {
    @Override
    public void print() {
        System.out.println("sales");
    }
}
