package vsb.Tier1Clerk;

import java.rmi.RemoteException;
import java.util.Scanner;

public class StartTier1Clerk {
    public static void main(String[] args) throws RemoteException {
        Tier1Clerk tier1Clerk = new Tier1Clerk();

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Operation?W/I ");
            String operation = in.nextLine();
            if (operation.equals("W")) {
                System.out.println("Account number? ");
                int accountNumber = in.nextInt();

                System.out.println("Withdrawn amount? ");
                double amount = in.nextDouble();
                tier1Clerk.withdraw(accountNumber, amount);
            } else if (operation.equals("I")) {
                System.out.println("Account number? ");
                int accountNumber = in.nextInt();

                System.out.println("Insert amount? ");
                double amount = in.nextDouble();
                tier1Clerk.insert(accountNumber, amount);
            }

        }
    }

}
