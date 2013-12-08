package sais;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.*;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
 
 class Call extends JFrame implements ActionListener, ItemListener{
        /**
	 * 
	 */
	 String[] content=new String[10];
	private static final long serialVersionUID = 1L;
		JPanel jp;
        JFrame jkf;
        String fname,lname,USN,sem,email,question,answer,id,oldpswd,pswd,newpswd,ques,answerip,choice,p,EMAIL;
        Connection Con=null;
        String Url="jdbc:mysql://192.168.2.100:3306/"; //change the url
        String dbname="student";
        String drivername="com.mysql.jdbc.Driver";
        String user="saisadmin";
        String pass="system";
       
        Call(String a){
        	
        		USN=a;
                final JFrame jkf =new JFrame();
                jkf.setLayout(new FlowLayout());
                jkf.setSize(500,600);
                jkf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
       
               /////Panels
               
                JTabbedPane jtp = new JTabbedPane();
                jtp.addTab("Home", new home());
                //jtp.addTab("Time Table", new timeTable());
                //jtp.addTab("Time Table", new timeTable2());
                jtp.addTab("Holidays", new holidays());
                //jtp.addTab("Details Update", new details());
                jtp.addTab("Change Password", new change());
                jtp.addTab("Delete Account", new deleteAccount());
                jtp.addTab("Search",new search());
                
       
               
                jkf.setVisible(true);
                jkf.add(jtp);
                //// Logout bUtton
               
    		    JButton logoutb= new JButton("Log Out");
    		      		    
    		    //JLabel L = new JLabel("Hello World !");   
    		    JPanel P = new JPanel();                  // Make a JPanel;
    	    		    
    		    //pane.add(aComponent, BorderLayout.PAGE_START); 
    		    
    		     P.add(logoutb);
    		    
    		     jkf.add(P);
    		    
    		    logoutb.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
    		    		JOptionPane.showMessageDialog(null, "Log Out \n Visit Again!" );
    		    		jkf.dispose();
    				}

    		    });
                
       
       
        }
        public static void main(String args[]){
    		new Call("a");
    		
    	}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
 
 
 class change extends JApplet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			public change(){
									
				
									
					                 
					                 final Container pane=getContentPane();
					 	   		 	pane.setLayout(new GridBagLayout());
					 	   		    final GridBagConstraints c = new GridBagConstraints();
						 	   		JLabel jl1 =new JLabel("Change Password");
			                        
			                        c.gridx=1;
			                        c.gridy=1;
			                        c.gridwidth=3;
			                        c.fill=GridBagConstraints.CENTER;
			                        c.insets = new Insets(10,10,4,4);
			                        pane.add(jl1,c);
					                 
					                 
								   
								    c.gridwidth=1;
								    c.fill=GridBagConstraints.HORIZONTAL;
								    
								    JLabel jl2 = new JLabel("Old Password: ");
								    c.gridx=1;
								    c.gridy=2;
								    pane.add(jl2,c);
								    
								    final JPasswordField oldpassword = new JPasswordField(15);
								    c.gridx=2;
								    c.gridy=2;
								    pane.add(oldpassword,c);
								    
								   
								    JLabel jl3 = new JLabel("New Password:");
								    c.gridx=1;
								    c.gridy=3;
								    pane.add(jl3,c);
								    final JPasswordField newpassword = new JPasswordField(15);
								    c.gridx=2;
								    c.gridy=3;
								    pane.add(newpassword,c);
								    
								    JButton changePass =new JButton("Apply");
								    c.gridx=2;
								    c.gridy=4;
								    pane.add(changePass,c);
								    
								   changePass.addActionListener(new ActionListener(){
						                   public void actionPerformed(ActionEvent ae){
						                   	
						                   	pswd=new String(oldpassword.getPassword());
						                   	newpswd=new String(newpassword.getPassword());
						                   	if(pswd.equals("")&&newpswd.equals(""))
						                   	{
						                   		JOptionPane.showMessageDialog(null, "Enter all Fields!" );
						                   		
						                   	}
						                   	else{
						                   							                   	
						                   	
						                   	try
						                   	{
						                   		Class.forName(drivername).newInstance();
						                           Con=DriverManager.getConnection(Url+dbname,user,pass);
						                           
						                           Statement st= Con.createStatement();
						                           
						                           String sq1= "select pswd from studentdetails where usn='"+USN.toUpperCase()+"'";	
						                           String sq2= "update studentdetails set pswd='"+newpswd+"' where usn='"+USN.toUpperCase()+"'";	
						         					ResultSet rs=st.executeQuery(sq1); 
						         			         rs.next();
						         			         oldpswd=rs.getString(1);
						         			         if(pswd.equals(oldpswd)){
						         			        				         			    	 
						         			        	 st.executeUpdate(sq2);
						         			        	JOptionPane.showMessageDialog(null, "\tSucess \nPassword Changed" );
						         			         }
						         			         else{
						         			        	JOptionPane.showMessageDialog(null, "Wrong Password" );
						         			    	}
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
                                 
                                 
						                   	
						               
						                   
						                   	
						                   }	//else
								    
										 
						                
						                   } 
								   });
			}
 }
 
 
	 
class home extends JApplet{  //home page
       
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public home(){
               
               
        new JPanel(new GridLayout(4,1));
        Container tTable1=  getContentPane();
        tTable1.setLayout(new GridLayout(4,1));
        try
       	{
       		Class.forName(drivername).newInstance();
               Con=DriverManager.getConnection(Url+dbname,user,pass);
               
               Statement st= Con.createStatement();
               
               String sq1= "select * from studentdetails where usn='"+USN.toUpperCase()+"'";	
              	
					ResultSet rs=st.executeQuery(sq1); 
			         rs.next();
			        fname=rs.getString("fname");
			 		lname=rs.getString("lname");
			 		sem=rs.getString("class");
			 		email=rs.getString("email");
			 		
			         
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


       
               
        JLabel name = new JLabel("Name :"+fname+" "+lname);
        add(name);
        JLabel usn = new JLabel("USN: "+USN.toUpperCase());
        add(usn);
        JLabel sem_sec = new JLabel("Class : "+sem);
        add(sem_sec);
        JLabel bakwaas = new JLabel("Contact Details: "+email );
        add(bakwaas);
        //add(jp);
  //  jp.setVisible(true);
       
        }
}
 
 
class timeTable  extends JApplet{
       
        private static final long serialVersionUID = 1L;

		public timeTable(){
               
        
			Container table=getContentPane();
			 	table.setLayout(new GridBagLayout());
			    GridBagConstraints c = new GridBagConstraints();
                int i;
				int j;
                String columns[]={"Day","9:00-9:55","9:55-10:50","11:05-12:00","12:00-12:55","1:45-2:40","2:40-3:35","3:35-4:30"};
                String Days[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
                String data[][]={
                        {"os","java","dbs","cn","ss","ss lab","ss lab"},
                        {"java","cn","os","se","dbs","cn lab","cn lab"},
                        {"java lab","java lab","dbs","se","java","-","-"},
                        {"dbs","cn","os","se","dbs lab","dbs lab","-"},
                        {"se","ss","cn","os","-","-","-"},
                        {"-","-","-","-","-","-","-"}};
                
                //JTable table = new JTable(1,8);
                //JTableHeader table = new JTableHeader();
                //add(table);
                javax.swing.JCheckBox[] jCheckboxArray;
                jCheckboxArray = new javax.swing.JCheckBox[42];
                
                
                
                for(i=0;i<8;i++)
                { JButton column =new JButton(columns[i]);
                column.setForeground(Color.black);
                column.setBackground(Color.white);
                c.weightx = 0.2;
       
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = i+1;
                c.gridy = 0;
                
                table.add(column,c);
                }
                
                for(i=0;i<6;i++)
                { JButton row =new JButton(Days[i]);
                //if(colorday[i]=0)
                {
                row.setForeground(Color.black);
                //row.setBackground(Color.blue);
                }
                c.weightx = 0.2;
       
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = 1;
                c.gridy = i+2;
                
                table.add(row,c);
                }
                for(i=0;i<5;i++)
                {
                	for(j=0;j<7;j++)
                	{
                		jCheckboxArray[(i+1)*(j+1)] = new javax.swing.JCheckBox();
                        jCheckboxArray[(i+1)*(j+1)].setText(data[i][j]);
                        //panel.add(jCheckboxArray[(i+1)*(j+1)]);
                		 if(j<6){
                			 
                			 String str=data[i][j];
                    		 String str1=data[i][j+1];
                    		 if(str.equals(str1)==true&& str.equals("-")!=true)                		 
                    			 { 
                    			 
                    			 
                    			 c.weightx = 0.5;
                    			 c.gridwidth=2;
                                 c.fill = GridBagConstraints.CENTER;
                                 c.gridx = j+2;
                                 c.gridy = i+2;
                        		 table.add(jCheckboxArray[(i+1)*(j+1)],c);
                        		 j=j+1;
                        		 
                    			 }
                 
	                		 else{
	                		 	 
	                		 c.weightx = 0.2;  
	                		 c.gridwidth=1;
	                         c.fill = GridBagConstraints.CENTER;
	                         c.gridx = j+2;
	                         c.gridy = i+2;
	                         
	                		 table.add(jCheckboxArray[(i+1)*(j+1)],c);}
                		 }
                		 
                	
                	}
                }
							
                
               
       
               JButton bunked = new JButton("Bunked");
                c.weightx = 0.5;
                c.gridwidth=1;
                bunked.setForeground(Color.black);
                bunked.setBackground(Color.red);
                
                c.fill = GridBagConstraints.HORIZONTAL;
                
                c.anchor = GridBagConstraints.PAGE_END;
                c.gridx = 7;
                c.gridy = 10;
                table.add(bunked,c);
                bunked.addItemListener(new ItemListener(){
                    public void itemStateChanged(ItemEvent ae){
                   	
                    
       		
		       	}
		        });
 
       
       
       
               
                }
          }

       
       
class holidays extends JApplet{
       
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public holidays(){
                String [] colHeads = {"Date" , "Day", "Event"};
                Object[][] data={
                                {"16/08/2013","Friday","Varamlakshmi Vratha"},
                                {"09/09/2013","Monday","Ganesh Chaturthi"},
                                {"02/10/2013","Wednesday","Gandhi Jayanti"},
                                {"04/10/2013","Friday","Mahalaya Amavasya"},
                                {"14/10/2013","Monday","Vijaya Dashmi"},
                                {"16/10/2013","Wednesday","Eid-ul-Adha"},
                                {"18/10/2013","Friday","Maharishi Valmiki Jayanti"},
                                {"01/11/2013","Friday","Kannada Rajyotsava"},
                                {"02/11/2013","Saturday","Naraka Chaturdashi"},
                                {"04/11/2013","Monday","Balipadyami"},
                                {"14/11/2013","Thursday","Muharram"},
                                {"20/11/2013","Wednesday","Kanakadasa Jayanti"},
                };
                JTable table = new JTable(data,colHeads);
                JScrollPane jsp = new JScrollPane(table);
                add(jsp);
               
        }
}
       
 
 
class timeTable2  extends JApplet{
       
     
	private static final long serialVersionUID = 1L;

		public timeTable2(){
               
        //      str=getText();// write the query for gettin sub name from db;
               
                
                String [] colHeads = {"Day" , "hour1", "hour 2","hour 3","hour 4","hour 5","hour 6","hour 7"};
                // chaging object
                Object[][] data={
                                {"mon","se","dbs","cn","os","ss","ss lab","ss lab"},
                                {"tues","java","dbs","os","se","ss","cn lab","cn lab"},
                                {"wed","java lab","java lab","dbs","se","ss","-","-"},
                                {"thurs","se","cn","os","ss","dbs lab","dbs lab","-"},
                                {"fri","dbs","os","cn","ss","-","-","-"},
                                {"sat","-","-","-","-","-","-","-"},
                       
                };
                /*JLabel day =new JLabel("day");
                day.setForeground(Color.blue);
                day.setBackground(Color.blue);
               add(day);*/
                //object[][] data={
                
                
                //table 
                JTable table = new JTable(data,colHeads);
                add(table);
                JScrollPane jsp = new JScrollPane(table);
                add(jsp);
               
               
               /* Container cv = getContentPane();
                cv.setLayout(new FlowLayout());
               
                JButton ss =new JButton("ss");
                add(ss);
                JTextField sst=new JTextField(2);
                add(sst);
                JButton os =new JButton("os");
                add(os);
                JTextField ost=new JTextField(2);
                add(ost);
                JButton se =new JButton("se");
                add(se);
                JTextField set=new JTextField(2);
                add(set);
                JButton dbs =new JButton("dbs");
                add(dbs);
                JTextField dbst=new JTextField(2);
                add(dbst);
                JButton cn =new JButton("cn");
                add(cn);
                JTextField cnt=new JTextField(2);
                add(cnt);
                JButton java =new JButton("java");
                add(java);
                JTextField javat=new JTextField(2);
                add(javat);
                JButton sslab =new JButton("ss lab");
                add(sslab);
                JTextField sslabt=new JTextField(2);
                add(sslabt);
                JButton cnlab =new JButton("cn lab");
                add(cnlab);
                JTextField cnlabt=new JTextField(2);
                add(cnlabt);
                JButton javalab =new JButton("java lab");
                add(javalab);
                JTextField javalabt=new JTextField(2);
                add(javalabt);
                JButton dbslab =new JButton("dbs lab");
                add(dbslab);
                JTextField dbslabt=new JTextField(2);
                add(dbslabt);
               */
 
        }

       
              
}
class details extends JApplet implements ItemListener{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public details(){
					final Container pane=getContentPane();
		   		 	pane.setLayout(new GridBagLayout());
		   		    final GridBagConstraints c = new GridBagConstraints();
		           
		            
		   	
                
                 
                 JLabel jl1 =new JLabel("Update Details");
                 
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
                 
                
                 JLabel jl6 = new JLabel("E-mail:");
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
                 
                // Container question=getContentPane();
                        // question.setLayout(new FlowLayout());
                         final JComboBox sq=new JComboBox();
                         sq.addItem("Who was your first crush ??" );
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
                
               
                        
                 JButton submit = new JButton("Submit");
                 c.gridx=2;
                 c.gridy=11;
                 pane.add(submit,c);
                 
                 
                 submit.addActionListener(new ActionListener(){
                         public void actionPerformed1(ActionEvent ae){
                        
                        	
                                
                                
                                 if(Arrays.equals(password.getPassword(), rePassword.getPassword())) // All functions over here
                              {
                                                                          
                                        
                              
                                        
                                 //fetching fields
                                         String alert="registered";
                                         fname= firstName.getText();
                                         lname= lastName.getText();
                                         USN= usn.getText();                                        
                                         sem=jc.getSelectedItem().toString();
                                         answerip= answer.getText();
                                         ques=sq.getSelectedItem().toString();
                                         EMAIL= email.getText();
                                         
                                         //String usncheck;
                                         int count = 0, flag=1;
                                        
                                         //JOptionPane.showMessageDialog(null, USN);      
                                         if(ques.equals("Who was your first crush ??"))
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
                              }
                                          
                                          
                                          
                                          
                                          
                                          
                                        
                              else{
                                 JOptionPane.showMessageDialog(null, "Wrong Password");
                              }
                                
                         }

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
						}
                      
                         });

                
        
 }
		           
		         
          
   


		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
        }

		
class deleteAccount extends JApplet implements ItemListener{
    /**
 * 
 */
private static final long serialVersionUID = 1L;

	public deleteAccount(){
		
		
		final Container pane=getContentPane();
		 	pane.setLayout(new GridBagLayout());
		    final GridBagConstraints c = new GridBagConstraints();
		
		 JLabel jl7 = new JLabel ("Password");
         c.gridx=1;
         c.gridy=2;
         pane.add(jl7,c);
         
         final JPasswordField password = new JPasswordField(10);
         c.gridx=2;
         c.gridy=2;
         pane.add(password,c);
         JButton deleteaccount = new JButton("Delete Account");
         c.gridx=2;
         c.gridy=11;
         pane.add(deleteaccount,c);
         
         
         deleteaccount.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent ae){
                	 
                	 pswd=new String(password.getPassword());
                	 try{
                		 Class.forName(drivername).newInstance();
                         Con=DriverManager.getConnection(Url+dbname,user,pass);
                         
                         Statement st= Con.createStatement();
                         
                         String sq1= "select pswd from studentdetails where usn='"+USN.toUpperCase()+"'";	
                         String sq2= "delete from  studentdetails where usn='"+USN.toUpperCase()+"'";	
       					ResultSet rs=st.executeQuery(sq1); 
       			         rs.next();
       			         oldpswd=rs.getString(1);
       			         if(pswd.equals(oldpswd)){
       			        				         			    	 
       			        	 st.executeUpdate(sq2);
       			        	JOptionPane.showMessageDialog(null, "\tSucess \nAccount Deleted" );
       			        	JOptionPane.showMessageDialog(null, "\tLogging Out" );
       			        	System.exit(0);
       			         }
       			         else{
       			        	JOptionPane.showMessageDialog(null, "Wrong Password" );
       			    	}
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
                	 
                 }
                
                	
         
	
         });

				
}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class search extends JApplet{  //home page
    
    /**
 * 
 */
private static final long serialVersionUID = 1L;

String 	USN1,fname1,lname1,sem1,email1;
public search(){
           
           
	final Container pane=getContentPane();
 	pane.setLayout(new GridBagLayout());
    final GridBagConstraints c = new GridBagConstraints();
    final JTextField searchField = new JTextField(10);
    c.gridx=1;
    c.gridy=2;
    c.fill=GridBagConstraints.CENTER;	
    pane.add(searchField,c);
    final JButton getusn =new JButton("Search");
    c.gridx=2;
    
    pane.add(getusn,c);
    getusn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        	
        	USN1=searchField.getText();
    try
   	{
   		Class.forName(drivername).newInstance();
           Con=DriverManager.getConnection(Url+dbname,user,pass);
           
           Statement st= Con.createStatement();
           
           String sq1= "select * from studentdetails where usn='"+USN1.toUpperCase()+"'";	
          	
				ResultSet rs=st.executeQuery(sq1); 
		         rs.next();
		        fname1=rs.getString(2);
		 		lname1=rs.getString(3);
		 		sem1=rs.getString(5);
		 		email1=rs.getString(6);
		 		
		         
              st.close();
              JOptionPane.showMessageDialog(null, "Name \t:"+fname1+" "+lname1+"\nUSN \t: "+USN1.toUpperCase()+"\nClass \t: "+sem1+"\nContact Details \t: "+email1 );
              
             JLabel name = new JLabel("Name :"+fname1+" "+lname1);
              c.gridx=1;
              c.gridy=5;
              c.fill=GridBagConstraints.CENTER;	
              //pane.add(name,c);
              add(name);
              JLabel usn = new JLabel("USN: "+USN1.toUpperCase());
              c.gridx=2;
              c.gridy=5;
              c.fill=GridBagConstraints.CENTER;	
              //pane.add(usn,c);
              add(usn);
              JLabel sem_sec = new JLabel("Class : "+sem1);
              c.gridx=1;
              c.gridy=7;
              c.fill=GridBagConstraints.CENTER;	
              //pane.add(sem_sec,c);
              add(sem_sec);
              JLabel bakwaas = new JLabel("Contact Details: "+email1 );
              c.gridx=2;
              c.gridy=7;
              c.fill=GridBagConstraints.CENTER;	
              add(bakwaas);
              //pane.add(bakwaas,c);
              
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


   
           
    
    //add(jp);
//  jp.setVisible(true);
   
    }
    });
}
}
 }



	



	
		




		





