package com.poly.gestioncatalogue5gr1.controleur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.gestioncatalogue5gr1.entities.Categorie;
import com.poly.gestioncatalogue5gr1.entities.Produit;
import com.poly.gestioncatalogue5gr1.service.IServiceCategorie;
import com.poly.gestioncatalogue5gr1.service.IServiceProduit;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List; // Import correct pour List

@AllArgsConstructor
@Controller
public class ProduitControleur {

    private IServiceProduit serviceProduit;
    private IServiceCategorie serviceCategorie;

    @GetMapping("/Produits")
    public String getAllProducts(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "mc", defaultValue = "") String mc) {
        Page<Produit> listt = serviceProduit.getProductsByMC(mc, PageRequest.of(page - 1, size));
        model.addAttribute("Produits", listt.getContent());
        model.addAttribute("pages", new int[listt.getTotalPages()]);
        model.addAttribute("current", listt.getNumber());
        model.addAttribute("mc", mc);
        return "vue";
    }

    @GetMapping("/delete/{id}")
    public String getdeleteProduct(@PathVariable("id") Long idProduit) {
        serviceProduit.deleteProduct(idProduit);
        return "redirect:/Produits";
    }

    @GetMapping("/ajoutform")
    public String ajout(Model m) {
        m.addAttribute("Produit", new Produit()); // Créez un nouvel objet Produit
        m.addAttribute("categories", serviceCategorie.getAllCategories());
        return "ajout";
    }

    @PostMapping("/submitProduit")
    public String saveProduct(@Valid Produit p, BindingResult bindingResult, Model m) {
        if (bindingResult.hasErrors()) {
            return "ajout";
        }

        serviceProduit.saveProduct(p);
        return "redirect:/Produits";

    }

    @GetMapping("/modif/{id}")
    public String modifyProductForm(Model m, @PathVariable("id") Long idProduit) {
        m.addAttribute("categories", serviceCategorie.getAllCategories());
        m.addAttribute("Produit", serviceProduit.getProduct(idProduit));
        return "modif";
    }

    @PostMapping("/modifProduct")
    public String submitModifiedProduct(@ModelAttribute Produit produit) {
        // Produit existingProduct = serviceProduit.getProduct(produit.getId());

        /*
         * if (existingProduct != null) {
         * // Mettez à jour les propriétés du produit existant avec les nouvelles
         * valeurs
         * existingProduct.setNom(produit.getNom());
         * existingProduct.setPrix(produit.getPrix());
         * existingProduct.setQuantite(produit.getQuantite());
         * existingProduct.setCategorie(produit.getCategorie());
         * }
         **/

        serviceProduit.saveProduct(produit);

        // Redirigez l'utilisateur vers une page de confirmation ou à l'endroit souhaité
        return "redirect:/Produits";
    }

}
