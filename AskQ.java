/**
 * Created by Kate on 28-Feb-15.
 */
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

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
        AskQ lol = new AskQ();
    }

    public AskQ() {

        final JFrame window = this;
        window.setSize(240, 427);




        ask_buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                input = question.getText();
            }
        });

        back_buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //go home
            }
        });


        refresh_buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                new AskQ();
                window.setVisible(false);
                window.dispose();
            }
        });

        window.setLayout(null);
        question.setBounds(10, 10, 380, 80);
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
}
