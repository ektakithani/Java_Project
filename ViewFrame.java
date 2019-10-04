import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewFrame extends JFrame{
JTextArea taData ;
JButton btnBack;
Container c9;
ViewFrame(){
c9=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);

c9.setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(300,400);
taData=new JTextArea(15,30);
setTitle("Student Details");
setLocation(780,180);
btnBack = new JButton("Back");

btnBack.setBackground(brown);
taData.setBackground(brown);
c9.add(taData);
c9.add(btnBack);
String Data = new DbHandler().viewStudent();
taData.setText(Data);
taData.setEditable(false);

ActionListener ag = (ae)->{
dispose();
};
btnBack.addActionListener(ag);
setVisible(true);

}
}