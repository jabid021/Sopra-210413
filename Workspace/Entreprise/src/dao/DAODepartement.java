package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Departement;

public class DAODepartement implements IDAO<Departement, Integer> {

	@Override
	public List<Departement> findAll() {

		List<Departement> departements=new ArrayList();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from dept");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				departements.add(d);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return departements;

	}

	@Override
	public Departement findById(Integer id) {
		Departement d = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from dept where deptno=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				d = new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public Departement insert(Departement departement) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO dept VALUES (?,?,?)");
			ps.setInt(1, departement.getId());
			ps.setString(2, departement.getNom());
			ps.setString(3, departement.getVille());

			ps.executeUpdate();


			//deptno,dname,loc

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return departement;
	}

	@Override
	public Departement update(Departement departement) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("UPDATE dept set dname=?,loc=? where deptno=?");

			ps.setString(1, departement.getNom());
			ps.setString(2, departement.getVille());
			ps.setInt(3, departement.getId());

			ps.executeUpdate();


			//deptno,dname,loc

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return departement;
	}


	@Override
	public void delete(Departement departement) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("DELETE FROM dept where deptno=?");
			
			ps.setInt(1, departement.getId());
			ps.executeUpdate();


			//deptno,dname,loc

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
