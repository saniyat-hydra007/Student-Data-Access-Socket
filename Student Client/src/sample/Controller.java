package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller {

    @FXML
    TextField searchTF;

    @FXML
    TextArea InfoTA;

    @FXML
    TextField nameTF;

    @FXML
    TextField idTF;

    @FXML
    TextField balanceTF;

    @FXML
    TextField phonenumTF;


    BufferedReader reader;
    BufferedWriter writer;

    public Controller() {
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void searchFunction() {
        String a = searchTF.getText();

        try {
            writer.write("search\n");

            writer.write(a);
            writer.newLine();

            writer.flush();

            String res = reader.readLine();
            InfoTA.setText(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e2){
            e2.printStackTrace();
        }
    }

    @FXML
    void AddFunction() {
        String name = nameTF.getText().trim();
        String id = idTF.getText().trim();
        String balance = balanceTF.getText().trim();
        String phoneNum = phonenumTF.getText().trim();

        try {
            writer.write("add\n");

            writer.write(name);
            writer.newLine();
            writer.flush();

            writer.write(id);
            writer.newLine();
            writer.flush();

            writer.write(balance);
            writer.newLine();
            writer.flush();

            writer.write(phoneNum);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
        e.printStackTrace();
    }
        catch (NullPointerException e2){
        e2.printStackTrace();
    }
    }

    @FXML
    void UpdateFunction() {
        String name1 = nameTF.getText().trim();
        String id1 = idTF.getText().trim();
        String balance1 = balanceTF.getText().trim();
        String phoneNum1 = phonenumTF.getText().trim();

        try {
            writer.write("update\n");

            writer.write(name1);
            writer.newLine();
            writer.flush();

            writer.write(id1);
            writer.newLine();
            writer.flush();

            writer.write(balance1);
            writer.newLine();
            writer.flush();

            writer.write(phoneNum1);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e2){
            e2.printStackTrace();
        }
    }
}
