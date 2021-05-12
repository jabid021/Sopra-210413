package dao;

import java.util.List;

public interface IDAO<T,K> {
	
	public T findById(int id); 
	public List<T> findAll();
	public T save(T entity);
	public void delete(T entity); 

}
