import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class PlayerCommunicator {
    private String ip;
    private int host, playerID;
    private Socket soc;
    private DataInputStream input;
    private DataOutputStream output;
    private boolean connection;
    private ReadFromServer rfs;
    private WriteToServer wts;
    private String[] names = new String[3];
    private String[] paths = new String[24];
    private boolean start_game;

    public class ReadFromServer implements Runnable {
        private DataInputStream input;
        private Thread r_thread, w_thread;

        public ReadFromServer(DataInputStream in) {
            input = in;
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

        public void readPaths() {
            try {
                for(int q=0; q<24; q++) {
                    paths[q] = input.readUTF();
                }
            }
            catch (Exception e){
                Error er = new Error("Błąd podczas pobierania kart");
            }
        }
    }

    public class WriteToServer implements Runnable {
        private DataOutputStream output;

        public WriteToServer(DataOutputStream out) {
            output = out;
        }

        public void run() {
            try {
                while(true) {

                }
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

    public void Connect() {
        try {
            soc = new Socket(ip, host);
            input = new DataInputStream(soc.getInputStream());
            output = new DataOutputStream(soc.getOutputStream());
            playerID = input.readInt();
            if(playerID != 1) {
                setName(getName(0), playerID-1);
                setName("noname", 0);
            }
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
        connection = false;
        playerID = 0;
        start_game = false;

        LogIn login = new LogIn(this);

    }

    public ReadFromServer Read() {
        return rfs;
    }

    public WriteToServer Write() {
        return wts;
    }

    public String getPath(int index) {
        return paths[index];
    }

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

    public void setStart_game(boolean start_game) {
        this.start_game = start_game;
    }
}
