/*
 * 12.09.2018 Original version
 */


package vsb.tier3;



import java.rmi.registry.LocateRegistry;

public class Tier3 {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Tier3Controller controller = new Tier3Controller();
            System.out.println("Tier3 ready");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
