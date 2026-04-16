package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MEtudiant {

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
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;

}
