import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class UpdateFrame extends JFrame{
JLabel lbNewName,lbNewMarks,lbRollno;
JTextField txtNewName,txtNewMarks,txtRollno;
JButton btnSave,btnCancel,btnBack;
Container c3;
UpdateFrame(){
c3=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);

c3.setLayout(new FlowLayout(FlowLayout.LEFT));
setLocation(750,180);
setSize(300,400);
setTitle("Update Student");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
lbNewName=new JLabel("New Name : ");
lbNewMarks=new JLabel("New Marks : ");
lbRollno=new JLabel("Roll no       :");
txtNewName=new JTextField(15);
txtNewMarks=new JTextField(15);
txtRollno=new JTextField(15);
btnSave=new JButton(" Save ");
btnCancel = new JButton(" Cancel ");
btnBack=new JButton(" Back ");
btnSave.setBackground(brown);
btnBack.setBackground(brown);
btnCancel.setBackground(brown);

c3.add(lbNewName);
c3.add(txtNewName);
c3.add(lbRollno);
c3.add(txtRollno);
c3.add(lbNewMarks);
c3.add(txtNewMarks);
c3.add(btnSave);
c3.add(btnCancel);
c3.add(btnBack);

ActionListener ai = (ae)->{
int newrollno=0,newmarks=0;
String Rollno=txtRollno.getText();
String NewName=txtNewName.getText();
String NewMarks=txtNewMarks.getText();
boolean checknewnam=true;
boolean cm=true;
boolean cr=true;
boolean checknewmar=true;
boolean checknewroll=true;
if(NewName.matches("[a-zA-Z]+")){//s3
System.out.println("sahi name");
try{
newmarks=Integer.parseInt(NewMarks);
}
catch(Exception e){
new Music().playFailure();
checknewmar=false;
JOptionPane.showMessageDialog(new JDialog(),"Marks should be Integers only");
txtNewMarks.setText("");
txtNewMarks.requestFocus();
}
try{
newrollno=Integer.parseInt(Rollno);
}
catch(Exception e){
new Music().playFailure();
checknewroll=false;
JOptionPane.showMessageDialog(new JDialog(),"Rollno should be Integers only");
txtRollno.setText("");
txtRollno.requestFocus();

}
}//e3
else{//s4
new Music().playFailure();
checknewnam=false;
JOptionPane.showMessageDialog(new JDialog(),"Inavlid name");
txtNewName.setText("");
txtNewName.requestFocus();
}//e4
if(checknewnam){
if(checknewmar && checknewroll){
if((newmarks<0 || newmarks>100) || (newrollno<=0)){
JOptionPane.showMessageDialog(new JDialog(),"Enter valid marks or rollno ");
if(newmarks<0 || newmarks>100){
//JOptionPane.showMessageDialog(new JDialog(),"Marks invalid");
txtNewMarks.setText("");
txtNewMarks.requestFocus();
cm=false;
}
else if(newrollno<=0){
txtRollno.setText("");
txtRollno.requestFocus();
cr=false;}
}
else{
if(cm && cr){
boolean annn=new DbHandler().updateStudent(newrollno,NewName,newmarks);
if(annn){
txtRollno.setText("");
txtNewName.setText("");
txtNewMarks.setText("");
}
else{
JOptionPane.showMessageDialog(new JDialog(),"Student doesnot exidts");
txtRollno.setText("");
txtNewName.setText("");
txtNewMarks.setText("");
txtNewName.requestFocus();
}}
}
}}
else{
new Music().playFailure();
//JOptionPane.showMessageDialog(new JDialog(),"name error");
//txtRollno.setText("");
txtNewName.setText("");
txtNewName.requestFocus();
//txtNewMarks.setText("");
}//el
};
btnSave.addActionListener(ai);


ActionListener aj=(ae)->{
txtRollno.setText("");
txtNewName.setText("");
txtNewMarks.setText("");

};
btnCancel.addActionListener(aj);

ActionListener ak=(ae)->{
dispose();
};
btnBack.addActionListener(ak);
setVisible(true);
}
}