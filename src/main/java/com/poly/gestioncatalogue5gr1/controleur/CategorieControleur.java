package com.poly.gestioncatalogue5gr1.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poly.gestioncatalogue5gr1.entities.Categorie;
import com.poly.gestioncatalogue5gr1.service.IServiceCategorie;

import lombok.AllArgsConstructor;

import java.util.List; // Import correct pour List

@AllArgsConstructor
@Controller
public class CategorieControleur {

    private IServiceCategorie serviceCategorie; // Renommé "serviceCategorie" avec une minuscule pour respecter les
                                                // conventions

    @GetMapping("/Categorie")
    public String getAllCategorie(Model model) {
        List<Categorie> categories = serviceCategorie.getAllCategories(); // Renommé "catt" en "categories"
        model.addAttribute("categorie", categories); // Utilisation du nom "categorie" pour correspondre au modèle
                                                     // Thymeleaf
        return "catalogue"; // Retourne "categorie" pour correspondre à la vue Thymeleaf
    }
}
