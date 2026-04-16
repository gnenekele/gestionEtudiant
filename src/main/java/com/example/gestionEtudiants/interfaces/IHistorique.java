package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MHistorique;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IHistorique {
   MHistorique IaadHistorique (Connection cnx , MHistorique historique) throws SQLException;

   MHistorique  IGetAllHistByMatEtud (Connection cnx , MHistorique historique) throws SQLException;
}
