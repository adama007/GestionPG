package com.poly.gestioncatalogue5gr1.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceCategorie;
import com.poly.gestioncatalogue5gr1.service.IServiceProduit;

import lombok.AllArgsConstructor;

import java.util.List; // Import correct pour List

@AllArgsConstructor
@Controller
public class ProduitControleur {

    private IServiceProduit serviceProduit;
    private IServiceCategorie serviceCategorie;

    @GetMapping("/Produits")
    public String getAllProducts(Model model, @RequestParam(name = "mc", defaultValue = "") String mc) {
        List<Produit> listt = serviceProduit.getProductsByMC(mc); // Appel de la méthode
        model.addAttribute("Produits", listt);
        return "vue";
    }

    @GetMapping("/delete/{id}")
    public String getdeleteProduct(@PathVariable("id") Long idProduit) {
        serviceProduit.deleteProduct(idProduit);
        return "redirect:/Produits";
    }
    @GetMapping("/ajoutform")
     public String ajout(Model m) {
        m.addAttribute("categories", serviceCategorie.getAllCategories());
        return "ajout";
    }

}
