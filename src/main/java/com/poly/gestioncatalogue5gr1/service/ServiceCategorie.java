package com.poly.gestioncatalogue5gr1.service;

import com.poly.gestioncatalogue5gr1.dao.CategorieRepository;
import com.poly.gestioncatalogue5gr1.entities.Categorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie {

    private final CategorieRepository categorieRepository;

    @Override
    public void saveCategorie(Categorie c) {
        categorieRepository.save(c);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }
}
