package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IEvaluationClasse;
import com.example.gestionEtudiants.modeles.MEvaluationClasse;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IEvaluationClasse")
public class SEvaluationClasse implements IEvaluationClasse {
    @Override
    public MEvaluationClasse IaadEvaluationClasse(Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        MEvaluationClasse evaluationClasse1= new MEvaluationClasse();
        System .out.println("debut IaadEvaluationClasse");

        try {
        callableStatement = cnx.prepareCall("call gestionetudiants.addEvaluationclasse(?,?,?,?)");
        callableStatement.setInt("p_idClasse",evaluationClasse.getIdClasse());
        callableStatement.setInt("p_idEvaluation",evaluationClasse.getIdEvaluationClasse());
        callableStatement.setString("p_typeEvoluation",evaluationClasse.getTypeEvoluation());
        callableStatement.setString("p_createdBy",evaluationClasse.getCreatedBy());
        callableStatement.executeUpdate();
        resultSet = callableStatement.getResultSet();
        while (resultSet.next()){
            evaluationClasse1.setIdEvaluationClasse(resultSet.getInt("idEvaluationClasse"));
            evaluationClasse1.setIdEvaluation(resultSet.getInt("idEvaluation"));
            evaluationClasse1.setIdClasse(resultSet.getInt("idClasse"));
            evaluationClasse1.setTypeEvoluation(resultSet.getString("typeEvoluation"));
            evaluationClasse1.setCreatedBy(resultSet.getString("createdBy"));
            evaluationClasse1.setCreatedOn(resultSet.getDate("createdOn"));
        }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IaadEvaluationClasse");
        return evaluationClasse1;
    }


    @Override
    public List<MEvaluationClasse> IgetEvaluationClasse(Connection cnx) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        List<MEvaluationClasse> evaluationclasseArrayList = new ArrayList<>();
        System .out.println("debut IgetEvaluationClasse");

        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllEvaluationclasse()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()){

                MEvaluationClasse evaluationClasseResult = new MEvaluationClasse();

                evaluationClasseResult.setIdEvaluationClasse(resultSet.getInt("idEvaluationClasse"));
                evaluationClasseResult.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluationClasseResult.setIdClasse(resultSet.getInt("idClasse"));
                evaluationClasseResult.setTypeEvoluation(resultSet.getString("typeEvoluation"));
                evaluationClasseResult.setCreatedBy(resultSet.getString("createdBy"));
                evaluationClasseResult.setCreatedOn(resultSet.getDate("createdOn"));
                evaluationClasseResult.setModifiedBy(resultSet.getString("modifiedBy"));
                evaluationClasseResult.setModifiedOn(resultSet.getDate("modifiedOn"));
                evaluationclasseArrayList.add(evaluationClasseResult);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IGetAllEtudiant");
        return evaluationclasseArrayList;
    }

    @Override
    public MEvaluationClasse IgetEvaluationClasseByTypClasse(Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        MEvaluationClasse evaluationClasse1= new MEvaluationClasse();
        System .out.println("debut IgetEvaluationByClasse");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getEvaluationClasseByTypClasse(?)");
            callableStatement.setString("p_typeClasse",evaluationClasse.getTypeClasse());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                evaluationClasse1.setIdEvaluationClasse(resultSet.getInt("idEvaluationClasse"));
                evaluationClasse1.setTypeEvoluation(resultSet.getString("typeEvoluation"));
                evaluationClasse1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluationClasse1.setLibEvaluation(resultSet.getString("libEvaluation"));
                evaluationClasse1.setDateEvaluation(resultSet.getString("dateEvaluation"));
                evaluationClasse1.setIdClasse(resultSet.getInt("idClasse"));
                evaluationClasse1.setTypeClasse(resultSet.getString("typeClasse"));
                evaluationClasse1.setIdFiliere(resultSet.getInt("idFiliere"));
                evaluationClasse1.setLibFiliere(resultSet.getString("libFiliere"));
                evaluationClasse1.setIdNiveau(resultSet.getInt("idNiveau"));
                evaluationClasse1.setLibNiveau(resultSet.getString("libNiveau"));
                evaluationClasse1.setIdPeriode(resultSet.getInt("idPeriode"));
                evaluationClasse1.setTypePeriode(resultSet.getString("typePeriode"));
                evaluationClasse1.setIdMatiere(resultSet.getInt("idMatiere"));
                evaluationClasse1.setLibMatiere(resultSet.getString("libMatiere"));
                evaluationClasse1.setIdAnnee(resultSet.getInt("idAnnee"));
               // evaluationClasse1.setAnnee(resultSet.getString("annee"));

                evaluationClasse1.setCreatedBy(resultSet.getString("createdBy"));
                evaluationClasse1.setCreatedOn(resultSet.getDate("createdOn"));
                evaluationClasse1.setModifiedBy(resultSet.getString("modifiedBy"));
                evaluationClasse1.setModifiedOn(resultSet.getDate("modifiedOn"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IgetEvaluationByClasse");
        return evaluationClasse1;
    }


    @Override
    public MEvaluationClasse IdeleteEvaluationClasse(Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException {
        ResultSet resultSet= null;
        CallableStatement callableStatement;
        MEvaluationClasse evaluationClasse1 = new MEvaluationClasse();
        System .out.println("debut IdeleteEvaluationClasse");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteEvaluationclasse(?,?)");
            callableStatement.setInt("p_idEvaluationClasse",evaluationClasse.getIdEvaluationClasse());
            callableStatement.setString("p_isdeletedBy",evaluationClasse.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while  (resultSet.next()){
            evaluationClasse1.setIdEvaluationClasse(resultSet.getInt("idEvaluationClasse"));
            evaluationClasse1.setIdEvaluation(resultSet.getInt("idEvaluation"));
            evaluationClasse1.setIdClasse(resultSet.getInt("idClasse"));
            evaluationClasse1.setTypeEvoluation(resultSet.getString("typeEvoluation"));
            evaluationClasse1.setIsdelete(resultSet.getBoolean("isdelete"));
            evaluationClasse1.setCreatedBy(resultSet.getString("createdBy"));
            evaluationClasse1.setCreatedOn(resultSet.getDate("createdOn"));
            evaluationClasse1.setModifiedBy(resultSet.getString("modifiedBy"));
            evaluationClasse1.setModifiedOn(resultSet.getDate("modifiedOn"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();

    } finally {
        cnx.close();
    }
        System .out.println("fin IdeleteEvaluationClasse");
        return evaluationClasse1;
    }

    @Override
    public MEvaluationClasse IgetNoteByEtudiant(Connection cnx, MEvaluationClasse evaluationClasse) throws SQLException {
        ResultSet resultSet= null;
        CallableStatement callableStatement;
        MEvaluationClasse evaluationClasse1 = new MEvaluationClasse();
        System .out.println("debut IgetNoteByEtudiant");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.getNoteByEtudiant(?)");
            callableStatement.setString("P_codeEtudiant",evaluationClasse.getCodeEtudiant());

            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while  (resultSet.next()){

                evaluationClasse1.setIdEvaluationClasse(resultSet.getInt("idEvaluationClasse"));
                evaluationClasse1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluationClasse1.setTypeEvoluation(resultSet.getString("typeEvoluation"));
                evaluationClasse1.setIdAnnee(resultSet.getInt("idAnnee"));
                evaluationClasse1.setAnnee(resultSet.getString("annee"));
                evaluationClasse1.setIdNiveau(resultSet.getInt("idNiveau"));
                evaluationClasse1.setLibNiveau(resultSet.getString("libNiveau"));
                evaluationClasse1.setIdFiliere(resultSet.getInt("idFiliere"));
                evaluationClasse1.setLibFiliere(resultSet.getString("libFiliere"));
                evaluationClasse1.setIdClasse(resultSet.getInt("idClasse"));
                evaluationClasse1.setTypeClasse(resultSet.getString("typeClasse"));
                evaluationClasse1.setIdPeriode(resultSet.getInt("idPeriode"));
                evaluationClasse1.setTypePeriode(resultSet.getString("typePeriode"));
                evaluationClasse1.setDateDeb(resultSet.getString("dateDeb"));
                evaluationClasse1.setDateFin(resultSet.getString("dateFin"));
                evaluationClasse1.setIdMatiere(resultSet.getInt("idMatiere"));
                evaluationClasse1.setLibMatiere(resultSet.getString("libMatiere"));
                evaluationClasse1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluationClasse1.setLibEvaluation(resultSet.getString("libEvaluation"));
                evaluationClasse1.setDateEvaluation(resultSet.getString("dateEvaluation"));
                evaluationClasse1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                evaluationClasse1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                evaluationClasse1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                evaluationClasse1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                evaluationClasse1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                evaluationClasse1.setIdNote(resultSet.getInt("idNote"));
                evaluationClasse1.setLibNote(resultSet.getString("libNote"));
                evaluationClasse1.setIsdelete(resultSet.getBoolean("isdelete"));
                evaluationClasse1.setCreatedBy(resultSet.getString("createdBy"));
                evaluationClasse1.setCreatedOn(resultSet.getDate("createdOn"));
                evaluationClasse1.setModifiedBy(resultSet.getString("modifiedBy"));
                evaluationClasse1.setModifiedOn(resultSet.getDate("modifiedOn"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IgetNoteByEtudiant");
        return evaluationClasse1;
    }


}


