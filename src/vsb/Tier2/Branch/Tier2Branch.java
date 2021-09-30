/*
 * 12.09.2018 Original version
 */


package vsb.Tier2.Branch;

import java.util.Scanner;

public class Tier2Branch {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Where are you?");
            String location = in.nextLine();
            Tier2BranchController controller = new Tier2BranchController(location);

            System.out.println("Tier2 ready");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
