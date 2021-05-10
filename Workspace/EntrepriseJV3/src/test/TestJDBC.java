package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Departement;
import metier.Employe;

public class TestJDBC {

	
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public static void selectAllDepartements() 
	{
		List<Departement> depts=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("select * from dept");
			//deptno,dname,loc
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				depts.add(d);
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(depts);
	}
	
	
	public static void insertDepartement() 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO dept VALUES (90,'Formation','Paris')");
			//deptno,dname,loc
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void selectDeptByDnameLike(String dname) 
	{
		
		List<Departement> depts=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery("select * from dept where dname like '%"+dname+"%'");
			//deptno,dname,loc
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				depts.add(d);
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(depts);
	}
	
	public static void seConnecter(String nom,String job)
	{
		Employe emp=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			Statement st = conn.createStatement();
			
			
			//ResultSet rs=st.executeQuery("select * from emp where ename=\""+nom+"\" and job=\""+job+"\"");
			ResultSet rs=st.executeQuery("select * from emp where ename='"+nom+"' and job='"+job+"'");
			System.out.println("select * from emp where ename='"+nom+"' and job='"+job+"'");
			//deptno,dname,loc
			while(rs.next()) 
			{
				emp = new Employe(rs.getInt("empno"),null,null,rs.getString("ename"),rs.getString("job"),rs.getDouble("sal"),rs.getDouble("comm"), null, null, rs.getString("hiredate"));
				System.out.println(emp);
			}
			
			if(emp==null) {System.out.println("Identifiants invalides");}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	
	//VERSIONS SECURE
	
	
	
	public static void selectAllDepartementsSecure() 
	{
		List<Departement> depts=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			PreparedStatement ps = conn.prepareStatement("select * from dept");
			ResultSet rs=ps.executeQuery();
			//deptno,dname,loc
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				depts.add(d);
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(depts);
	}
	
	
	
	public static void seConnecterSecure(String nom,String job)
	{
		Employe emp=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			PreparedStatement ps = conn.prepareStatement("select * from emp where ename=? and job=?");
			ps.setString(1, nom);
			ps.setString(2, job);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				emp = new Employe(rs.getInt("empno"),null,null,rs.getString("ename"),rs.getString("job"),rs.getDouble("sal"),rs.getDouble("comm"), null, null, rs.getString("hiredate"));
				System.out.println(emp);
			}
			
			if(emp==null) {System.out.println("Identifiants invalides");}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	
	public static void selectDeptByDnameLikeSecure(String dname) 
	{
		
		List<Departement> depts=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			PreparedStatement ps = conn.prepareStatement("select * from dept where dname like ?");
			ps.setString(1,"%"+dname+"%");
			
			ResultSet rs=ps.executeQuery();
			//deptno,dname,loc
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				depts.add(d);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(depts);
	}
	
	
	
	public static void insertDepartementSecure(int deptno,String dname,String loc) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dept VALUES (?,?,?)");
			ps.setInt(1, deptno);
			ps.setString(2, dname);
			ps.setString(3, loc);
			
			ps.executeUpdate();
			
			
			//deptno,dname,loc
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// insertDepartement();
		 //selectAllDepartements();
		//selectDeptByDnameLike("ion");
		
		/*String nom=saisieString("Saisir votre nom");
		String job=saisieString("Saisir votre job");
		seConnecterSecure(nom, job);
		*/
		
		
		
		//select * from emp where ename='toto' or '1=1' and job='y'
	}

}
