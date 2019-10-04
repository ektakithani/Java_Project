import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DbHandler extends JFrame               {
public void addStudent(String Name,String Rollno,String Marks)          {
Connection con=null;
int Rno = Integer.parseInt(Rollno);
int Markss = Integer.parseInt(Marks);
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Conected");

String s1 = "Insert into student values(?,?,?)";
PreparedStatement p1 = con.prepareStatement(s1);
p1.setInt(1,Rno);
p1.setString(2,Name);
p1.setInt(3,Markss);
System.out.println(Name);
int r1 = p1.executeUpdate();
System.out.println(r1);
if (r1>0){
new Music().playSuccess();
JOptionPane.showMessageDialog(new JDialog(),"Enrolled Successfully");
}}
catch(Exception e){
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Student already exists");
System.out.println("Issues :"+ e);
}
finally{
try{
if(con !=null){
con.close();
}
}
catch(Exception e){
System.out.println("Closing Issues :"+ e);
}
}
}// end of add

public String viewStudent (){
Connection con = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Connected :)");

Statement stmt = con.createStatement();
String sql ="Select * from student";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
int rno=rs.getInt(1);
String name = rs.getString (2);
int marks=rs.getInt(3);
sb.append("Roll No :  "+ rno + "  Name :  "+ name + "  Marks :  "+ marks + "\n");
}
rs.close();
stmt.close();
}
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
con.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();
}// end of view


public boolean updateStudent(int rn, String nn ,int mm){
boolean c=false;

int res=JOptionPane.showConfirmDialog(new JDialog(),"Do you really want to update details?");
if(res==JOptionPane.YES_OPTION){
//int rno=Integer.parseInt(Rollno);
//int marks=Integer.parseInt(NewMarks);
System.out.println(rn);
System.out.println(nn);

System.out.println(mm);

Connection con=null;
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Conected");

String sql="Update student set name=?,marks=? where rno=?";
System.out.println("up");
PreparedStatement pst = con.prepareStatement(sql);
pst.setString(1,nn);
pst.setInt(2,mm);
pst.setInt(3,rn);

System.out.println("up");
int roww=pst.executeUpdate();
System.out.println(roww);
if(roww>0){
c=true;
new Music().playSuccess();
JOptionPane.showMessageDialog(new JDialog(),"Student Details Updated Successfully :)");
}
}
catch(Exception e){
System.out.println("Issues " + e);
}
finally{
try{
if(con != null)
{
con.close();
}
}
catch(Exception e){
System.out.println("Issues " + e);
}


}
}
else{
c=false;
//JOptionPane.showMessagedialog(new JDialog(),"Student doesnot updated");
dispose();
}

return c;

} // endof update



public boolean confirmDelete(String rolno){
Connection con=null;
boolean b = false;
int rollno=Integer.parseInt(rolno);

//System.out.println(rolno);
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Conected");

int result = JOptionPane.showConfirmDialog(new JDialog(),"Do you Really want to Delete the Student");
if(result==JOptionPane.YES_OPTION){
String sql ="Delete from student where rno=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rollno);
int row = pst.executeUpdate();
System.out.println(row);
if(row>0){
new Music().playSuccess();
b=true;
//JOptionPane.showMessageDialog(new JDialog(),"Student Record Deleted");
}
else{
b=false;
JOptionPane.showMessageDialog(new JDialog(),"Student doesnot exists");
}
}


}// end f try
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
con.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
return b;
}
}// end of condelete



}