package com.poly.gestioncatalogue5gr1.dao;

import com.poly.gestioncatalogue5gr1.entities.Categorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {


    
}
