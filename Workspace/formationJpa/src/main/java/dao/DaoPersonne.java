package dao;

import java.util.List;

import entity.Client;
import entity.Fournisseur;
import entity.Personne;

public interface DaoPersonne extends DaoGeneric<Personne, Integer> {
    List<Client> findAllClient();

    List<Fournisseur> findAllFournisseur();
}
