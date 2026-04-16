package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MEtudiant;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Repository
public interface IEtudiant {

    MEtudiant IaddEtudiant(Connection cnx , MEtudiant etudiant) throws SQLException;

    List<MInfoEtudiant>  IGetAllEtudiantByCode(Connection cnx, String code) throws SQLException;

    List<MEtudiant> IGetAllEtudiant(Connection cnx) throws SQLException;
    MEtudiant IdeleteEtudiant (Connection cnx , MEtudiant etudiant) throws SQLException;
    MEtudiant IUpdateEtudiant (Connection cnx , MEtudiant etudiant) throws SQLException;

}
