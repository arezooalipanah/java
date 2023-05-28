package org.example.composition;

public class CompositeDepartment {
    private final Department department;

    public CompositeDepartment(Department d) {
        this.department = d;
    }

    public void print() {
        System.out.println("hhh");
        department.print();
    }


}
