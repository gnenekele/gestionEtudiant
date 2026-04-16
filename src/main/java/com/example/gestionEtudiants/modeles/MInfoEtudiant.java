package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MInfoEtudiant {
    private int idInscription;
    private int idEtudiant;
    private String codeEtudiant;
    private String matriculeEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String sexeEtudiant;
    private Date dateNaissEtudiant;
    private String contactEtudiant;
    private String emailEtudiant;
    private String contactParent;
    private String nomParent;
    private int idAnnee;
    private String annee;
    private int idClasse;
    private String typeClasse;
    private int idFiliere;
    private String libFiliere;
    private int idNiveau;
    private String libNiveau;


}
