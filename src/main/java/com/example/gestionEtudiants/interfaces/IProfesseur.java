package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MProfesseur;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Repository
public interface IProfesseur {
     MProfesseur IaddProfesseur(Connection cnx , MProfesseur professeur) throws SQLException;
    List<MProfesseur> IGetAllProfesseur(Connection cnx) throws SQLException;
    MProfesseur IdeleteProfesseur(Connection cnx , MProfesseur professeur) throws SQLException;
    MProfesseur IupdateProfesseur(Connection cnx , MProfesseur professeur) throws SQLException;
    MProfesseur IgetProfesseurByCode(Connection cnx , MProfesseur professeur) throws SQLException;

    //List<MProfesseur> IgetProfesseurByCode(Connection cnx) throws SQLException;


}

