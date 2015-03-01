import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Katya on 01-Mar-15.
 */
public class Lecturer extends JFrame {
    final JButton close = new JButton( "CLOSE" );
    public String input;

    public static void main(String[] args) {
        try{Lecturer lol = new Lecturer();} catch (IOException e) {}
    }

    public Lecturer() throws IOException{
        final Label line1 = new Label(input);
        final JFrame window = this;
        window.setSize( 240, 427 );

        line1.setAlignment(Label.CENTER);
        BufferedImage bf = ImageIO.read(new File("back1.jpg"));

// adding created component to the JFrame using my backImage clas
        this.setContentPane(new backImage(bf));


        //adding the event listeners to buttons
        close.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {
                window.dispose();
            }
        } );
        window.setLayout(null);
        line1.setBounds(10, 10, 220, 140); window.add(line1);
        close.setBounds(30, 300, 190, 27);window.add(close);

        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}
