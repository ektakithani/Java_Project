import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HomePage extends JFrame{
JButton btnAdd,btnDelete,btnUpdate,btnLogOut,btnView,btnChangePassword;
Container c6;
JLabel  lbPersonalDetails,lbStudentDetails,lbHomeWelcome,lbBetweenSpace1,lbBetweenSpace2,
lbBetweenSpace3,lbBetweenSpace4,lbBetweenSpace5,lbBetweenSpace6;

HomePage(){
c6=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);
setTitle("Home Page");
setLocation(750,180);
c6.setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(300,400);
// lbHomeWelcome=new JLabel("Welcome " + txtUserName.getText());
lbPersonalDetails=new JLabel("-----------------------Personal Details--------------------------");
lbStudentDetails=new JLabel("------------------------Student's Details--------------------------");
lbBetweenSpace1= new JLabel("          ");
lbBetweenSpace2= new JLabel("          ");
lbBetweenSpace3= new JLabel("          ");
lbBetweenSpace4= new JLabel("          ");
lbBetweenSpace5= new JLabel("          ");
lbBetweenSpace6= new JLabel("          ");
btnLogOut=new JButton("Logout");
//btnChangePassword=new JButton(" Change   Password  ");
btnAdd=new JButton     ("  Enroll New Student  ");
btnDelete=new JButton("Delete Student Details");
btnView=new JButton   (" View Student Details ");
btnUpdate=new JButton(" Edit Student Details  ");

btnLogOut.setBackground(brown);
//btnChangePassword.setBackground(brown);
btnAdd.setBackground(brown);
btnDelete.setBackground(brown);
btnView.setBackground(brown);
btnUpdate.setBackground(brown);


// c6.add(lbHomeWelcome);
c6.add(btnLogOut);
//c6.add(lbPersonalDetails);
//c6.add(btnChangePassword);
c6.add(lbBetweenSpace2);
c6.add(lbStudentDetails);
c6.add(btnAdd);
c6.add(lbBetweenSpace3);
c6.add(btnDelete);
c6.add(lbBetweenSpace4);
c6.add(btnUpdate);
c6.add(lbBetweenSpace5);
c6.add(lbBetweenSpace6);
c6.add(btnView);
setVisible(true);

ActionListener a1= (ae)->{
int result = JOptionPane.showConfirmDialog(c6,"Are you sure , you want to Logout?");
if(result==JOptionPane.YES_OPTION){
dispose();
P1 p0 = new P1();
}
else {
//int re=JOptionPane.showConfirmDialog(new JDialog(),"Are you sure,You want to Logout?");
//if(re==JOptionPane.YES_OPTION){
HomePage hp=new HomePage();
dispose();
//}
}
};
btnLogOut.addActionListener(a1);



// btnEditProfile.addActionListener(new EditProfile());



/*ActionListener a2 = (ae)->{
System.out.println("Calling");
SecurityQuestionPage cp = new SecurityQuestionPage();
};
btnChangePassword.addActionListener(a2);
*/


ActionListener a3 =(ae)->{
AddFrame  af = new AddFrame();
};
btnAdd.addActionListener(a3);


ActionListener ao=(ae)->{
DeleteFrame df = new DeleteFrame();
};
btnDelete.addActionListener(ao);

ActionListener ah=(ae)->{
UpdateFrame uf = new UpdateFrame();
};
btnUpdate.addActionListener(ah);


ActionListener a6=(ae)->{
ViewFrame vf = new ViewFrame();
};
btnView.addActionListener(a6);


}     //end of constructor


}// end of class HomePage
