package com.example.gestionEtudiants.modeles;

import lombok.Data;

import java.sql.Date;

@Data
public class MEnseigner {
    private int idEnseigner;
    private String typeEnseigner;
    private int idProf;
    private int idAnnee;
    private int idClasse;
    private int idMatiere;
    private boolean isdelete;
    private String createdBy;
    private Date createdOn;
    private String modifiedBy;
    private Date modifiedOn;
    private String isdeletedBy;
    private Date isdeletedOn;
}
