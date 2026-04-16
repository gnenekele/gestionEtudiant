package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MClasse {
    private int idClasse;
    private int idFiliere;
    private int idNiveau;
    private String  typeClasse;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;
}
