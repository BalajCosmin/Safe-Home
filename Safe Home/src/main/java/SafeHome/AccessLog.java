package SafeHome;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccessLog {


    ArrayList<AccessLog> logList = new ArrayList<>();


    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus doorStatus;
    private String errorMessage;


    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus doorStatus, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.doorStatus = doorStatus;
        this.errorMessage = errorMessage;
    }

    public AccessLog() {

    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(Tenant t) {
        this.tenantName = t.toString();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<AccessLog> getLogList() {
        return logList;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    public void addLog(AccessLog a) {

        logList.add(a);

    }

    public void printLog() {
        System.out.println("Show products:");
        for (AccessLog a : logList)
            System.out.println(logList.toString());


    }

    @Override
    public String toString() {
        return "AccessLog{" +
                "logList=" + logList +
                '}';
    }
}






