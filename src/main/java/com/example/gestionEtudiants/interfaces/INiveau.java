package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MNiveau;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface INiveau {
    MNiveau IaddNiveau (Connection cnx,MNiveau niveau) throws SQLException;
    MNiveau IdeleteNiveau (Connection cnx,MNiveau niveau) throws SQLException;
    List<MNiveau> IgetAllNiveau (Connection cnx)throws SQLException;


}
