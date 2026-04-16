package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MClasse;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import com.example.gestionEtudiants.modeles.MInscription;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IInscription {
    MInscription IaddInscription(Connection cnx , MInscription inscription) throws SQLException;
   List<MInscription>  IgetAllInscription (Connection cnx ) throws SQLException;
    MInscription IdeleteInscription (Connection cnx , MInscription inscription) throws SQLException;
    MInfoEtudiant IInfoEtudiant(Connection cnx , MInfoEtudiant infoEtudiant) throws SQLException;
   MInscription  IgetlisteByClasse (Connection cnx ,MInscription inscription) throws SQLException;
}
