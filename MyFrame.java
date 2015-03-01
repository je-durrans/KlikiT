import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


//Creating extended class of JComponent class

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
public class MyFrame extends JFrame {
    public MyFrame()throws IOException {
        final JFrame window = this;
        window.setSize(240, 427);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        this.setTitle("KlikiT");
// read image file in my HardDisk using imageIO and assign it to buffered image reference
        BufferedImage bf = ImageIO.read(new File("back1.jpg"));

// adding created component to the JFrame using my backImage class
        this.setContentPane(new backImage(bf));
//adding other component
        JButton b = new JButton("ASK QUESTION");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                new AskQ();
                window.setVisible(false);
                window.dispose();
            }
        });
        b.setBounds(30, 300, 190, 27);
        this.add(b);
    }
    public static void main(String[] args) throws IOException {

        MyFrame f = new MyFrame();

        f.setVisible(true);
    }

}
