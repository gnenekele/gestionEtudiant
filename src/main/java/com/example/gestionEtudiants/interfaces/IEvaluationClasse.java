package com.example.gestionEtudiants.interfaces;

import com.example.gestionEtudiants.modeles.MEvaluationClasse;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IEvaluationClasse {

    MEvaluationClasse IaadEvaluationClasse (Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException;
    List<MEvaluationClasse> IgetEvaluationClasse (Connection cnx) throws SQLException;
    MEvaluationClasse IgetEvaluationClasseByTypClasse (Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException;

    MEvaluationClasse IdeleteEvaluationClasse (Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException;
    MEvaluationClasse IgetNoteByEtudiant (Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException;



}
