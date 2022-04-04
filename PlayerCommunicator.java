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
    String name;

    public void Connect() {
        try {
            soc = new Socket(ip, host);
            input = new DataInputStream(soc.getInputStream());
            output = new DataOutputStream(soc.getOutputStream());
            playerID = input.readInt();
            connection = true;

            if(playerID != 3) {
                System.out.println("Zaczekaj na pozostałych graczy...");
            }
        }
        catch (Exception g) {
            Error er = new Error("Graczowi nie udało się połączyć z serwerem");
        }
    }

    public boolean isConnected() {
        return connection;
    }

    public PlayerCommunicator(String ip, int host) {
        this.ip = ip;
        this.host = host;
        connection = false;
        playerID = 0;

        LogIn login = new LogIn(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getID() {
        if(this.playerID == 0)
            return false;
        return true;
    }

}
