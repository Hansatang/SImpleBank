package vsb.Tier1Customer;

import vsb.common.ITier2;
import vsb.common.ITier25;
import vsb.model.Account;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import static vsb.common.ITier25.T25_SERVICE_NAME;

public class StartTier1Customer {

    public static void main(String[] args) throws RemoteException {
        Tier1Customer tier1Customer = new Tier1Customer();


        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Account number? or type exit to close");
            String userTypedText = in.nextLine();
            int accountNumber;
            if (userTypedText.equals("exit")) {
                break;
            } else {
                accountNumber = Integer.parseInt(userTypedText);
            }
            System.out.println("Withdrawn amount? ");
            double amount = in.nextDouble();
            tier1Customer.withdraw(accountNumber, amount);

        }
    }

}
