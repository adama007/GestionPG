package com.poly.gestioncatalogue5gr1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Le nom ne doit pas etre vide")
    @Size(min = 0, max = 20, message = "Le nom ne doit pas dépasser 20 caractères")
    private String nom;
    @Min(1)
    private double prix;
    @Min(0)
    private int quantite;
    @ManyToOne
    @NotNull(message = "la categorie ne doit pas etre null")
    private Categorie categorie;
}
