package ge.edu.btu.chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true){
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();
            System.out.println("სერვერი ჩართულია");


            double kursi = 2.97;
            String[] filialebi = {"ი.ჭავჭავაძის გამზირი", "ვაჟა ფშაველას გამზირი"};

//        stream
            ObjectInputStream stream = new ObjectInputStream(s.getInputStream());
            String msg = (String) stream.readObject();

            if (msg.contains("კურსი")) {
                System.out.println("ეროვნული კურსია: " + kursi);
            }

            else if (msg.contains("ფილიალ")) {
                for (String each :
                        filialebi) {
                    System.out.println(each);
                }
            }

            else if (msg.contains("მადლობა")) {
                System.out.println("მადლობთ რომ დაგვიკავშირდით ნახვამდის");;
                }
            else {
                System.out.println("ამ კითხვაზე პასუხი არ მაქვს");
            }
            //        close
            s.close();
            ss.close();

        }
    }

}

