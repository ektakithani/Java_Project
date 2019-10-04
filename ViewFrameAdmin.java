import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewFrameAdmin extends JFrame{
JTextArea taData ;
JButton btnBack;
Container c1;
ViewFrameAdmin(){
c1=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);

c1.setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(800,400);
taData=new JTextArea(15,30);
setTitle("Clerk's Details");
setLocation(300,180);
btnBack = new JButton("Back");
btnBack.setBackground(brown);
taData.setBackground(brown);
c1.add(taData);
c1.add(btnBack);
String ClerkData = new DbHandlerAdmin().viewClerk();
taData.setText(ClerkData);

ActionListener an = (ae)->{
dispose();
};
btnBack.addActionListener(an);
setVisible(true);

}
}