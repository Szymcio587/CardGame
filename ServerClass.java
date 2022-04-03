import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class ServerClass{
    private String ip;
    private int host, playersNumber, maxPlayers;
    private Socket soc;
    private ServerSocket ss;
    private DataInputStream input;
    private DataOutputStream output;

    private static ServerClass server = null;

    public void CreateServer(String ip, int host) {
        this.ip = ip;
        this.host = host;
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

                output.writeInt(++playersNumber);
                System.out.println("Połączono się z graczem numer " + playersNumber);
            }

            System.out.println("Zaraz gra się rozpocznie...");
        }
        catch (Exception e) {
            System.out.println(e);
            Error er = new Error("Nie udało się nawiązać połączenia z graczami");
        }
    }

    public int getPlayersNumber() {
        return playersNumber;
    }

    public static ServerClass getServer() {
        if(server == null) {
            server = new ServerClass();
            System.out.println("Nowy serwer");
        }
        return server;
    }

    public static void main(String[] args) {
        server = new ServerClass();
        server.CreateServer("localhost", 6666);
    }
}
