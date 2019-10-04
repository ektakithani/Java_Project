import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class AdminPage extends JFrame{
JMenu Home,ViewDetails,Logout;
JMenuBar bar;
JMenuItem home,clerkdetails,logout,clerkdelete;
Container c2;
AdminPage(){
Color peach = new Color(210,180,140);
c2=getContentPane();
getContentPane().setBackground(peach);
setLocation(750,180);
setSize(300,400);
setTitle("Admin Page");
c2.setLayout(new FlowLayout(FlowLayout.LEFT));
home=new JMenuItem("Home");
clerkdetails=new JMenuItem("Clerk Details");
logout=new JMenuItem("Logout");
clerkdelete=new JMenuItem("Delete Clerk");
bar =new JMenuBar();
Home=new JMenu("Home");
ViewDetails=new JMenu("View Details");
Logout=new JMenu("Logout");
Home.add(home);
ViewDetails.add(clerkdelete);
ViewDetails.add(clerkdetails);
Logout.add(logout);
bar.add(Home);
bar.add(ViewDetails);
bar.add(Logout);
c2.add(bar);
ActionListener ak = (ae)->{
Welcome w = new Welcome();
};
home.addActionListener(ak);

ActionListener al = (ae)->{
int re = JOptionPane.showConfirmDialog(new JDialog(),"Are you sure you want to logout?");
if(re==JOptionPane.YES_OPTION){
P1 p2 = new P1();
dispose();
}};
logout.addActionListener(al);

ActionListener am =(ae)->{
ViewFrameAdmin va = new ViewFrameAdmin();
};
clerkdetails.addActionListener(am);

ActionListener ax =(ae)->{
DeleteClerk dc = new DeleteClerk();
};
clerkdelete.addActionListener(ax);

setVisible(true);
}
class Welcome{
JLabel lb;
Welcome(){
lb=new JLabel("Welcome  Admin  ");
lb.setFont(new Font("Serif", Font.BOLD, 35));
c2.add(lb);
setVisible(true);
}}

}