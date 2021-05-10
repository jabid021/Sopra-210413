package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Departement;
import metier.Employe;

public class DAOEmploye implements IDAO<Employe, Integer> {

	@Override
	public List<Employe> findAll() {

		List<Employe> employes=new ArrayList();
		DAODepartement daoD = new DAODepartement();

		Employe e = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from emp e LEFT JOIN emp m on e.mgr=m.empno ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Employe mgr=null;
				if(rs.getObject("e.mgr")!=null) {
					
					mgr = new Employe(rs.getInt("m.empno"),rs.getString("m.ename"),rs.getString("m.job"), rs.getDouble("m.sal"), rs.getDouble("m.comm"),
						null, null,rs.getString("m.hiredate"));
				}
				e = new Employe(rs.getInt("e.empno"),rs.getString("e.ename"),rs.getString("e.job"), rs.getDouble("e.sal"), rs.getDouble("e.comm"),
						mgr, daoD.findById(rs.getInt("e.deptno")),rs.getString("e.hiredate"));
				employes.add(e);
			}
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return employes;

	}

	@Override
	public Employe findById(Integer id) {

		DAODepartement daoD = new DAODepartement();

		Employe e = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("select * from emp e LEFT JOIN emp m on e.mgr=m.empno where e.empno=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Employe mgr=null;
				if(rs.getObject("e.mgr")!=null) {
					mgr = new Employe(rs.getInt("m.empno"),rs.getString("m.ename"),rs.getString("m.job"), rs.getDouble("m.sal"), rs.getDouble("m.comm"),
						null, null,rs.getString("m.hiredate"));
				}
				e = new Employe(rs.getInt("e.empno"),rs.getString("e.ename"),rs.getString("e.job"), rs.getDouble("e.sal"), rs.getDouble("e.comm"),
						mgr, daoD.findById(rs.getInt("e.deptno")),rs.getString("e.hiredate"));
			}
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return e;
	}

	@Override
	public Employe insert(Employe employe) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO emp ('ename','job','mgr','hiredate','sal','comm','deptno') VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, employe.getNom());
			ps.setString(2, employe.getPoste());
			ps.setInt(3, employe.getManager().getId());
			ps.setString(4, employe.getEmbauche().toString());
			ps.setDouble(5, employe.getSalaire());
			ps.setObject(6, employe.getComm());
			ps.setInt(7, employe.getDepartement().getId());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				employe.setId(rs.getInt(1));
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employe;
	}

	@Override
	public Employe update(Employe employe) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("UPDATE emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?");

			ps.setString(1, employe.getNom());
			ps.setString(2, employe.getPoste());
			ps.setInt(3, employe.getManager().getId());
			ps.setString(4, employe.getEmbauche().toString());
			ps.setDouble(5, employe.getSalaire());
			ps.setDouble(6, employe.getComm());
			ps.setInt(7, employe.getDepartement().getId());
			ps.setInt(8, employe.getId());

			ps.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employe;
	}


	@Override
	public void delete(Employe employe) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "");

			PreparedStatement ps = conn.prepareStatement("DELETE FROM emp where empno=?");

			ps.setInt(1, employe.getId());
			ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
