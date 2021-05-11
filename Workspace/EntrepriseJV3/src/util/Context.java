package util;

import java.util.LinkedList;

import dao.IDAODepartement;
import dao.IDAOEmploye;
import dao.jdbc.DAODepartementJDBC;
import dao.jpa.DAOEmployeJPA;
import metier.Employe;

public class Context {
	
	
	private IDAODepartement daoDept = new DAODepartementJDBC();
	private IDAOEmploye daoEmp = new DAOEmployeJPA();
	private LinkedList<Employe> cantine = new LinkedList();
	
	
	private static Context _instance = null;
	
	
	
	
	private Context() {}
	
	
	
	
	public IDAODepartement getDaoDept() {
		return daoDept;
	}




	public void setDaoDept(IDAODepartement daoDept) {
		this.daoDept = daoDept;
	}




	public IDAOEmploye getDaoEmp() {
		return daoEmp;
	}




	public void setDaoEmp(IDAOEmploye daoEmp) {
		this.daoEmp = daoEmp;
	}




	public LinkedList<Employe> getCantine() {
		return cantine;
	}




	public void setCantine(LinkedList<Employe> cantine) {
		this.cantine = cantine;
	}




	public static Context getInstance() 
	{
		if(_instance==null) 
		{
			_instance = new Context();
		}
		
		return _instance;
	}
	
	
	
	
	
	
	

}
