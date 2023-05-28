package org.example.proxy;

public class PrinterProxy implements Print{

    private final PrinterClass printerClass;
    public PrinterProxy(PrinterClass printerClass) {
        this.printerClass = printerClass;
    }
    @Override
    public void print() {
        System.out.println("before");
        printerClass.print();
        System.out.println("after");
    }
}

class Test {
    public static void main(String[] args) {
        PrinterProxy printerProxy = new PrinterProxy(new PrinterClass());
        printerProxy.print();
    }
}
