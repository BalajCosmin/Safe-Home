package SafeHome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoorAccessGUI {
    private JPanel panel1;
    private JTextField AccessCodeField;
    private JButton enterCodeButton;
    private JTextField doorStat;

    Door door = new Door(DoorStatus.CLOSE);


    public DoorAccessGUI() {


        DoorLockController controler = new DoorLockController(door);

        enterCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String value=AccessCodeField.getText().trim();


        

                try {
                    controler.addTenant("1234", "tenant1");
                } catch (TenantAlreadyExistsException exception) {
                    exception.printStackTrace();
                }
                try {
                    controler.addTenant("1235", "tenant2");
                } catch (TenantAlreadyExistsException exception) {
                    exception.printStackTrace();
                }
                try {
                    controler.addTenant("1634", "tenant3");
                } catch (TenantAlreadyExistsException exception) {
                    exception.printStackTrace();
                }
                
                try {
                    controler.enterPin("1235");
                } catch (InvalidPinException invalidPinException) {
                    invalidPinException.printStackTrace();
                } catch (TooManyAttemptsException tooManyAttemptsException) {
                    tooManyAttemptsException.printStackTrace();
                }
                System.out.println(door.getStatus());


                doorStat.setText(door.getStatus().toString());








            }
        });

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("DoorAccessGUI");
        frame.setContentPane(new DoorAccessGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
