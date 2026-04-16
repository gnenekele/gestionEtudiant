package com.example.gestionEtudiants.modeles;

import java.sql.Date;
import java.util.List;

public class MEleveClasse {
    private int idEtudiant;
    private String codeEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String matriculeEtudiant;
    private String contactEtudiant;
    private Date dateNaissEtudiant;
    private String emailEtudiant;
    private String contactParent;
    private String nomParent;
    private String sexeEtudiant;

    private List<MClasse> classes;
}
