package vsb.Tier2.Main;

import vsb.common.ITier2;
import vsb.common.ITier25;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static vsb.common.ITier2.T2_SERVICE_NAME;

public class Tier2MainController extends UnicastRemoteObject implements ITier25 {


    public Tier2MainController() throws RemoteException {

        try {
            Naming.rebind(T25_SERVICE_NAME, this);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public ITier2 getServer(String location) throws MalformedURLException, NotBoundException, RemoteException {
        return (ITier2) Naming.lookup(T2_SERVICE_NAME + location);
    }
}

