import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ServerClass{
    private int playersNumber, maxPlayers;
    private Socket player1, player2, player3;
    private ReadFromClient read_p1, read_p2, read_p3;
    private WriteToClient write_p1, write_p2, write_p3;
    private ReadFromGame read_game;
    private WriteToGame write_game;
    private ServerSocket ss;
    private DataInputStream input;
    private DataOutputStream output;
    private String[] names = new String[3];
    private String[] paths = new String[24];

    private class ReadFromClient implements Runnable {
        private int playerID;
        private DataInputStream input;

        public ReadFromClient(int id, DataInputStream in) {
            playerID = id;
            input = in;
            System.out.println("R Runnable created");
        }

        public void run() {

        }

        public void readName() {
            try {
                names[playerID - 1] = input.readUTF();
            }
            catch (Exception e) {
                Error er = new Error("Błąd wczytywania imienia na serwerze");
            }
        }
    }

    private class WriteToClient implements Runnable {
        private int playerID;
        private DataOutputStream output;

        public WriteToClient(int id, DataOutputStream out) {
            playerID = id;
            output = out;
            System.out.println("W Runnable created");
        }

        public void run() {

        }

        public void SendStartMessage() {
            try {
                output.writeUTF("Kolejny gracz się połączył");
            }
            catch (Exception ex){
                Error er = new Error("Błąd podczas startu serwera.");
            }
        }

        public void sendNames() {
            try {
                for(int q=0; q<3; q++) {
                    output.writeUTF(names[q]);
                    output.flush();
                }
            }
            catch(Exception e) {
                Error er = new Error("Błąd podawania imion przez serwer");
            }
        }

        public void sendPaths() {
            try {
                if(playerID == 1) {
                    for(int q=0; q<24; q++) {
                        if(q < 7 || q > 20) {
                            output.writeUTF(paths[q]);
                        }
                        else {
                            output.writeUTF("Classic/back.png");
                        }
                    }
                }
                if(playerID == 2) {
                    for(int q=0; q<24; q++) {
                        if((q < 14 && q > 6) || q > 20) {
                            output.writeUTF(paths[q]);
                        }
                        else {
                            output.writeUTF("Classic/back.png");
                        }
                    }
                }
                if(playerID == 3) {
                    for(int q=0; q<24; q++) {
                        if(q > 13) {
                            output.writeUTF(paths[q]);
                        }
                        else {
                            output.writeUTF("Classic/back.png");
                        }
                    }
                }
            }
            catch(Exception e) {
                Error er = new Error("Błąd podczas przesyłania kart");
            }
        }
    }

    private class WriteToGame implements Runnable {
        public void run() {

        }
    }

    private class ReadFromGame implements Runnable {
        public void run() {

        }
    }

    public void CreateServer() {
        playersNumber = 0;
        maxPlayers = 3;
        try {
            ss = new ServerSocket(6666);
        } catch(IOException e) {
            Error er = new Error("Nie udało się znaleźć podanego portu");
        }

        LookForConnections();
    }

    public void LookForConnections() {
        try {
            while(playersNumber < maxPlayers) {
                Socket soc = ss.accept();
                input = new DataInputStream(soc.getInputStream());
                output = new DataOutputStream(soc.getOutputStream());
                //names.add(input.readUTF());

                output.writeInt(++playersNumber);
                System.out.println("Połączono się z graczem numer " + playersNumber);

                ReadFromClient rfc = new ReadFromClient(playersNumber, input);
                WriteToClient wtc = new WriteToClient(playersNumber, output);
                switch(playersNumber) {
                    case 1:
                        player1 = soc;
                        read_p1 = rfc;
                        write_p1 = wtc;
                        read_p1.readName();
                        break;
                    case 2:
                        player2 = soc;
                        read_p2 = rfc;
                        write_p2 = wtc;
                        read_p2.readName();
                        break;
                    case 3:
                        //startGame();
                        player3 = soc;
                        read_p3 = rfc;
                        write_p3 = wtc;
                        read_p3.readName();
                        write_p1.SendStartMessage();
                        write_p2.SendStartMessage();
                        write_p3.SendStartMessage();
                        write_p1.sendNames();
                        write_p2.sendNames();
                        write_p3.sendNames();
                        write_p1.sendPaths();
                        write_p2.sendPaths();
                        write_p3.sendPaths();
                        Thread r_thread1 = new Thread(read_p1);
                        Thread r_thread2 = new Thread(read_p2);
                        Thread r_thread3 = new Thread(read_p3);
                        r_thread1.start();
                        r_thread2.start();
                        r_thread3.start();
                        Thread w_thread1 = new Thread(write_p1);
                        Thread w_thread2 = new Thread(write_p2);
                        Thread w_thread3 = new Thread(write_p3);
                        w_thread1.start();
                        w_thread2.start();
                        w_thread3.start();
                        break;
                }
            }

            System.out.println("Zaraz gra się rozpocznie...");
            //Game game = new Game(players);
        }
        catch (Exception e) {
            Error er = new Error("Nie udało się nawiązać połączenia z graczami");
        }
    }

    public void startGame() {
        Game g = new Game();
        for(int q=0; q<24; q++) {
            paths[q] = g.getPath((int)q/7, q%7);
        }
    }

    public static void main(String[] args) {
        ServerClass server = new ServerClass();
        server.CreateServer();
    }
}
