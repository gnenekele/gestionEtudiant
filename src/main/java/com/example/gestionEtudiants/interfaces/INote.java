package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MNote;
import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface INote {
    MNote IaadNote (Connection cnx, MNote note) throws SQLException;
    MNote IUpdate (Connection cnx,MNote note) throws SQLException;
    MNote IDelete (Connection cnx,MNote note) throws SQLException;
    List<MNote> IgetAllNote (Connection cnx) throws SQLException;
    MNote IgetNoteByEtudiant (Connection cnx, MNote note) throws SQLException;
}
