package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MInscription {

    private int idInscription;
    private String inscriptionPar;
    private Date inscriptionLe;
    private int idEtudiant;
    private String codeEtudiant;
    private String nomEtudiant ;
    private String prenomEtudiant ;
    private String matriculeEtudiant;
    private String contactEtudiant ;
    private String dateNaissEtudiant ;
    private String emailEtudiant ;
    private String contactParent;
    private String nomParent ;
    private String sexeEtudiant;
    private int idAnnee;
    private String annee;
    private int idClasse;
    private String typeClasse;
    private int idFiliere;
    private  String libFiliere;
    private int idNiveau;
    private  String libNiveau;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;


}
