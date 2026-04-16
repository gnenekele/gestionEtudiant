package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MFiliere;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IFiliere {
    MFiliere IaddFiliere (Connection cnx,MFiliere filiere)throws SQLException;
    List<MFiliere> IGetAllFiliere (Connection cnx)throws SQLException;
}
