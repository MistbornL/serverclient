package ge.edu.btu.chat.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s =new Socket ("localhost", 4999);
        System.out.println("მიმდინარეობს კავშირის დამყარება...");
        ObjectOutputStream ostream = new ObjectOutputStream(s.getOutputStream());
        while (true){;

            Scanner scanner = new Scanner(System.in);
            System.out.println("დასვი შეკითხვა: ");
            String quest = scanner.nextLine();


            ostream.writeObject(quest);
            System.out.println("message sent");


            s.close();
            ostream.close();}

    }

}
