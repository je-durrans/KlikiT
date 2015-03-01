import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    static String HOST  = "127.0.0.1"; /* localhost */
    final static int    PORT  =  8888;

    public static void main(String[] args) {
        new Thread(){
            public void run(){
                try {
                    new Client("192.168.15.1", "How are you finding this lecture?");
                }catch(Exception e){e.printStackTrace();}
            }
        }.start();
        //System.out.println("Client done");
    }

    public Client(String host, String/*[]*/ text) throws IOException {
        HOST = host;
        Socket s = new Socket( HOST, PORT );
        InputStream  in   =  s.getInputStream();
        OutputStream out  =  s.getOutputStream();

        BufferedReader reader = new BufferedReader( new InputStreamReader( in ) );
        PrintWriter writer = new PrintWriter( out );
        String/*[]*/ content=text;
        /*for(int i = 0; i<arg.length;i++){
            content=content+arg[i]+" ";
        }*/
        writer.print( content+"\r\n" );
        writer.flush();

        int c;
        while ( ( c = reader.read() ) != -1 ) {
            System.out.write( c );
        }

        s.close();
    }
}
