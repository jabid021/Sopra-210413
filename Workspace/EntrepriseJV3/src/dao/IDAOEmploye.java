package dao;

import java.util.List;

import metier.Employe;

public interface IDAOEmploye extends IDAO<Employe,Integer> {

	public List<Employe> findByIdDepartement(Integer id);
	
}
