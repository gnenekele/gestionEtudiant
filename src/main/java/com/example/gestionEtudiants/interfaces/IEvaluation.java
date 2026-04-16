package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MEvaluation;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IEvaluation {
    MEvaluation IaadEvaluation (Connection cnx ,MEvaluation evaluation) throws SQLException;
    MEvaluation IdeleteEvaluation (Connection cnx,MEvaluation evaluation) throws SQLException;
    List<MEvaluation> IgetEvaluation (Connection cnx) throws SQLException;
    List<MEvaluation>  IgetEvaluationByMatiere (Connection cnx,MEvaluation evaluation) throws SQLException;



}
