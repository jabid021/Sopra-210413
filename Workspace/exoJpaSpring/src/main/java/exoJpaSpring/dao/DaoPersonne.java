package exoJpaSpring.dao;

import java.util.List;

import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Fournisseur;
import exoJpaSpring.entity.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Integer> {
    List<Client> findAllClient();

    List<Fournisseur> findAllFournisseur();
}
