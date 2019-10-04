import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class RegisterPage extends JFrame{
Container c5	;
JLabel lbUserName, 
lbFirstName,lbLastName,lbAddress,lbPhoneno,lbGender,lbAge,lbPassword,lbEmail,lbSecurityQuestion,lbSecurityAnswer,lbQualification,lbConfirmPassword;
JTextField txtFirstName,txtLastName,txtAddress,txtPhoneno,txtEmail,txtAge,txtUserName,txtSecurityAnswer;
JPasswordField txtPassword,txtConfirmPassword;
JButton btnRegister,btnCancel;
JRadioButton btnMale,btnFemale;
ButtonGroup bg;
String[] Qualification = { "Bachelor of Engineering", "MS in ComputerScience", "Master in Bussiness Addministers", "Masters in literature",
                         "Masters in AI", "Masters in IOT" };
final JComboBox<String> q = new JComboBox<String>(Qualification);


String[] SecurityQuestions = {"Pet’s name?","Last name of the teacher?", "Name of your school?",
"Your Favourite city?"};
final JComboBox<String> sq = new JComboBox<String>(SecurityQuestions);

RegisterPage(){
c5=getContentPane();
Color peach = new Color(210,180,140);
getContentPane().setBackground(peach);
Color brown = new Color(222,184,135);
setTitle("Registration Form");
setLocation(700,160);
c5.setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(400,480);
lbUserName=new JLabel(" User Id :                              ");
lbFirstName=new JLabel (" FirstName :                        ");
lbLastName=new JLabel (" LastName :                        ");
lbAddress=new JLabel (" Address :                           ");
lbPhoneno=new JLabel (" Contact No :                      ");
lbGender=new JLabel (" Gender :                                           ");
lbAge=new JLabel (" Age	                :                   ");
lbEmail=new JLabel (" Email :                                ");
lbQualification = new JLabel("Qualification:                      ");
lbPassword=new JLabel (" Password :                       ");
lbConfirmPassword=new JLabel ("ConfirmPassword :         ");
lbSecurityQuestion=new JLabel("Security Question :           ");
lbSecurityAnswer=new JLabel("Security Answer :           ");
btnRegister=new JButton("   Register   ");
btnCancel=new JButton("   Cancel  ");
 btnRegister.setBackground(brown);
 btnCancel.setBackground(brown);

txtUserName = new JTextField(18);
txtFirstName=new JTextField(18);
txtLastName=new JTextField(18);
txtAddress=new JTextField(18);
Dimension d = txtAddress.getPreferredSize();
d.height=d.height*3;
txtAddress.setPreferredSize(d);
txtPhoneno=new JTextField(18);
txtAge=new JTextField(18);
txtSecurityAnswer=new JTextField(18);
btnMale = new JRadioButton("Male");
btnMale = new JRadioButton("Male");
bg = new ButtonGroup();
bg.add(btnMale);
btnFemale = new JRadioButton("Female");
bg.add(btnFemale);
 btnMale.setBackground(brown);
 btnFemale.setBackground(brown);
txtEmail=new JTextField(18);
txtPassword=new JPasswordField(18);
txtConfirmPassword=new JPasswordField(18);
q.setMaximumSize(q.getPreferredSize());
q.setAlignmentX(Component.CENTER_ALIGNMENT);  
sq.setMaximumSize(sq.getPreferredSize());
sq.setAlignmentX(Component.CENTER_ALIGNMENT);  

c5.add(lbUserName);
c5.add(txtUserName);
c5.add(lbFirstName);
c5.add(txtFirstName);
c5.add(lbLastName);
c5.add(txtLastName);
c5.add(lbAddress);
c5.add(txtAddress);
c5.add(lbPhoneno);
c5.add(txtPhoneno);
c5.add(lbGender);
c5.add(btnMale);
c5.add(btnFemale);
c5.add(lbAge);
c5.add(txtAge);
c5.add(lbEmail);
c5.add(txtEmail);
c5.add(lbQualification);
c5.add(q);
c5.add(lbPassword);
c5.add(txtPassword);
c5.add(lbConfirmPassword);
c5.add(txtConfirmPassword);
c5.add(lbSecurityQuestion);
c5.add(sq);
c5.add(lbSecurityAnswer);
c5.add(txtSecurityAnswer);
c5.add(btnRegister);
c5.add(btnCancel);
setVisible(true);
btnRegister.setFocusable(true);
btnRegister.addActionListener(new AfterRegistrationActionListener());

System.out.println("called");
btnCancel.addActionListener(new AfterCancel());

}
class AfterCancel implements ActionListener{
public void actionPerformed(ActionEvent ae){
txtUserName.setText("");
txtFirstName.setText("");
txtLastName.setText("");
txtAddress.setText("");
txtPhoneno.setText("");
txtAge.setText("");
bg.clearSelection();
txtEmail.setText("");
txtPassword.setText("");
txtConfirmPassword.setText("");
txtUserName.requestFocus();
}}

class AfterRegistrationActionListener implements ActionListener{
public void actionPerformed(ActionEvent ae){
System.out.println("Reached");
System.out.println(txtUserName.getText());

boolean r=true;
boolean ag=true;
boolean em=true;
if((txtUserName.getText().equals("")) || (txtFirstName.getText().equals("")) || (txtLastName.getText().equals("")) ||(txtAddress.getText().equals("")) ||(txtPhoneno.getText().equals("")) ||(txtEmail.getText().equals("")) ||(txtAge.getText().equals(""))||(txtPassword.getText().equals("")) ||(txtConfirmPassword.getText().equals("")) || txtSecurityAnswer.getText().equals(""))
{
new Music().playFailure();
JOptionPane.showMessageDialog(c5,"Fill all the mandatory details");
}//if
else {//bigggg
try{
int ph = Integer.parseInt(txtPhoneno.getText());
}
catch(Exception e){
r=false;
}
System.out.println("value "+r);
if(r){
 if( (txtPhoneno.getText()).length() !=10){
new Music().playFailure();
JOptionPane.showMessageDialog(c5,"Incorrect PhoneNo");
txtPhoneno.requestFocus();
r=false;
}
else{
System.out.println("true");
r=true;
System.out.println(r);
}}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Invalid Phonenumber");
r=false;
txtPhoneno.requestFocus();
}
try{
int age=Integer.parseInt(txtAge.getText());
}
catch(Exception e){
ag=false;
}
if(ag){
if(Integer.parseInt(txtAge.getText())>20){
System.out.println("True");
}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Invalid age");
txtAge.requestFocus();
ag=false;
}
}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Invalid age");
}
if((txtEmail.getText().contains("@")) && (txtEmail.getText().contains(".com"))){
em=true;}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Invalid Email");
txtEmail.requestFocus();
em=false;
}
if(r!=false && ag!=false){
if(em!=false){
if((txtPassword.getText()).equals(txtConfirmPassword.getText())){
//JOptionPane.showMessageDialog(c5," Have to do Database work");
String Username=txtUserName.getText();
String Firstname=txtFirstName.getText();
String Lastname=txtLastName.getText();
String Address=txtAddress.getText();
String Phoneno=txtPhoneno.getText();
String Email=txtEmail.getText();
String AGE=txtAge.getText();
String Qualification=(String)q.getSelectedItem();
System.out.println(Qualification);
String Password=txtPassword.getText();
String Securityanswer=txtSecurityAnswer.getText();
String SecurityQ=(String)sq.getSelectedItem();
System.out.println(SecurityQ);
new DbHandlerAdmin().addClerk(Username,Firstname,Lastname,Address,Phoneno,Email,AGE,
Qualification,Password,SecurityQ,Securityanswer);

txtUserName.setText("");
txtFirstName.setText("");
txtLastName.setText("");
txtAddress.setText("");
txtPhoneno.setText("");
txtPassword.setText("");
txtConfirmPassword.setText("");
txtSecurityAnswer.setText("");
txtEmail.setText("");
txtAge.setText("");
bg.clearSelection();

}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(c5,"Password and ConfirmPassword doesn't match");
}//
}
}
}//bigg
}

}//fn

}

