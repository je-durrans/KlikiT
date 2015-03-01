import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public final static int PORT = 8888;
    public ArrayList<Thread> threads = new ArrayList<>();
    public static ArrayList<String> questions = new ArrayList<>();

    public static void main(String[] args) {
        try{
            Server s = new Server();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Server()
            throws IOException {
        ServerSocket ss = new ServerSocket( PORT );

        while ( true ) {
            Socket s = ss.accept();
            Thread t = new Thread( new Worker( s ) );
            t.start();
            threads.add(t);
        }
    }
}
