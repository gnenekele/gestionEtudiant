package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MAnneeacademique;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Repository
public interface IAnneeAcademique {
    MAnneeacademique IAadAnneeAcademique (Connection cnx , MAnneeacademique anneeacademique) throws SQLException;
   // MAnneeacademique IDeleteAnneeAcademique (Connection cnx , MAnneeacademique anneeacademique) throws SQLException;
   // MAnneeacademique IUpdateAnneeAcademique (Connection cnx,MAnneeacademique anneeacademique)throws SQLException;
   // List<MAnneeacademique> IGetAnneeAcademique (Connection cnx) throws SQLException ;
}
