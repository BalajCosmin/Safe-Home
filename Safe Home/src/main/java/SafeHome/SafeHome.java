package SafeHome;

import java.util.ArrayList;
import java.util.List;

public class SafeHome {

    public static void main(String[] args) throws TooManyAttemptsException {
        Door door = new Door(DoorStatus.CLOSE);
        List<Tenant> tenantList = new ArrayList<>();
        DoorLockController controler = new DoorLockController(door);
        try {


            controler.addTenant("1234", "tenant1");
            controler.addTenant("1235", "tenant2");
            controler.addTenant("1634", "tenant3");

        } catch (TenantAlreadyExistsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
           controler.enterPin("1235");
            System.out.println(door.getStatus());


        } catch (InvalidPinException e) {

            e.printStackTrace();

        }


    }
}




