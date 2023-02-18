package textbox;

public class Main {
    public static void main(String[] args) {
        TextBox textBox = new TextBox();
        textBox.setText("Box 1".toLowerCase());
        System.out.println(textBox.text);
    }
}