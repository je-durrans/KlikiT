/**
 * Created by Kate on 28-Feb-15.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**

 */
public class AskQ extends JFrame {


    public static String input = ""; //a string to hold the input

    //declaring the lines
    final static TextField question = new TextField();

    //declaring the buttons
    final JButton ask_buttn = new JButton("ASK");
    final JButton back_buttn = new JButton("BACK");
    final JButton refresh_buttn = new JButton("REFRESH");

    public static void main(String[] args) {
        try{ AskQ lol = new AskQ();} catch (IOException i) {}
    }

    public AskQ() throws IOException{

        final JFrame window = this;
        window.setSize(240, 427);
        BufferedImage bf = ImageIO.read(new File("back1.jpg"));

// adding created component to the JFrame using my backImage class
        this.setContentPane(new backImage(bf));




        ask_buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                input = question.getText();
            }
        });

        back_buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try{
                new MyFrame();} catch (IOException i) {i.printStackTrace();}
                window.setVisible(false);
                window.dispose();
            }
        });


        refresh_buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try{
                    new AskQ();} catch (IOException i) {i.printStackTrace();}
                window.setVisible(false);
                window.dispose();
            }
        });

        window.setLayout(null);
        question.setBounds(10, 10, 210, 200);
        window.add(question);


        ask_buttn.setBounds(140, 215, 70, 40);
        window.add(ask_buttn);
        back_buttn.setBounds(10, 300, 90, 20);
        window.add(back_buttn);
        refresh_buttn.setBounds(140, 300, 90, 20);
        window.add(refresh_buttn);


        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
    class backImage extends JComponent {
        Image i;
        //Creating Constructer
        public backImage(Image i) {
            this.i = i;
        }
        //Overriding the paintComponent method
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
        }
    }
}
