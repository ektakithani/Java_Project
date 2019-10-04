import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddFrame extends JFrame{
JLabel lbStudentName,lbStudentRollno,lbStudentMarks;
JTextField txtStudentName,txtStudentRollno,txtStudentMarks;
JButton btnEnroll,btnBack;
Container c8;
boolean ap=true;
AddFrame(){
c8=getContentPane();
Color peach = new Color(210,180,140);
Color brown = new Color(222,184,135);

getContentPane().setBackground(peach);

setLocation(750,180);
setSize(300,300);
c8.setLayout(new FlowLayout(FlowLayout.LEFT));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("New Student");
lbStudentName=new JLabel("Full Name : ");
lbStudentRollno=new JLabel("Roll No :      ");
lbStudentMarks=new JLabel("Marks  :        ");
txtStudentName=new JTextField(15);
txtStudentRollno=new JTextField(15);
txtStudentMarks=new JTextField(15);
btnEnroll=new JButton("Enroll New Student");
btnBack=new JButton("Back");

btnEnroll.setBackground(brown);
btnBack.setBackground(brown);

c8.add(lbStudentName);
c8.add(txtStudentName);
c8.add(lbStudentRollno);
c8.add(txtStudentRollno);
c8.add(lbStudentMarks);
c8.add(txtStudentMarks);
c8.add(btnEnroll);
c8.add(btnBack);

ActionListener ab = (ae)->{
int mm=0;
boolean checknam=true;
boolean checknum=true;
int rr=0;
String Name=txtStudentName.getText();
String Rollno = txtStudentRollno.getText();
String Marks = txtStudentMarks.getText();
if(Name.equals("") || Rollno.equals("") || Marks.equals(""))  {//s1
JOptionPane.showMessageDialog(new JDialog(),"Fill all the Details");
    }//e1
else


{//s2
System.out.println("andar");
if((Name.matches("[a-zA-Z]+")) &&  ((Name.length())>1)){//s3
System.out.println("sahi name");
try{
mm=Integer.parseInt(Marks);
 rr=Integer.parseInt(Rollno);
}
catch(Exception e){
new Music().playFailure();
checknum=false;
JOptionPane.showMessageDialog(c8,"Marks and rollno should be Integers only");
}
}//e3
else{//s4
new Music().playFailure();
checknam=false;
JOptionPane.showMessageDialog(new JDialog(),"Inavlid name");
txtStudentName.setText("");
txtStudentName.requestFocus();
}//e4
if(checknum && checknam){//s5
 if ((mm<0 || mm>100) ||(rr<=0)){//s6
new Music().playFailure();
JOptionPane.showMessageDialog(c8,"Invalid Marks or Invalid Rollno");
if(mm<0 || mm>100){
txtStudentMarks.setText("");
txtStudentMarks.requestFocus();
}
else if(rr<=0){
txtStudentRollno.setText("");
txtStudentRollno.requestFocus();
}

}//e6
else{//s7
new DbHandler().addStudent(Name,Rollno,Marks);
txtStudentName.setText("");
txtStudentRollno.setText("");
txtStudentMarks.setText("");
}//e7
}
}//e2
};
btnEnroll.addActionListener(ab);

ActionListener ac=(ae)->{
dispose();
};
btnBack.addActionListener(ac);

setVisible(true);
}
}