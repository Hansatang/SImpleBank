/*
 * 12.09.2018 Original version
 */

package vsb.Tier2.Branch;

import vsb.common.ITier1;
import vsb.common.ITier2;
import vsb.common.ITier3;
import vsb.model.Account;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static vsb.common.ITier3.T3_SERVICE_NAME;


public class Tier2BranchController extends UnicastRemoteObject implements ITier2 {
    private ITier3 tier3;
    private String location;
    private HashMap<String, List<ITier1>> users = new HashMap<String, List<ITier1>>();


    public Tier2BranchController(String location) throws RemoteException {
        try {
            this.location = location;
            Naming.rebind(T2_SERVICE_NAME + location, this);

            tier3 = (ITier3) Naming.lookup(T3_SERVICE_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }


    public Account withdraw(int accountNumber, double amount) throws RemoteException, SQLException {
        System.out.println(location);
        Account account = tier3.getAccount(accountNumber);
        if (account == null)
            return null;
        else if (amount <= 0.0 || amount > account.getBalance())
            return null;
        else {
            account.updateBalance(-amount);
            Account account1 = tier3.updateAccount(account);
            send(account1);
            return account1;
        }
    }


    public Account insert(int accountNumber, double amount) throws RemoteException, SQLException {
        Account account = tier3.getAccount(accountNumber);
        if (account == null)
            return null;
        else {
            account.updateBalance(amount);
            Account account1 = tier3.updateAccount(account);

            send(account1);
            return account1;
        }
    }

    @Override
    public Account createAccount(int accountNumber) throws RemoteException {
        Account account = new Account(accountNumber, 0.0);
        return tier3.createAccount(account);
    }

    @Override
    public void saveClient(String userTypedText, ITier1 tier1Customer) throws RemoteException {
        System.out.println("WER");
        ArrayList<ITier1> tier1s = new ArrayList<>();
        tier1s.add(tier1Customer);
        if (users.containsKey(userTypedText)) {
            if (users.get(userTypedText).contains(tier1Customer)) {

            } else {
                users.get(userTypedText).add(tier1Customer);
            }
        } else {
            users.put(userTypedText, tier1s);
        }
        System.out.println(users.get(userTypedText).size());
    }

    private void send(Account account) {

        for (ITier1 tier1 : users.get(String.valueOf(account.getNumber()))
        ) {
            try {
                System.out.println("Hej");
                tier1.replyGet(account.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        for (ITier1 tier1 : users.get("0000")
        ) {
            try {
                System.out.println("Hej");
                tier1.replyGet(account.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

}
