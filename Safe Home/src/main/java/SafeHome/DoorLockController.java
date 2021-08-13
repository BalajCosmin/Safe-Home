package SafeHome;

import java.util.HashMap;
import java.util.Map;

public class DoorLockController implements ControllerInterface {

    private Door door;
    private final Map<Tenant, AccessKey> validAcces = new HashMap<>();


    private int count = 0;
    String MASTER_KEY = "MasterKeyValue";
    Tenant tenant;

    public DoorLockController(Tenant tenant) {
        this.tenant = tenant;
    }

    public DoorLockController(Door door) {
        this.door = door;
    }

    public DoorLockController() {

    }

    @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        AccessKey key = new AccessKey(pin);

        if(pin.equals(MASTER_KEY)){
            this.count=0;
            this.door.unlockDoor();

        }

        if(this.count==2){
            this.door.lockDoor();
            throw new TooManyAttemptsException();
        }

       else if (this.validAcces.containsValue(key)) {

            if(this.door.getStatus().equals(DoorStatus.CLOSE)){
                this.door.unlockDoor();}
            else this.door.lockDoor();
            }
            else {
            this.count++;
            //throw new InvalidPinException();
        }


    return this.door.getStatus();
        }

    @Override
    public String toString() {
        return "DoorLockController{" +
                "validAcces=" + validAcces +
                '}';
    }

    @Override
    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {

        validAcces.put(new Tenant(name), new AccessKey(pin));
        System.out.println("no errors");
        System.out.println(validAcces.size());




        }


    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        boolean bol = true;


        for (Map.Entry<Tenant, AccessKey> entry : validAcces.entrySet()) {

            // if give value is equal to value from entry
            // print the corresponding key
            if (entry.getKey().getName().equals(name)) {
                System.out.println("No errors");
                bol = false;
                validAcces.remove(name);
          //      accesLogList.add(new AccesLog(name, LocalDateTime.now(), "removeTenant", door.getStatus(), "no errors"));

            }
        }
        if (bol) {
            System.out.println("Tenant not found");
            //      accesLogList.add(new AccesLog(name, LocalDateTime.now(), "removeTenant", door.getStatus(), "tenant not found"));
            throw new TenantNotFoundException();
        }


    }
}


