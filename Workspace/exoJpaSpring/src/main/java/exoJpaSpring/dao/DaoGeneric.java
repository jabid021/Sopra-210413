package exoJpaSpring.dao;

import java.util.List;

public interface DaoGeneric<E, K> {
    List<E> findAll();

    E findByKey(K key);

    void insert(E obj);

    E update(E obj);

    E delete(E obj);

    E deleteByKey(K key);
}
