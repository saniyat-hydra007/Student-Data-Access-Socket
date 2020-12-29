import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListTest {
    public static void main(String[] args) {



        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String data = reader.readLine();

                try {
                    if (data.equals("search")) {
                        BufferedReader r = new BufferedReader(new FileReader("A.txt"));
                        Scanner myReader = new Scanner(r);

                        String a = reader.readLine().trim();

                        while (myReader.hasNextLine()) {
                            String s = myReader.nextLine();
                            String str[] = s.split(" ");

                            if (a.equals(str[1].trim())) {
                                writer.write(s);
                                writer.flush();
                            }
                        }
                        myReader.close();
                        r.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class BankAccount {
    String name;
    int id;
    double balance;
    int phoneNum;

    public BankAccount(String name, int id, double balance, int phoneNum) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.phoneNum = phoneNum;
    }
}

