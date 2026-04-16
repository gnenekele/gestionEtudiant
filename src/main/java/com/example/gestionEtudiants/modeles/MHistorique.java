package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MHistorique {

    private int idhistorique;
    private int idAnnee;
    private String annee;
    private int idNiveau;
    private String libNiveau;
    private int idFiliere;
    private String libFiliere;
    private int idClasse;
    private String typeClasse;
    private int idPeriode;
    private String typePeriode;
    private String dateDeb;
    private String dateFin;
    private int idMatiere;
    private String libMatiere;
    private int idEvaluation;
    private String libEvaluation;
    private String dateEvaluation;
    private int idEtudiant;
    private String codeEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String matriculeEtudiant;
    private int idNote;
    private String libNote;
    private int idEnseigner;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;


}
