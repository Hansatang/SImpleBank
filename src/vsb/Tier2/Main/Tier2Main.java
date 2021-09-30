package vsb.Tier2.Main;



public class Tier2Main {

    public static void main(String[] args) {
        try {
            Tier2MainController controller = new Tier2MainController();

            System.out.println("Tier25 ready");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
