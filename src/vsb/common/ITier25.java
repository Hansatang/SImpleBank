package vsb.common;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITier25 extends Remote {
    public static final String T25_SERVICE_NAME = "rmi://localhost:1099/T25";

    public ITier2 getServer(String location) throws MalformedURLException, NotBoundException, RemoteException;
}
