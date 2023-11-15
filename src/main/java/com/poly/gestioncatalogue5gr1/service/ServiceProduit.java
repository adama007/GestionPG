package com.poly.gestioncatalogue5gr1.service;

import com.poly.gestioncatalogue5gr1.dao.ProduitRepository;
import com.poly.gestioncatalogue5gr1.entities.Produit;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit {

    private ProduitRepository produitRepository;

    @Override
    public void saveProduct(Produit p) {
        produitRepository.save(p);
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public Page<Produit> getProductsByMC(String mc, Pageable p) {
        return produitRepository.findByNomContains(mc, p);
    }

    @Override
    public List<Produit> getProductsBCat(Long idCat) {
        return produitRepository.getProductsByCat(idCat);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduct(Long id) {
        return produitRepository.findById(id).orElse(null);
    }
}