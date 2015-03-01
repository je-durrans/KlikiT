/**
 * Created by Kate on 28-Feb-15.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**

 */
public class GotIt extends JFrame {

    public static String input = ""; //a string to hold the input

    //declaring the lines
    final static Label line1 = new Label("UNDERSTAND?");

    //declaring the buttons
    final JButton yes_buttn = new JButton( "YES" );
    final JButton no_buttn = new JButton ( "NO" );
    final JButton back_buttn = new JButton ( "BACK" );
    final JButton refresh_buttn = new JButton ( "REFRESH");

    public static void main(String[] args) {
        try{GotIt lol = new GotIt();} catch (IOException e) {}
    }

    public GotIt() throws IOException{

        final JFrame window = this;//new GotIt( "KlikiT" );
        window.setSize( 240, 427 );


        line1.setAlignment(Label.CENTER);
        BufferedImage bf = ImageIO.read(new File("back1.jpg"));

// adding created component to the JFrame using my backImage class
        this.setContentPane(new backImage(bf));


        //adding the event listeners to buttons
        yes_buttn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {
                line1.setText("GREAT!");
            }
        } );

        no_buttn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try{
                    new AskQ();} catch (IOException i) {i.printStackTrace();}
                window.setVisible(false);
                window.dispose();
            }
        });

        back_buttn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {
                try{new MyFrame();}catch (IOException e) {}
                window.setVisible(false);
                window.dispose();
            }
        } );


        refresh_buttn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {
                try {new GotIt();} catch (IOException e) {}
                window.setVisible(false);
                window.dispose();
            }
        } );
        window.setLayout(null);
        line1.setBounds(10, 10, 220, 80); window.add(line1);

        yes_buttn.setBounds(30, 215, 70, 40); window.add(yes_buttn);
        no_buttn.setBounds(140, 215, 70, 40); window.add(no_buttn);
        back_buttn.setBounds(10, 300, 90, 20); window.add(back_buttn);
        refresh_buttn.setBounds(140, 300, 90, 20); window.add(refresh_buttn);



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
