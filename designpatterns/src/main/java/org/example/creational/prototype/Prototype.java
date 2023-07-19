package org.example.creational.prototype;

public class Prototype implements Cloneable {
    private int someInt;
    private String someString;

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public Prototype copy() {
        return this;
    }

    public Prototype deepCopy() {
        return this.clone();
    }

    @Override
    public Prototype clone() {
        Prototype cloned = new Prototype();
        cloned.setSomeInt(this.someInt);
        cloned.setSomeString(this.someString);

        return cloned;
    }
}


class Main {
    public static void main(String[] args) {
        Prototype p = new Prototype();
        p.setSomeInt(1);
        p.setSomeString("main");
        Prototype copy = p.copy();
        Prototype clone = p.deepCopy();
        copy.setSomeString("copy");
        clone.setSomeString("clone");

        System.out.println();
        System.out.println(p.getSomeString().equals(copy.getSomeString())); // true
        System.out.println(p.getSomeString().equals(clone.getSomeString())); // false
    }
}
