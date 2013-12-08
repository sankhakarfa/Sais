package sais;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import java.awt.event.ItemEvent;
 


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
 
 


import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
 


import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
 
 
 
 
public class SignUp extends JFrame implements  ItemListener
{
 
       
        String fname,lname,USN=null,sem,EMAIL,answerip,id,ques,choice,pswd;
               
        char[] p;
       
       
               
                                // JDBC Connection
                        Connection Con=null;
                        String Url="jdbc:mysql://192.168.2.100:3306/"; //change the url
                        String dbname="student";
                        String drivername="com.mysql.jdbc.Driver";
                        String user="saisadmin";
                        String pass="system";
                        // Jframe starts from here
            SignUp(){
                                
                        	
                        final JFrame jf=new JFrame();
                        jf.setLayout(new FlowLayout());
                        jf.setSize(750,750);
                        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                        final Container pane=getContentPane();
        	   		 	pane.setLayout(new GridBagLayout());
        	   		    final GridBagConstraints c = new GridBagConstraints();
                       
                        jf.setLayout(new FlowLayout());
                        JLabel jl1 =new JLabel("SIGN UP");
                        
                        c.gridx=1;
                        c.gridy=1;
                        c.gridwidth=3;
                        c.fill=GridBagConstraints.CENTER;
                        c.insets = new Insets(10,10,4,4);
                        pane.add(jl1,c);
                       
                        c.gridwidth=1;
                        c.fill=GridBagConstraints.HORIZONTAL;
                        
                        JLabel jl2 = new JLabel("First Name");
                        c.gridx=1;
                        c.gridy=2;
                        pane.add(jl2,c);
                        
                        final JTextField firstName = new JTextField(15);
                        c.gridx=2;
                        c.gridy=2;
                        pane.add(firstName,c);
                       // fname= firstName.getText();  // fname string
                       
                        JLabel jl3 = new JLabel("Last Name");
                        c.gridx=1;
                        c.gridy=3;
                        pane.add(jl3,c);
                        final JTextField lastName = new JTextField(15);
                        c.gridx=2;
                        c.gridy=3;
                        pane.add(lastName,c);
                        //lname= lastName.getText();    //lname string
                       
                        JLabel jl4 = new JLabel("USN");
                        c.gridx=1;
                        c.gridy=4;
                        pane.add(jl4,c);
                        final JTextField usn = new JTextField(10);
                        c.gridx=2;
                        c.gridy=4;
                        pane.add(usn,c);
                        //USN= usn.getText();
                       
                       
                        JLabel jl5 = new JLabel("Class :");
                        c.gridx=1;
                        c.gridy=5;
                        pane.add(jl5,c);
                //Container className=getContentPane();
                      //  className.setLayout(new FlowLayout());
                final JComboBox jc=new JComboBox();
                        jc.addItem("5A" );
                        jc.addItem("5B");
                        jc.addItem("5C");
                        jc.addItemListener(this);
                        //className.add(jc);
                         //public void itemStateChanged(ItemEvent ie){
                               
                         //}
                        c.gridx=2;
                        c.gridy=5;
                        pane.add(jc,c);
                        //sem=jc.getSelectedItem().toString();
                       
                        JLabel jl6 = new JLabel("Contact Details:");
                        c.gridx=1;
                        c.gridy=6;
                        pane.add(jl6,c);
                        
                        
                        final JTextField email= new JTextField(10);
                        c.gridx=2;
                        c.gridy=6;
                        pane.add(email,c);
                        //EMAIL= email.getText();       //email string
                       
                        JLabel jl7 = new JLabel ("Password");
                        c.gridx=1;
                        c.gridy=7;
                        pane.add(jl7,c);
                        
                        final JPasswordField password = new JPasswordField(10);
                        c.gridx=2;
                        c.gridy=7;
                        pane.add(password,c);
                        //p =password.getPassword(); //password p
                       
                       
                       
                        JLabel jl8 = new JLabel ("Confirm Password");
                        c.gridx=1;
                        c.gridy=8;
                        pane.add(jl8,c);
                        final JPasswordField rePassword = new JPasswordField(10);
                        c.gridx=2;
                        c.gridy=8;
                        pane.add(rePassword,c);
                        char[] rep = rePassword.getPassword();
                       
               
                       
                /*if(p.equals(rep)){
                               J
                               
                        }
                else
                        JLabel jll12 =new JLabel("Passwords  match");
                jf.add(jll12);*/
                       
                 
                       
                        JLabel jl9 = new JLabel ("Security Question");
                        c.gridx=1;
                        c.gridy=9;
                        pane.add(jl9,c);
                        jf.add(pane);
                       
                       // Container question=getContentPane();
                               // question.setLayout(new FlowLayout());
                                final JComboBox sq=new JComboBox();
                                sq.addItem("Name of  your first pet ??" );
                                sq.addItem("Favourite cuisine");
                                sq.addItem("What is your birthplace ??");
                                sq.addItemListener(this);
                               // question.add(sq);
                                c.gridx=2;
                        pane.add(sq,c);
                        //ques=jf.getSelectedItem().toString();
                       
                        JLabel jl10 = new JLabel ("Answer");
                        c.gridx=1;
                        c.gridy=10;
                        pane.add(jl10,c);
                        final JTextField answer = new JTextField(10);
                        c.gridx=2;
                        c.gridy=10;
                        pane.add(answer,c);
                        //answerip= answer.getText();
                       
                       
                        //String s = USN.substring(7);
                        //JLabel jl101 = new JLabel (s);
                        //jf.add(jl101);
                       
                        jf.setVisible(true);
                               
                        JButton submit = new JButton("Submit");
                        c.gridx=2;
                        c.gridy=11;
                        pane.add(submit,c);
                        
                        
                        submit.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent ae){
                               
                                       
                                       
                                       
                                        if(Arrays.equals(password.getPassword(), rePassword.getPassword())) // All functions over here
                                     {
                                                                                 
                                               
                                     
                                               
                                        //fetching fields
                                                String alert="registered";
                                                fname= firstName.getText();
                                                lname= lastName.getText();
                                                USN= usn.getText();
                                                p =password.getPassword();
                                                pswd= new String(p);
                                                sem=jc.getSelectedItem().toString();
                                                answerip= answer.getText();
                                                ques=sq.getSelectedItem().toString();
                                                EMAIL= email.getText();
                                                //String usncheck;
                                                int count = 0, flag=1;
                                               
                                                //JOptionPane.showMessageDialog(null, USN);      
                                                if(ques.equals("Name of  your first pet ??"))
                                                {
                                                        choice="1";
                               
                                                }
                                                else if(ques.equals("Favourite cuisine"))
                                                {
                                                        choice="2";
                               
                                                }
                                                else{
                                                        choice="3";
                                                }
                                                 
                                               
                                                 
                                               
                                                try{
                                                                Class.forName(drivername).newInstance();
                                                                Con=DriverManager.getConnection(Url+dbname,user,pass);
                                                        //String qry="SELECT * FROM ttb";
                                                               
                                                                Statement st= Con.createStatement();
                                                                String sq1= "select count(*) from studentdetails where usn='"+USN.toUpperCase()+"'";
                                                                       
                                                                        ResultSet rs=st.executeQuery(sq1);
                                                                       
                                                                       
                                                               
                                                              while(rs.next()){
                                                                                count=rs.getInt(1);
                                                                        }
                                                              if(count>0)
                                                              {  alert="Duplicate Value"; flag=0; }
                                                              else if(USN.equals(""))
                                                              {
                                                                  alert="Enter all fields"; flag=0;         //only works if usn is not filled
                                                              }
                                                              else{
                                                                  id = sem+USN.charAt(7)+USN.charAt(8)+USN.charAt(9);
                                                              String sq = "INSERT INTO STUDENTDETAILS " +"VALUES ('"+id+"','"+fname+"','"+lname+"','"+USN.toUpperCase()+"','"+sem+"','"+EMAIL+"','"+pswd+"',"+choice+",'"+answerip+"')";
                                                              st.executeUpdate(sq);
                                                              flag=1;
                                                              }
                                                               
                                                              /*String qry="select * from studentdetails";
                                                                ResultSet rset=st.executeQuery(qry);
                                                                while(rset.next()){
                                                                        System.out.println(rset.getString(1)+" "+rset.getString(2)+" "+rset.getString(3)+" "+rset.getString(4)+" "+rset.getString(5)+" "+rset.getString(6)+" "+rset.getString(7)+" "+rset.getString(8));
                                                                        System.out.println(" "+rset.getString(9));
                                                                }*/
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
                                                 
                                                 
                                                 
                                                 
                                                 
                                                 
                                                 JOptionPane.showMessageDialog(null, alert);
                                                 if(flag==1)
                                                         {
                                                         Login secondApplet=new Login();
                                             
                                             jf.dispose();
                                                         //jf.setVisible(false);
                                             }
                                                 
                                     }
                                     else{
                                        JOptionPane.showMessageDialog(null, "Password Mismatch" );
                                       
                                     }
                                       
                                }
                             
                                });

                        JButton clickback = new JButton("Back");
                        c.gridx=3;
                        c.gridy=15;
                        pane.add(clickback,c);
                        
                        jf.add(pane);		//adding pane
                        
                        clickback.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae){
                         	   
                            	Login call =new Login();
                         	   	
                            	jf.dispose();
                         	
                            }
             	       });
               
        }
                public static void main(String args[]){
                        new SignUp();
                }
                                @Override
                                public void itemStateChanged(ItemEvent arg0) {
                                        // TODO Auto-generated method stub
                                       
                                }
}