package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MProfesseur {

    private int idProf;
    private String codeProf;
    private String nomProf;
    private String prenomProf;
    private String matriculeProf;
    private String contactProf;
    private String dateNaissanceProf;
    private String email;
    private String sexeProf;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;
}
