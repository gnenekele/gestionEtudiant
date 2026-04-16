package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IEvaluation;
import com.example.gestionEtudiants.modeles.MEvaluation;
import com.example.gestionEtudiants.modeles.MEvaluationClasse;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IEvaluation")
public class SEvaluation implements IEvaluation {
    @Override
    public MEvaluation IaadEvaluation(Connection cnx, MEvaluation evaluation) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        MEvaluation evaluation1 =new MEvaluation();
        System.out.println("debut IaadEvaluation");
        try{
            callableStatement =cnx.prepareCall("call gestionetudiants.addEvaluation(?,?,?,?,?)");
            callableStatement.setInt("p_idPeriode",evaluation.getIdPeriode());
            callableStatement.setInt("p_idMatiere",evaluation.getIdMatiere());
            callableStatement.setString("p_libEvaluation",evaluation.getLibEvaluation());
            callableStatement.setString("p_dateEvaluation",evaluation.getDateEvaluation());
            callableStatement.setString("p_createdBy",evaluation.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                evaluation1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluation1.setIdMatiere(resultSet.getInt("idMatiere"));
                evaluation1.setIdPeriode(resultSet.getInt("idPeriode"));
                evaluation1.setLibEvaluation(resultSet.getString("libEvaluation"));
                evaluation1.setDateEvaluation(resultSet.getString("dateEvaluation"));
                evaluation1.setIsdelete(resultSet.getBoolean("isdelete"));
                evaluation1.setCreatedBy(resultSet.getString("createdBy"));
                evaluation1.setCreatedOn(resultSet.getDate("createdOn"));
                evaluation1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                evaluation1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
            }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                cnx.close();
            }
        System.out.println("Fin IaadEvaluation");
            return evaluation1;
        }


    @Override
    public MEvaluation IdeleteEvaluation(Connection cnx, MEvaluation evaluation) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        MEvaluation evaluation1 =new MEvaluation();
        System.out.println("debut IaadEvaluation");
        try{
            callableStatement =cnx.prepareCall("call gestionetudiants.deleteEvaluation(?,?)");
           callableStatement.setInt("p_idEvaluation",evaluation.getIdEvaluation());
           callableStatement.setString("p_isdeletedBy",evaluation.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                evaluation1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluation1.setIdMatiere(resultSet.getInt("idMatiere"));
                evaluation1.setIdPeriode(resultSet.getInt("idPeriode"));
                evaluation1.setLibEvaluation(resultSet.getString("libEvaluation"));
                evaluation1.setDateEvaluation(resultSet.getString("dateEvaluation"));
                evaluation1.setIsdelete(resultSet.getBoolean("isdelete"));
                evaluation1.setCreatedBy(resultSet.getString("createdBy"));
                evaluation1.setCreatedOn(resultSet.getDate("createdOn"));
                evaluation1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                evaluation1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return evaluation1;
    }


    @Override
    public List<MEvaluation> IgetEvaluation(Connection cnx) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IgetEvaluation");

        List<MEvaluation> evaluationArrayList = new ArrayList<>();
        try{
        callableStatement= cnx.prepareCall("call gestionetudiants.getAllEvaluation()");
        callableStatement.executeUpdate();
        resultSet = callableStatement.getResultSet();

        while (resultSet.next()) {
            MEvaluation evaluationResult = new MEvaluation();
            evaluationResult.setIdEvaluation(resultSet.getInt("idEvaluation"));
            evaluationResult.setIdMatiere(resultSet.getInt("idMatiere"));
            evaluationResult.setIdPeriode(resultSet.getInt("idPeriode"));
            evaluationResult.setLibEvaluation(resultSet.getString("libEvaluation"));
            evaluationResult.setDateEvaluation(resultSet.getString("dateEvaluation"));
            evaluationResult.setIsdelete(resultSet.getBoolean("isdelete"));
            evaluationResult.setCreatedBy(resultSet.getString("createdBy"));
            evaluationResult.setCreatedOn(resultSet.getDate("createdOn"));
            evaluationResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
            evaluationResult.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
            evaluationArrayList.add(evaluationResult);
        }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IgetEvaluation");

        return evaluationArrayList;
}
 @Override
    public List<MEvaluation>  IgetEvaluationByMatiere(Connection cnx, MEvaluation evaluation) throws SQLException {
        ResultSet resultSet= null;
        CallableStatement callableStatement;
         List<MEvaluation> evaluationArrayList = new ArrayList<>();
        System.out.println("debut IgetEvaluationByMatiere");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getEvaluationByMatiere(?)");
            callableStatement.setString("p_libMatiere",evaluation.getLibMatiere());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()){

                MEvaluation evaluationResult = new MEvaluation();
                evaluationResult.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluationResult.setLibEvaluation(resultSet.getString("libEvaluation"));
                evaluationResult.setDateEvaluation(resultSet.getString("dateEvaluation"));
                evaluationResult.setIdMatiere(resultSet.getInt("idMatiere"));
                evaluationResult.setLibMatiere(resultSet.getString("libMatiere"));
                evaluationResult.setIdPeriode(resultSet.getInt("idPeriode"));
                evaluationResult.setTypePeriode(resultSet.getString("typePeriode"));
                evaluationResult.setDateDeb(resultSet.getString("dateDeb"));
                evaluationResult.setDateFin(resultSet.getString("dateFin"));
                evaluationResult.setIdAnnee(resultSet.getInt("idAnnee"));
                evaluationResult.setAnnee(resultSet.getString("annee"));
                evaluationResult.setCreatedBy(resultSet.getString("createdBy"));
                evaluationResult.setCreatedOn(resultSet.getDate("createdOn"));
                evaluationResult.setModifiedBy(resultSet.getString("modifiedBy"));
                evaluationResult.setModifiedOn(resultSet.getDate("modifiedOn"));
                evaluationArrayList.add(evaluationResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IgetEvaluationByMatiere");
        return evaluationArrayList;
    }
}



