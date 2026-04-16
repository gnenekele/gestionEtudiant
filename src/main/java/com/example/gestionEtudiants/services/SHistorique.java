package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IHistorique;
import com.example.gestionEtudiants.modeles.MEvaluation;
import com.example.gestionEtudiants.modeles.MHistorique;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IHistorique")

public class SHistorique implements IHistorique {

    @Override
    public MHistorique IaadHistorique(Connection cnx, MHistorique historique) throws SQLException {
        MHistorique historique1 = new MHistorique();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IaadHistorique");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.addHistoire(?,?,?,?,?)");
            callableStatement.setInt("p_idEvaluation",historique.getIdEvaluation());
            callableStatement.setInt("p_idEnseigner",historique.getIdEnseigner());
            callableStatement.setInt("p_idEtudiant",historique.getIdEtudiant());
            callableStatement.setInt("p_idClasse",historique.getIdClasse());
            callableStatement.setString("p_createdBy",historique.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                historique1.setIdhistorique(resultSet.getInt("idhistorique"));
                historique1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                historique1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                historique1.setIdClasse(resultSet.getInt("idClasse"));
                historique1.setIsdelete(resultSet.getBoolean("isdelete"));
                historique1.setCreatedBy(resultSet.getString("createdBy"));
                historique1.setCreatedOn(resultSet.getDate("createdOn"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();

        } finally{
            cnx.close();
        }
        System.out.println("fin IaadHistorique");
        return historique1;
    }

    @Override
    public MHistorique IGetAllHistByMatEtud(Connection cnx, MHistorique historique) throws SQLException {
        return null;
    }


//    @Override
//    public MHistorique IGetAllHistByMatEtud(Connection cnx, MHistorique historique) throws SQLException {
//        ResultSet resultSet = null ;
//        CallableStatement callableStatement;
//        MHistorique historique1 = new MHistorique();
//
//        System.out.println("debut IGetAllHistByMatEtud");
//
//        try {
//            callableStatement = cnx.prepareCall("call gestionetudiants.getAllHistByMatEtud(?)");
//            callableStatement.setString("p_matriculeEtudiant", historique.getMatriculeEtudiant());
//            callableStatement.executeUpdate();
//            resultSet = callableStatement.getResultSet();
//
//                while (resultSet.next()) {
//
//                    MHistorique historiqueResult = new MHistorique();
//                    historique1.setIdhistorique(resultSet.getInt("idhistorique"));
//                    historique1.setIdEvaluation(resultSet.getInt("idEvaluation"));
//                    //historique1.setTypeEvoluation(resultSet.getString("typeEvoluation"));
//                    historique1.setIdAnnee(resultSet.getInt("idAnnee"));
//                    historique1.setAnnee(resultSet.getString("annee"));
//                    historique1.setIdNiveau(resultSet.getInt("idNiveau"));
//                    historique1.setLibNiveau(resultSet.getString("libNiveau"));
//                    historique1.setIdFiliere(resultSet.getInt("idFiliere"));
//                    historique1.setLibFiliere(resultSet.getString("libFiliere"));
//                    historique1.setIdClasse(resultSet.getInt("idClasse"));
//                    //historique1.setTypeClasse(resultSet.getString("typeClasse"));
//                   // historique1.setIdPeriode(resultSet.getInt("idPeriode"));
//                    //historique1.setTypePeriode(resultSet.getString("typePeriode"));
//                   // historique1.setDateDeb(resultSet.getString("dateDeb"));
//                   // historique1.setDateFin(resultSet.getString("dateFin"));
//                    historique1.setIdMatiere(resultSet.getInt("idMatiere"));
//                    historique1.setLibMatiere(resultSet.getString("libMatiere"));
//                    historique1.setIdEvaluation(resultSet.getInt("idEvaluation"));
//                    historique1.setLibEvaluation(resultSet.getString("libEvaluation"));
//                    historique1.setDateEvaluation(resultSet.getString("dateEvaluation"));
//                    historique1.setIdEtudiant(resultSet.getInt("idEtudiant"));
//                    historique1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
//                    historique1.setNomEtudiant(resultSet.getString("nomEtudiant"));
//                    historique1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
//                    historique1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
//                   // historiqueResult.setIdNote(resultSet.getInt("idNote"));
//                   // historiqueResult.setLibNote(resultSet.getString("libNote"));
//                    historique1.setIsdelete(resultSet.getBoolean("isdelete"));
//                    historique1.setCreatedBy(resultSet.getString("createdBy"));
//                    historique1.setCreatedOn(resultSet.getDate("createdOn"));
//                    historique1.setModifiedBy(resultSet.getString("modifiedBy"));
//                    historique1.setModifiedOn(resultSet.getDate("modifiedOn"));
//                    //historiqueResult.add(historique1);
//
//                }
//            } catch(SQLException e){
//                e.printStackTrace();
//            } catch(Exception e){
//                e.printStackTrace();
//
//            } finally{
//                cnx.close();
//            }
//            System.out.println("fin IgetNoteByEtudiant");
//            return historiqueResult;
//        }


}




