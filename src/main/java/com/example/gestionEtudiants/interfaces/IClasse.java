package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MClasse;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IClasse {
    MClasse IaddClasse(Connection cnx , MClasse classe) throws SQLException;
    List<MClasse> IGetAllClasse(Connection cnx ) throws SQLException;
    MClasse IUpdateClasse(Connection cnx,MClasse classe)throws SQLException;
    MClasse IDeleteclasse(Connection cnx , MClasse classe) throws SQLException;
}
