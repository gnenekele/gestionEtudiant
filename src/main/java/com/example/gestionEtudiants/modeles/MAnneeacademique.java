package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MAnneeacademique {
    private int idAnnee;
    private String annee;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;

    public void add(MAnneeacademique anneeacademiqueResult) {
    }
}
