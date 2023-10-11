package com.poly.gestioncatalogue5gr1.dao;

import com.poly.gestioncatalogue5gr1.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
