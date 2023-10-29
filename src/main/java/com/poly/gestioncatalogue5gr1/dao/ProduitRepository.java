package com.poly.gestioncatalogue5gr1.dao;

import com.poly.gestioncatalogue5gr1.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    public List<Produit> findByNomContains(String mc);
    @Query("select p from Produit p where p.categorie.id=:x")
    public List<Produit> getProductsByCat(@Param("x") Long idC);
}
