package com.company;

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

    public void Connect() {
        try {
            soc = new Socket(ip, host);
            input = new DataInputStream(soc.getInputStream());
            output = new DataOutputStream(soc.getOutputStream());
            playerID = input.readInt();

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

        LogIn login = new LogIn(this);

    }

    public void setName(String name) {
    }


}
