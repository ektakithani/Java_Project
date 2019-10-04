import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BackgroundImageJFrame extends JFrame{
public BackgroundImageJFrame(){
setSize(820,490);
setTitle("Student Management System");
setLocationRelativeTo(null);
JLabel background = new JLabel(new ImageIcon("C:\\DEMO\\JAVA\\Student Management System\\smsp.png"));
add(background);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
setVisible(true);

}}
