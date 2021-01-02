import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListTest {
    public static void main (String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            Socket socket = serverSocket.accept();

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String data = reader.readLine().trim();

            while (data != null) {
            try {
                if (data.equals("search")) {
                    BufferedReader r = new BufferedReader(new FileReader("A.txt"));
                    Scanner myReader = new Scanner(r);

                    String a = reader.readLine();

                 while (myReader.hasNextLine()) {
                        String s = myReader.nextLine().trim();
                        String str[] = s.split(" ");

                        if (a.equals(str[1])) {
                            writer.write(s);
                            writer.flush();
                        }
                    }
                    myReader.close();
                    r.close();
                }
            }catch (ArrayIndexOutOfBoundsException e2){
                e2.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            }

            //while (data != null) {
            try {
                if (data.equals("add")) {
                    FileWriter addReader = new FileWriter("A.txt", true);

                    String data1 = reader.readLine().trim();
                    String data2 = reader.readLine().trim();
                    String data3 = reader.readLine().trim();
                    String data4 = reader.readLine().trim();

                    addReader.write(data1 + " " + data2 + " " + data3 + " " + data4 + "\n");

                    addReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //}

            try {
                if (data.equals("update")) {
                    BufferedReader r = new BufferedReader(new FileReader("A.txt"));
                    Scanner myReader = new Scanner(r);

                    String data1 = reader.readLine().trim();
                    String data2 = reader.readLine().trim();
                    String data3 = reader.readLine().trim();
                    String data4 = reader.readLine().trim();


                    while (myReader.hasNextLine()) {
                        String s = myReader.nextLine();
                        String str[] = s.split(" ");

                        if (data2.equals(str[1])) {
                            System.out.println(s);
                        }
                    }
                    myReader.close();
                    r.close();
                }

            } catch (IOException e) {
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

