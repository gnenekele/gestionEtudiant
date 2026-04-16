package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.util.Date;

@Data
public class MInfoProf {
    private  int idEnseigner;
    private String typeEnseigner;
    private  int idAnnee;
    private  String annee;
    private  int idFiliere;
    private  String libFiliere;
    private  int idNiveau;
    private  String libNiveau;
    private int idClasse;
    private  String typeClasse;
    private int idMatiere;
    private  String libMatiere;
    private int idProf;
    private  String codeProf;
    private  String nomProf;
    private  String prenomProf;
    private  String matriculeProf;
    private  String contactProf;
    private  String dateNaissanceProf;
    private  String email;
    private  String sexeProf;
    private  String createdBy;
    private Date createdOn;
    private  String isdeletedBy;
    private  Date isdeletedOn;
}
