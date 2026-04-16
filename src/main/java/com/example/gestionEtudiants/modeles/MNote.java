package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;
@Data
public class MNote {
    private int idNote;
    private String libNote;
    private int idEvaluation;
    private String libEvaluation;
    private String dateEvaluation;
    private int idMatiere;
    private String libMatiere;
    private int idPeriode;
    private String typePeriode;
    private String dateDeb;
    private String dateFin;
    private String codeEtudiant;
    private int idEtudiant;
    private String matriculeEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String sexeEtudiant;
    private Date dateNaissEtudiant;
    //private String contactEtudiant;
   // private String emailEtudiant;
    //private String contactParent;
   // private String nomParent;
    private int idAnnee;
    private String annee;

    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;
}
