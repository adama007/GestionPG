package com.poly.gestioncatalogue5gr1.service;

import java.util.List;

import com.poly.gestioncatalogue5gr1.entities.Categorie;

public interface IServiceCategorie {

    public void saveCategorie(Categorie c);
    public List<Categorie> getAllCategories();
    public void deleteCategorie(Long id);
    public Categorie getCategorie(Long i);
    
}
