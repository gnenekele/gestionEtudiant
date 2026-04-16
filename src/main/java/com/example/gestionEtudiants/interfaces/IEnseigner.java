package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MEnseigner;
import com.example.gestionEtudiants.modeles.MInfoProf;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Repository
public interface IEnseigner {
    List<MInfoProf>IinfoProf (Connection  cnx, String matriculeProf)throws SQLException;
    MEnseigner IaddEnseigner (Connection  cnx ,MEnseigner enseigner )throws SQLException;
    MEnseigner IDeleteEnseigner (Connection  cnx ,MEnseigner enseigner )throws SQLException;

    MEnseigner IUpdateEnseigner(Connection cnx, MEnseigner enseigner) throws SQLException;

   // MEnseigner deleteEnseigner(Connection cnx, MEnseigner enseigner) throws SQLException;

    List<MEnseigner> IGetAllEnseigner(Connection cnx) throws SQLException;


}
