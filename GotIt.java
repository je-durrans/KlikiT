/**
 * Created by Kate on 28-Feb-15.
 */
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
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
        GotIt lol = new GotIt();
    }

    public GotIt() {

        final JFrame window = this;//new GotIt( "KlikiT" );
        window.setSize( 240, 427 );

        line1.setAlignment(Label.CENTER);


        //adding the event listeners to buttons
        yes_buttn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {
                line1.setText("GR8!");
            }
        } );

        no_buttn.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //Layout.layout.dispatchEvent(new WindowEvent(Layout.layout, WindowEvent.WINDOW_CLOSING));
                new AskQ();
                window.setVisible(false);
                window.dispose();
            }
        });

        back_buttn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {
            }
        } );


        refresh_buttn.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev ) {

            }
        } );
        window.setLayout(null);
        line1.setBounds(10, 10, 200, 80); window.add(line1);

        yes_buttn.setBounds(30, 215, 70, 40); window.add(yes_buttn);
        no_buttn.setBounds(140, 215, 70, 40); window.add(no_buttn);
        back_buttn.setBounds(10, 300, 90, 20); window.add(back_buttn);
        refresh_buttn.setBounds(140, 300, 90, 20); window.add(refresh_buttn);


        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
    }
}
