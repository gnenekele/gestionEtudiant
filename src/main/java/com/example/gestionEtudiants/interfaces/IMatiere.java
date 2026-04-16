package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MMatiere;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IMatiere {
    MMatiere IaadMatiere (Connection cnx,MMatiere matiere)throws SQLException;
    MMatiere IdeleteMatiere (Connection cnx,MMatiere matiere)throws SQLException;
    List<MMatiere> IGetAllMatiere (Connection cnx)throws SQLException;
}
