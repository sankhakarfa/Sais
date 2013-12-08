package sais;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class ForgotPassword  extends JFrame  implements ActionListener{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Connection Con=null;
	String Url="jdbc:mysql://192.168.2.100:3306/"; //change the url 
	String dbname="student";
	String drivername="com.mysql.jdbc.Driver";
	String user="saisadmin";
	String pass="system";
	String USN,answer,usranswer,password;
	String[] questions={"","Name of  your first pet ??","Favourite cuisine","What is your birthplace ??"};
	int ques;
	

	public  ForgotPassword(){
             
    	       
               final JFrame jf1=new JFrame("Get_Password");
    	       jf1.setLayout(new FlowLayout());
    	       jf1.setSize(750,750);
    	       jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	       
    	       
    	       final Container pane=getContentPane();
	   		 	pane.setLayout(new GridBagLayout());
	   		    final GridBagConstraints c = new GridBagConstraints();
    	     
    	       
    	       JLabel jl1=new JLabel("USN no. ");
    	       
    	       final JTextField usncon;
    	       usncon= new JTextField(10);
    	       final JButton getusn= new JButton("Confirm");
    	       //c.insets=new Insets(4,10,2,4);
    	       
    	       JButton clickback= new JButton("Back");
    	       
    	       
    	       jf1.setVisible(true);
    	       	c.gridx=1;
    	    	c.gridy=1;
    	    	
    	       pane.add(jl1,c);
    	       
    	       	c.gridx=2;
   	    		c.gridy=1;
    	       pane.add(usncon,c);
    	       
    	       c.insets=new Insets(10,10,0,4);
    	       	c.gridx=2;
   	    		c.gridy=3;
   	    		c.fill = GridBagConstraints.VERTICAL;
    	       pane.add(getusn,c);
    	       
    	      
    	       
    	       c.insets=new Insets(20,10,0,4);
    	       
    	       c.gridx=8;
    	       c.gridy=10;
  	    		c.fill = GridBagConstraints.PAGE_END;
  	    		pane.add(clickback,c);							//exitbutton
   	       
    	       jf1.add(pane);
    	       
    	      
               clickback.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent ae){
                	   
                	   jf1.dispose();
                	   
                	   Login calllogin=new Login();
                   }
    	       });
    	       
    	       getusn.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent ae){
                   	int value=0;
                   	
                   	USN=usncon.getText();
                   	try
                   	{
                   		Class.forName(drivername).newInstance();
                           Con=DriverManager.getConnection(Url+dbname,user,pass);
                           
                           Statement st= Con.createStatement();
                           
                           String sq1= "select count(*) from studentdetails where usn='"+USN.toUpperCase()+"'";	
                           String sq2= "select question,answer,pswd from studentdetails where usn='"+USN.toUpperCase()+"'";	
         					ResultSet rs=st.executeQuery(sq1); 
         			      while(rs.next()){
           						value=rs.getInt(1);
           						
           					}
         			      if(value!=1)
         			      {
         			    	 JOptionPane.showMessageDialog(null, "Wrong Usn Try Again!" );
         			    	  
         			      }
         			      else{        			    	  
         			    	 
         			    	ResultSet rs1=st.executeQuery(sq2);
         			    		rs1.next();
	                          ques=rs1.getInt(1);
	                          answer=rs1.getString(2);
	                          password=rs1.getString(3);
	                          st.close();
         			    	  
         			    	  JLabel jl2 = new JLabel("Answer The Following Question");
         			    	  
	                          
	                          //label out the question 
	                          JLabel jl3 = new JLabel("Question: ");
	                          
	                          JLabel jl4 = new JLabel(questions[ques]);
	                          
	                          // take the answer
	                          JLabel jl5 = new JLabel ("Answer:");
	                          
	                          final JTextField answerField;
	               	       	   answerField= new JTextField(30);
	               	       	JButton getanswer= new JButton("Verify");
	               	       	
	               	       	// adding all components
	               	       	
	               	     
				               	 	c.gridx=2;
				         	    	c.gridy=4;
				         	    	c.fill = GridBagConstraints.VERTICAL;
				         	    	
				         	       pane.add(jl2,c);	
				         	       
				         	       c.fill = GridBagConstraints.HORIZONTAL;
				               	     
				         	       	c.gridx=1;
				         	    	c.gridy=5;
				         	    	
				         	       pane.add(jl3,c);	//Question Label
				         	       
				         	       	c.gridx=2;
				        	    	c.gridy=5;
				         	       pane.add(jl4,c);	//Question in USN label
				         	       
							         c.gridx=1;
						        	 c.gridy=7;
						         	 pane.add(jl5,c); //Answer Label
						         	 
						         	 c.gridx=2;
						        	 c.gridy=7;
						         	 pane.add(answerField,c); //Answer Field
				         	       
					         	       c.insets=new Insets(10,10,0,4);
					         	       c.gridx=2;
					         	       c.gridy=8;
					         	       c.fill = GridBagConstraints.VERTICAL;
				         	       pane.add(getanswer,c);  //answer button
				         	       
				         	       jf1.add(pane);
				         	      jf1.setVisible(true);
	               	      
	               	       	
	               	       	
	               	       	
	               	     getanswer.addActionListener(new ActionListener(){
	                         public void actionPerformed(ActionEvent ae){
	                        	 
	                        	 usranswer=answerField.getText();
	                        	 if(usranswer.equals(answer)){
	                        		 JOptionPane.showMessageDialog(null, "Your Password:"+password );
	                        	 }
	                        	 else{
	                        		 JOptionPane.showMessageDialog(null, "Wrong Answer");
	                        	 }
	                         
	                         }
	               	       	 
	               	     });
	               	       	   
	               	       		
	                         
         			      }
                   		
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
    	       
    	       
    	       
                   }

    	       
   
    	       });
    	       
    	       }

public static void main(String[] args){
	
	ForgotPassword call= new ForgotPassword();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	}



	       
    	       
    	      






	

