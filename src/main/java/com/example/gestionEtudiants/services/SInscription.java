package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IInscription;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import com.example.gestionEtudiants.modeles.MInscription;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IInscription")

public class SInscription implements IInscription {
    @Override
    public MInscription IaddInscription(Connection cnx, MInscription inscription) throws SQLException {

        MInscription inscription1 = new MInscription();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut IaddInscription");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addInscription(?,?,?,?)");
            callableStatement.setInt("p_idEtudiant", inscription.getIdEtudiant());
            callableStatement.setInt("p_idAnnee", inscription.getIdAnnee());
            callableStatement.setInt("p_idClasse", inscription.getIdClasse());
            callableStatement.setString("p_inscriptionPar", inscription.getInscriptionPar());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                inscription1.setIdInscription(resultSet.getInt("idInscription"));
                inscription1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                inscription1.setIdAnnee(resultSet.getInt("idAnnee"));
                inscription1.setIdClasse(resultSet.getInt("idClasse"));
                inscription1.setInscriptionPar(resultSet.getString("inscriptionPar"));
                inscription1.setInscriptionLe(resultSet.getDate("inscriptionLe"));
                inscription1.setIsdelete(resultSet.getBoolean("isdelete"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IaddInscription");
        return inscription1;
    }

    @Override
    public List<MInscription> IgetAllInscription(Connection cnx) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        List<MInscription> inscriptionArrayList = new ArrayList<>();
        System.out.println("debut IgetAllInscription");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllInscription()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                MInscription inscriptionResult = new MInscription();
                inscriptionResult.setIdInscription(resultSet.getInt("idInscription"));
                inscriptionResult.setIdEtudiant(resultSet.getInt("idEtudiant"));
                inscriptionResult.setIdAnnee(resultSet.getInt("idAnnee"));
                inscriptionResult.setIdClasse(resultSet.getInt("idClasse"));
                inscriptionResult.setInscriptionPar(resultSet.getString("inscriptionPar"));
                inscriptionResult.setInscriptionLe(resultSet.getDate("inscriptionLe"));
                inscriptionResult.setIsdelete(resultSet.getBoolean("isdelete"));
                inscriptionResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                inscriptionResult.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
                inscriptionArrayList.add(inscriptionResult);
            }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();

    } finally {
        cnx.close();
    }
        System .out.println("fin IGetAllEtudiantByCode");
        return inscriptionArrayList;
}

    @Override
    public MInscription IdeleteInscription(Connection cnx, MInscription inscription) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        MInscription inscription1 = new MInscription();
        System.out.println("debut deleteInscription");

        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.deletedInscription(?,?)");
            callableStatement.setInt("p_idInscription",inscription.getIdInscription());
            callableStatement.setString("p_isdeletedBy",inscription.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                inscription1.setIdInscription(resultSet.getInt("idInscription"));
                inscription1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                inscription1.setIdAnnee(resultSet.getInt("idAnnee"));
                inscription1.setIdClasse(resultSet.getInt("idClasse"));
                inscription1.setInscriptionPar(resultSet.getString("inscriptionPar"));
                inscription1.setInscriptionLe(resultSet.getDate("inscriptionLe"));
                inscription1.setIsdelete(resultSet.getBoolean("isdelete"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IaddInscription");
        return inscription1;
    }


    @Override
    public MInfoEtudiant IInfoEtudiant(Connection cnx, MInfoEtudiant infoEtudiant) throws SQLException {
        MInfoEtudiant infoEtudiant1 = new MInfoEtudiant();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut IInfoEtudiant");


        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.infoEtudiant(?)");
            callableStatement.setString("p_matriculeEtudiant", infoEtudiant.getMatriculeEtudiant());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                infoEtudiant1.setIdInscription(resultSet.getInt("idInscription"));
                infoEtudiant1.setIdAnnee(resultSet.getInt("IdAnnee"));
                infoEtudiant1.setAnnee(resultSet.getString("annee"));
                infoEtudiant1.setIdEtudiant(resultSet.getInt("IdEtudiant"));
                infoEtudiant1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                infoEtudiant1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                infoEtudiant1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                infoEtudiant1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                infoEtudiant1.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                infoEtudiant1.setContactEtudiant(resultSet.getString("contactEtudiant"));
                infoEtudiant1.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                infoEtudiant1.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                infoEtudiant1.setNomParent(resultSet.getString("nomParent"));
                infoEtudiant1.setContactParent(resultSet.getString("contactParent"));
                infoEtudiant1.setIdFiliere(resultSet.getInt("idFiliere"));
                infoEtudiant1.setLibFiliere(resultSet.getString("libFiliere"));
                infoEtudiant1.setIdNiveau(resultSet.getInt("idNiveau"));
                infoEtudiant1.setLibNiveau(resultSet.getString("libNiveau"));
                infoEtudiant1.setIdClasse(resultSet.getInt("idClasse"));
                infoEtudiant1.setTypeClasse(resultSet.getString("typeClasse"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IInfoEtudiant");
        return infoEtudiant1;
    }

    @Override
    public MInscription IgetlisteByClasse(Connection cnx, MInscription inscription) throws SQLException {
        MInscription inscription1 = new MInscription();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut IgetlisteByClasse");


        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getlisteByClasse(?)");
            callableStatement.setString("p_typeClasse", inscription.getTypeClasse());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                inscription1.setIdInscription(resultSet.getInt("idInscription"));
                inscription1.setIdAnnee(resultSet.getInt("IdAnnee"));
                inscription1.setAnnee(resultSet.getString("annee"));
                inscription1.setIdEtudiant(resultSet.getInt("IdEtudiant"));
                inscription1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                inscription1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                inscription1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                inscription1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                inscription1.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                inscription1.setContactEtudiant(resultSet.getString("contactEtudiant"));
                inscription1.setDateNaissEtudiant(resultSet.getString("dateNaissEtudiant"));
                inscription1.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                inscription1.setNomParent(resultSet.getString("nomParent"));
                inscription1.setContactParent(resultSet.getString("contactParent"));
                inscription1.setInscriptionLe(resultSet.getDate("inscriptionLe"));
                inscription1.setInscriptionPar(resultSet.getString("inscriptionPar"));
                inscription1.setIdFiliere(resultSet.getInt("idFiliere"));
                inscription1.setLibFiliere(resultSet.getString("libFiliere"));
                inscription1.setIdNiveau(resultSet.getInt("idNiveau"));
                inscription1.setLibNiveau(resultSet.getString("libNiveau"));
                inscription1.setIdClasse(resultSet.getInt("idClasse"));
                inscription1.setTypeClasse(resultSet.getString("typeClasse"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IgetlisteByClasse");
        return inscription1;
    }
    }
