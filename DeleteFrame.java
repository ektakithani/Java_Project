import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class DeleteFrame extends JFrame{
JLabel lbRollno;
JTextField txtRollno;
JButton btnRemove,btnBack;
Container c10;
int r=0;

DeleteFrame(){
c10=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);

setLocation(750,180);
setSize(300,300);
c10.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Remove Student");
lbRollno=new JLabel("Student's Rollno : ");
txtRollno=new JTextField(15);
btnRemove=new JButton(" Delete ");
btnBack=new JButton("Back");
btnRemove.setBackground(brown);
btnBack.setBackground(brown);
c10.add(lbRollno);
c10.add(txtRollno);
c10.add(btnRemove);
c10.add(btnBack);
setVisible(true);

ActionListener ap=(ae)->{
boolean v=true;
try{
r=Integer.parseInt(txtRollno.getText());
}
catch(Exception e){
v=false;
}
if(v){
if(r<=0){
JOptionPane.showMessageDialog(new JDialog(),"Invalid rollno");
txtRollno.setText("");
txtRollno.requestFocus();
}
else{
boolean ans=new DbHandler().confirmDelete(txtRollno.getText());
if(ans){
new Music().playSuccess();

JOptionPane.showMessageDialog(c10,"Student Record Deleted");
txtRollno.setText("");
//new Music().playMusic();
}
else{
new Music().playFailure();
//JOptionPane.showMessageDialog(c10,"Student Doesnot Deleted");
txtRollno.setText("");
txtRollno.requestFocus();
}
}}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Enter valid rolllno");
txtRollno.setText("");
txtRollno.requestFocus();
}
};
btnRemove.addActionListener(ap);


ActionListener aq = (ae)->{
dispose();
};
btnBack.addActionListener(aq);
}}