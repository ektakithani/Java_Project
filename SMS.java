import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import sun.audio.*;
import java.io.*;


class P1 extends JFrame{
JLabel lbUserName,lbPassword,lbAccessType;
JTextField txtUserName;
JPasswordField txtPassword;
JButton btnLogin,btnRegister;
ButtonGroup bg;
JRadioButton rbAdmin,rbClerk;
Container c;


P1(){
c=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);
c.setLayout(new FlowLayout(FlowLayout.LEFT));
setTitle("Login Form");
setSize(300,200);
setLocation(750,210);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
rbAdmin=new JRadioButton("Admin");
rbClerk=new JRadioButton("Clerk");
bg=new ButtonGroup();
bg.add(rbAdmin);
bg.add(rbClerk);
lbAccessType=new JLabel("  Access Type : ");
lbUserName=new JLabel("   Username      :");
lbPassword=new JLabel("  Password       :");
txtUserName=new JTextField(15);
txtPassword = new JPasswordField(15);
btnLogin = new JButton("Login");
btnLogin.setBackground(brown);
rbAdmin.setBackground(brown);
rbClerk.setBackground(brown);

btnRegister= new JButton("New Registration");
btnRegister.setBackground(brown);
lbUserName.setBounds(100,100,30,20);
c.add(lbAccessType);
c.add(rbAdmin);
c.add(rbClerk);
c.add(lbUserName);
c.add(txtUserName);
c.add(lbPassword);
c.add(txtPassword);
c.add(btnLogin);
c.add(btnRegister);
setVisible(true);
btnLogin.addActionListener(new Login());
btnRegister.addActionListener(new Registration());
}

class Login implements ActionListener{  // c

public void actionPerformed(ActionEvent ae){
String Username = txtUserName.getText();
String Password = txtPassword.getText();
boolean Authenticate= new DbHandlerAdmin().Authentication(Username,Password);
if(Authenticate && rbClerk.isSelected()){
new Music().playSuccess();
JOptionPane.showMessageDialog(c,"Successful Login");
dispose();
JOptionPane.showMessageDialog(c,"Welcome to Student Management System.!");
HomePage h = new HomePage();//c6

}
else if(Username.equals("Admin") && Password.equals("admin123") && rbAdmin.isSelected()){
new Music().playSuccess();
JOptionPane.showMessageDialog(c,"Successful Login");
dispose();
JOptionPane.showMessageDialog(c,"Welcome to Student Management System.!");
AdminPage ap = new AdminPage();
}
else if((Username.equals("")) || (Password.equals(""))){
new Music().playFailure();
JOptionPane.showMessageDialog(c,"Please fill all the details");
}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(c,"Incorrect Credentials");
bg.clearSelection();
}

txtUserName.setText("");
txtPassword.setText("");
txtUserName.requestFocus();

}
}
class Registration implements ActionListener{//c5
public void actionPerformed(ActionEvent ae){
if(rbAdmin.isSelected()){
new Music().playFailure();
JOptionPane.showMessageDialog(c,"Admins cannot register");
}
else{
txtUserName.setText("");
txtPassword.setText("");
txtUserName.requestFocus();
RegisterPage r = new RegisterPage();
}}
}
}



class SMS{
public static void main(String...a){
BackgroundImageJFrame b = new BackgroundImageJFrame();
P1 p = new P1();
}}