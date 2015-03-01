import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Worker implements Runnable {
    private Socket s;

    Worker( Socket s ) {

        this.s = s;
    }

    public void run() {
        try {
            InputStream  in   =  s.getInputStream();
            OutputStream out  =  s.getOutputStream();

            BufferedReader reader = new BufferedReader( new InputStreamReader( in ) );
            PrintWriter    writer = new PrintWriter( out );
            /*String question;
            String[] answers;
            answers = getQandA(reader);
            question = answers[0];
            answers = Arrays.copyOfRange(answers, 1, answers.length);
            */
            String content = reader.readLine() + "\n";
            Server.questions.add(content);
            //System.out.println("hi");
            //writer.print(content);
            //writer.print(question);
            //writer.print(answers);
            writer.flush();
            s.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private String[] getQandA(BufferedReader reader){
        String[] strings, temp;
        strings = new String[]{};
        int c;
        try {
            while ((c = reader.read()) != -1) {
                PrintWriter a = new PrintWriter(s.getOutputStream());
                a.write(c);
                a.flush();
                temp = new String[strings.length+1];
                for(int i = 0; i<strings.length; i++){
                    temp[i] = strings[i];
                }
                temp[strings.length] = String.valueOf(c);

                return temp;
            }
            return strings;
        }catch(Exception e) {
            e.printStackTrace();
            return new String[]{};
        }
    }
}
