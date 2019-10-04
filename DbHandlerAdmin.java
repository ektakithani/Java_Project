import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DbHandlerAdmin extends JFrame{
public void addClerk(String Username, String Firstname,String Lastname,String Address,String Phoneno,String Email,String DOB,String Qualification, String Password,String SecurityQ,String Securityanswer){//1
System.out.println("Admin ");
Connection conn=null;
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Conected");
String s1 = "Insert into teachers values(?,?,?,?,?,?,?,?,?,?,?)";
PreparedStatement p1 = conn.prepareStatement(s1);
p1.setString(1,Username);
p1.setString(2,Firstname);
p1.setString(3,Lastname);
p1.setString(4,Address);
p1.setString(5,Phoneno);
p1.setString(6,Email);
p1.setString(7,DOB);
p1.setString(8,Qualification);
p1.setString(9,Password);
p1.setString(10,SecurityQ);
p1.setString(11,Securityanswer);

int r1 = p1.executeUpdate();
if(r1>0){
new Music().playSuccess();
JOptionPane.showMessageDialog(new JDialog(),"Registered Successfully");
}}
catch(Exception e){
System.out.println("Issues :"+ e);
}
finally{
try{
if(conn !=null){
conn.close();
}
}
catch(Exception e){
System.out.println("Closing Issues :"+ e);
}}
}

public String viewClerk(){//2
Connection conn = null;
StringBuffer sb = new StringBuffer();
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Connected :)");

Statement stmt = conn.createStatement();
String sql ="Select * from teachers";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
String username = rs.getString (1);
String firstname = rs.getString (2);
String lastname = rs.getString (3);
String address = rs.getString (4);
String phoneno = rs.getString (5);
String email = rs.getString (6);
String dob = rs.getString (7);
String qualification = rs.getString (8);
String password = rs.getString (9);
String securityquestion = rs.getString (10);
String securityanswer = rs.getString (11);

sb.append("Username :  "+ username + "  FirstName :  "+ firstname + "  LastName :  "+ lastname +   " Address : " + address + " Phone Number : " + phoneno + " Email Id : " + email +"\n"+ " Date of Birth : "+ dob + " Qualification : " + qualification + " Password : " + password + " SecurityQuestion : "+ securityquestion + " Security Answer : " + securityanswer + " \n  \n " );
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
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
}
return sb.toString();

}
public void deleteClerk(String user){
Connection con=null;
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Conected");
String sql ="Delete from teachers where username=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,user);
int row = pst.executeUpdate();
System.out.println(row);
if(row>0){
new Music().playSuccess();

JOptionPane.showMessageDialog(new JDialog(),"Clerk Record Deleted");
}
else{
new Music().playFailure();
JOptionPane.showMessageDialog(new JDialog(),"Clerk doesnot exists");
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
}
}// end of delete

public boolean Authentication(String username,String password){
boolean ans=false;
Connection conn = null;
try{
System.out.println("Loading..");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
System.out.println("Loaded");

System.out.println("Connecting..");
conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
System.out.println("Connected :)");

Statement stmt = conn.createStatement();
String sql ="Select * from teachers";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
String usernameAuth = rs.getString (1);
String passwordAuth = rs.getString (9);
if(username.equals(usernameAuth) && password.equals(passwordAuth)){
ans= true;
}
}
rs.close();
stmt.close();
}// end of try
catch(Exception e){
System.out.println("Issues : " + e);
}
finally{
try{
System.out.println("Closing..");
conn.close();
System.out.println("Closed");
}
catch(Exception e){
System.out.println("Issues "+ e);
}
return ans;
}//fnally
}//end of fun


}//e nd of class