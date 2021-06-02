package eshop.dao;

import java.util.List;

public interface IDAO<T,K> {
   

    public List<T> findAll();

    public T findById(K id);

    public T insert(T object);

    public T update(T object);

    public void delete(T object);
    
    public T save(T object);
}