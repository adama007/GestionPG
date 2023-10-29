package com.poly.gestioncatalogue5gr1.service;

import com.poly.gestioncatalogue5gr1.entities.Produit;

import java.util.List;

public interface IServiceProduit {

    public void saveProduct(Produit p);
    public List<Produit> getAllProducts();
    public List<Produit> getProductsByMC(String mc);
    public List<Produit> getProductsBCat(Long idCat);
    public void deleteProduct(Long id);
    public Produit getProduct(Long id);


}
