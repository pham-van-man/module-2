import javax.swing.*;

public class HelloWorld extends JFrame {
    private JButton button1;
    private JPanel panel1;
    private JTextPane text;

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setTitle("Hello World");
        helloWorld.setSize(500, 500);
        helloWorld.setVisible(true);
    }
}
