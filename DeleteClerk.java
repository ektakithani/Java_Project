 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class DeleteClerk extends JFrame{
JLabel lbUser;
JTextField txtUser;
JButton btnDel,btnBack;
Container c12;
DeleteClerk(){
c12=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);

setLocation(750,180);
setSize(300,300);
c12.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Remove Clerk");
lbUser=new JLabel("Clerk's Username : ");
txtUser=new JTextField(10);
btnDel=new JButton(" Delete ");
btnBack=new JButton("Back");
btnDel.setBackground(brown);
btnBack.setBackground(brown);
c12.add(lbUser);
c12.add(txtUser);
c12.add(btnDel);
c12.add(btnBack);

ActionListener aw=(ae)->{
int s=JOptionPane.showConfirmDialog(new JDialog(),"Are you sure,you want to delete?");
if(s==JOptionPane.YES_OPTION){
new DbHandlerAdmin().deleteClerk(txtUser.getText());
txtUser.setText("");
}};
btnDel.addActionListener(aw);

ActionListener ay=(ae)->{

txtUser.setText("");
dispose();
};
btnBack.addActionListener(ay);

setVisible(true);


}}
