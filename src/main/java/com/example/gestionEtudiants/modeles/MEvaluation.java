package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MEvaluation {
    private int idEvaluation;
    private String libEvaluation;
    private String dateEvaluation;
    private int idPeriode;
    private int idAnnee;
    private String annee;
    private String typePeriode;
    private String dateDeb;
    private String dateFin;
    private int idMatiere;
    private String libMatiere;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;



}
