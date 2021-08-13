package SafeHome;

public class Door {
  private DoorStatus status;

    public Door(DoorStatus close) {
        this.status=DoorStatus.CLOSE;
    }

    public void lockDoor(){
        this.status=DoorStatus.CLOSE;
    }
    public void unlockDoor(){
        this.status=DoorStatus.OPEN;
    }

    public DoorStatus getStatus() {
        return this.status;
    }
}
