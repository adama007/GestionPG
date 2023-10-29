package com.poly.gestioncatalogue5gr1;

import com.poly.gestioncatalogue5gr1.dao.CategorieRepository;
import com.poly.gestioncatalogue5gr1.dao.ProduitRepository;
import com.poly.gestioncatalogue5gr1.entities.Categorie;
import com.poly.gestioncatalogue5gr1.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@AllArgsConstructor
public class GestionCatalogue5Gr1Application implements CommandLineRunner {

    // @Autowired
    private ProduitRepository produitRepository;
    // @Autowired
    private CategorieRepository categorieRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionCatalogue5Gr1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
