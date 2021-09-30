/*
 * 12.09.2018 Original version
 */


package vsb.Tier1Admin;


import vsb.common.ITier2;
import vsb.common.ITier25;
import vsb.model.Account;

import java.rmi.Naming;
import java.util.Scanner;

import static vsb.common.ITier25.T25_SERVICE_NAME;


public class Tier1Admin {
    public static void main(String[] args) {

        try {
            Scanner on = new Scanner(System.in);
            System.out.println("Where are you?");
            String location = on.nextLine();

            ITier25 tier25 = (ITier25) Naming.lookup(T25_SERVICE_NAME);
            ITier2 tier2 = tier25.getServer(location);

            Scanner in = new Scanner(System.in);
            System.out.println("Account number? ");
            int accountNumber = in.nextInt();
            Account account = tier2.createAccount(accountNumber);

            if (account == null) {
                System.out.println("Account number already taken");
            } else {
                System.out.println(account);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
