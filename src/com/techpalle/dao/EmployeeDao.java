package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Employee;

public class EmployeeDao 
{
	    private static final String dburl="jdbc:mysql://localhost:3306/project";
		private static final String dbusername="root";
		private static final String  dbpassword="admin";
		
		private static Connection con=null;
		private static Statement st=null;
		private static PreparedStatement ps=null;
		private static ResultSet rs=null;
		
		private static final String employeeListQuery="select * from employee";
		private static final String employeeInsert="insert into employee (ename,egender,edob,edesignation) values (?,?,?,?)";
		//first we want to fetch data based on id after tat edit
		private static final String employeeEditQuery="select * from employee where eid=?";
		private static final String employeeUpdateQuery="update employee set ename=?,egender=?,edob=?,edesignation=? where eid=?";
		private static final String employeeDeleteQuery="delete from employee where eid=?";
		
		public static void deleteEmployee(int eid)
		{
			try 
			{
				con=getConnectionDef();
				
				ps=con.prepareStatement(employeeDeleteQuery);
				ps.setInt(1, eid);
				
				ps.executeUpdate();
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					
					if(ps!=null)
					{
					  ps.close();
					}
					if(con!=null)
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}

		}
		
		public static void editEmployee(Employee e1)
		{
			try 
			{
				con=getConnectionDef();
				
				ps=con.prepareStatement(employeeUpdateQuery);
				ps.setString(1, e1.getEname());
				ps.setString(2, e1.getEgender());
				ps.setString(3, e1.getEdob());
				ps.setString(4, e1.getEdesignation());
				ps.setInt(5,e1.getEid());
				
				ps.executeUpdate();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					
					if(ps!=null)
					{
					  ps.close();
					}
					if(con!=null)
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}
		}
		
		
		public static Employee getOneEmployee(int eid)
		{
			Employee e1=null;
			try 
			{
				con=getConnectionDef();
				
				ps=con.prepareStatement(employeeEditQuery);
				ps.setInt(1, eid);
				
				rs=ps.executeQuery();
				
				rs.next();
				
				int i=rs.getInt("eid");
				String n=rs.getString("ename");
				String g=rs.getString("egender");
				String d=rs.getString("edob");
				String de=rs.getString("edesignation");
				
				
				 e1=new Employee(i,n,g,d,de);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if(rs!=null)
					{
						rs.close();
					}
					if(ps!=null)
					{
					  ps.close();
					}
					if(con!=null)
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}
			return e1;
			
		}
		
		public static void addEmployee(Employee employee)
		{ 
			
			try 
			{
				con=getConnectionDef();
				
				ps=con.prepareStatement(employeeInsert);
				ps.setString(1, employee.getEname());
				ps.setString(2, employee.getEgender());
				ps.setString(3, employee.getEdob());
				ps.setString(4, employee.getEdesignation());
				
				ps.executeUpdate();
				
			} 
			catch (SQLException e) 
			{
			   e.printStackTrace();
			}
			finally
			{
				try 
				{
					
					if(ps!=null)
					{
					  ps.close();
					}
					if(con!=null)
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}
			
		}
		
		public static Connection getConnectionDef()
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			} 
			catch (ClassNotFoundException e) 
			{
			  e.printStackTrace();
			} catch (SQLException e) 
			{
			  e.printStackTrace();
			}
			return con;
		}
		//read data from db
		public static ArrayList<Employee> getAllEmployee()
		{
			ArrayList<Employee> al=new ArrayList<Employee>();
			
			try 
			{
				con=getConnectionDef();
				st=con.createStatement();
				
				rs=st.executeQuery(employeeListQuery);
				
				while(rs.next())
				{
					int i=rs.getInt("eid");
					String n=rs.getString("ename");
					String g=rs.getString("egender");
					String d=rs.getString("edob");
					String de=rs.getString("edesignation");
					
					
					Employee e1=new Employee(i,n,g,d,de);
					
					al.add(e1);
					
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if(rs!=null)
					{
						rs.close();
					}
					if(st!=null)
					{
					  st.close();
					}
					if(con!=null)
					{
						con.close();
					}
				} 
				catch (SQLException e) 
				{
				   e.printStackTrace();
				}
			}
			return al;
			
		}
		

}
