package sais;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class Login  extends JFrame implements ActionListener
{      
      
	
	// JDBC Connection
	Connection Con=null;
		String Url="jdbc:mysql://192.168.2.100:3306/"; //change the url 
		String dbname="student";
		String drivername="com.mysql.jdbc.Driver";
		String user="saisadmin";
		String pass="system";
	// Jframe starts from here
		 String USN,pswd;
		 int count=0;
         //char[] p;
	Login(){
    	   
    	
   		
   		
       final JFrame jkk=new JFrame("Login");
       jkk.setLayout(new FlowLayout());
       jkk.setSize(750,750);
       jkk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       final Container pane=getContentPane();
		 	pane.setLayout(new GridBagLayout());
		    final GridBagConstraints c = new GridBagConstraints();
      
       final JTextField loginId;
       final JPasswordField password1;




      
              
              

                      
                       loginId= new JTextField(10);
                       password1= new JPasswordField(15);
                      
                       JPanel jp2 =new JPanel(new GridLayout(2,2));
                       jkk.add(jp2);
                       
                      
                       
                       JLabel jl2 = new JLabel("MSRIT SAIS");
                       c.fill=GridBagConstraints.CENTER;
                       pane.add(jl2,c);
                       jp2.add(pane);
                      
                      
                      
                      
                       JPanel jp =new JPanel();
                       jp2.add(jp);
                      
                       jp.setLayout(new GridLayout(4,2));
                      
                      
                       JLabel jl = new JLabel ("Username");
                       jp.add(jl);
                       jp.add(loginId);
                       
                      
                      
      
                       JLabel jl1 = new JLabel ("Password");
                       jp.add(jl1);
                       jp.add(password1);
                      
              


                      
                       JButton signin = new JButton("Sign In");
                       jp.add(signin);
                       signin.addActionListener(new ActionListener(){
                               public void actionPerformed(ActionEvent ae){
                                      int flag=0,value=0;
                                      
                                      pswd=new String(password1.getPassword());
                                      USN=loginId.getText();
                                      try{
                          				Class.forName(drivername).newInstance();
                          				Con=DriverManager.getConnection(Url+dbname,user,pass);
           
                          				
                          				Statement st= Con.createStatement();
                          				String sq1= "select count(*) from studentdetails where usn='"+USN.toUpperCase()+"' and pswd='"+pswd+"'";
                          					
                          					ResultSet rs=st.executeQuery(sq1); 
                          					count=count+1;
                          			      while(rs.next()){
                            						value=rs.getInt(1);
                            						
                            					}
                          			     if(USN.equals("") && pswd.equals(""))
                      			      {
                      			    	   flag=3;	 
                      			    	 JOptionPane.showMessageDialog(null, "Enter all fields" );//only works if usn is not filled
                      			      }
                          			     else if(value>0)
                          			      {   flag=1; }
                          			      
                          				st.close();
                          			}
                          			catch (MySQLIntegrityConstraintViolationException e) {
                          					
                          				//System.out.println("Duplicate Entry\n Try Again!");
                          				
                          				e.printStackTrace();
                          		    	  
                          		    }
                          			 catch (InstantiationException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IllegalAccessException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (ClassNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
                          		 
                              
                                       if(flag==3&&count<4){
                               		   JOptionPane.showMessageDialog(null, "Enter all fields" );
                               		   count=1;
                               	   }                         
                                      
                                      else if(flag==1){
                            		   JOptionPane.showMessageDialog(null, "logged in" );
                            		   Call secondApplet=new Call(USN);
                            		   jkk.dispose();
                            	   }
                            	   else if(count<4){
                            		   JOptionPane.showMessageDialog(null, "Invalid USN and Password" );
                            	   }
                            	   else
                            	   {	JOptionPane.showMessageDialog(null, "Try Forgot Password or Reopen Window" );
                            	   
                            	   }
                            		  
                                     //call thirdApplet=new call();
                                       
                                       //thirdApplet.setVisible(true);
                       }       });
                       
                                             
                      
                      
                      
                       jkk.setVisible(true);
                       JButton signup = new JButton ("Sign Up");
                       jp.add(signup);
                       signup.addActionListener(new ActionListener(){
                       public void actionPerformed(ActionEvent ae){
                               SignUp secondApplet=new SignUp();
                              
                              jkk.dispose();
                          
                             
                          
                              
                       }
              
                       });
                       
                       JButton forgot = new JButton("Forgot Password");
                       jp.add(forgot);
                       forgot.addActionListener(new ActionListener(){
                               public void actionPerformed(ActionEvent ae){
                                      
                            	   	
                                       jkk.dispose();
                                       ForgotPassword open= new ForgotPassword();
                       }       });
                      
                       JButton clickexit = new JButton("Exit");
                       jp.add(clickexit);
                       clickexit.addActionListener(new ActionListener(){
                           public void actionPerformed(ActionEvent ae){
                        	   
                        	   jkk.dispose();
                        	
                           }
            	       });
              
       }
       public static void main(String args[]){
               new Login();
       }

       @Override
       public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
              
       }}
