<<<<<<< HEAD
package com.company;

=======
import javax.xml.crypto.Data;
>>>>>>> 8b1583c (Przekazywanie podstawowych danych gracz-serwer, naprawa błędów)
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class PlayerCommunicator {
    private String ip;
    private int host, playerID;
    private Socket soc;
    private DataInputStream input;
    private DataOutputStream output;
<<<<<<< HEAD
    private boolean connection;
=======
    private ReadFromServer rfs;
    private WriteToServer wts;
    private String[] names = new String[3];
    private boolean start_game;

    private class ReadFromServer implements Runnable {
        private DataInputStream input;
        private Thread r_thread, w_thread;

        public ReadFromServer(DataInputStream in) {
            input = in;
            System.out.println("Receiving message to server...");
        }

        public void run() {
            try{

            }
            catch(Exception e){
                Error er = new Error("Błąd komunikacji z serwerem u gracza nr." + playerID + "podczas czytania");
            }
        }

        public void WaitForStart() {
            try {
                String msg = input.readUTF();
                r_thread = new Thread(rfs);
                w_thread = new Thread(wts);
                r_thread.start();
                w_thread.start();
            }
            catch (Exception e) {
                Error er = new Error("Błąd podczas tworzenia rozgrywki");
            }
        }

        public void readNames() {
            try {
                for(int q=0; q<3; q++) {
                    names[q] = input.readUTF();
                }
            }
            catch (Exception e){
                Error er = new Error("Błąd podczas pobierania imion");
            }
        }
    }

    private class WriteToServer implements Runnable {
        private DataOutputStream output;

        public WriteToServer(DataOutputStream out) {
            output = out;
            System.out.println("Sending message from server...");
        }

        public void run() {
            try {

            }
            catch (Exception e){
                Error er = new Error("Błąd komunikacji z serwerem u gracza nr." + playerID + "podczas pisania");
            }
        }

        public void giveName() {
            try {
                output.writeUTF(names[playerID - 1]);
                output.flush();
            }
            catch (Exception e) {
                Error er = new Error("Błąd podczas wysyłania imienia");
            }
        }
    }
>>>>>>> 8b1583c (Przekazywanie podstawowych danych gracz-serwer, naprawa błędów)

    public void Connect() {
        try {
            soc = new Socket(ip, host);
            input = new DataInputStream(soc.getInputStream());
            output = new DataOutputStream(soc.getOutputStream());
            playerID = input.readInt();
<<<<<<< HEAD

=======
            if(playerID != 1) {
                setName(getName(0), playerID-1);
                setName("noname", 0);
            }
>>>>>>> 8b1583c (Przekazywanie podstawowych danych gracz-serwer, naprawa błędów)
            if(playerID != 3) {
                System.out.println("Zaczekaj na pozostałych graczy...");
            }
            rfs = new ReadFromServer(input);
            wts = new WriteToServer(output);
            wts.giveName();
            rfs.WaitForStart();
            rfs.readNames();
            start_game = true;
        }
        catch (Exception g) {
            Error er = new Error("Graczowi nie udało się połączyć z serwerem");
        }
    }

    public PlayerCommunicator(String ip, int host) {
        this.ip = ip;
        this.host = host;
<<<<<<< HEAD
        connection = false;
=======
        playerID = 0;
        start_game = false;
>>>>>>> 8b1583c (Przekazywanie podstawowych danych gracz-serwer, naprawa błędów)

        LogIn login = new LogIn(this);

<<<<<<< HEAD
    }

    public void setName(String name) {
    }

=======
    public String getName(int index) {
        return names[index];
    }

    public void setName(String name, int x) {
        this.names[x] = name;
    }

    public int  getID() {
        return playerID;
    }

    public boolean HasStarted() {
        return start_game;
    }
>>>>>>> 8b1583c (Przekazywanie podstawowych danych gracz-serwer, naprawa błędów)

    public void setStart_game(boolean start_game) {
        this.start_game = start_game;
    }
}
