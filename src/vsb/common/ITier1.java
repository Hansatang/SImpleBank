package vsb.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITier1 extends Remote {

    void replyGet(String result) throws RemoteException;

}
