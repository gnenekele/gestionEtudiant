package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IProfesseur;
import com.example.gestionEtudiants.modeles.MProfesseur;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service ("IProfesseur")
public class SProfesseur implements IProfesseur {

    @Override
    public MProfesseur IaddProfesseur(Connection cnx, MProfesseur professeur) throws SQLException {
        MProfesseur professeur1 = new MProfesseur();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addProfesseur(?,?,?,?,?,?, ?)");
            callableStatement.setString("p_nom", professeur.getNomProf());
            callableStatement.setString("p_prenom", professeur.getPrenomProf());
            callableStatement.setString("p_sexe", professeur.getSexeProf());
            callableStatement.setString("p_dateNaissance", professeur.getDateNaissanceProf());
            callableStatement.setString("p_contact", professeur.getContactProf());
            callableStatement.setString("p_Email", professeur.getEmail());
            callableStatement.setString("p_createdBy", professeur.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                professeur1.setIdProf(resultSet.getInt("idProf"));
                professeur1.setCodeProf(resultSet.getString("codeProf"));
                professeur1.setNomProf(resultSet.getString("nomProf"));
                professeur1.setPrenomProf(resultSet.getString("prenomProf"));
                professeur1.setMatriculeProf(resultSet.getString("matriculeProf"));
                professeur1.setSexeProf(resultSet.getString("sexeProf"));
                professeur1.setDateNaissanceProf(resultSet.getString("dateNaissanceProf"));
                professeur1.setContactProf(resultSet.getString("contactProf"));
                professeur1.setEmail(resultSet.getString("Email"));
                professeur1.setIsdelete(resultSet.getBoolean("isdelete"));
                professeur1.setCreatedBy(resultSet.getString("createdBy"));
                professeur1.setCreatedOn(resultSet.getDate("createdOn"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return professeur1;
    }

    @Override
    public List<MProfesseur> IGetAllProfesseur(Connection cnx) throws SQLException {
        return null;
    }

    @Override
    public MProfesseur IdeleteProfesseur(Connection cnx, MProfesseur professeur) throws SQLException {
        MProfesseur professeur1 = new MProfesseur();
        ResultSet resultSet;
        CallableStatement callableStatement;

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteProf(?,?)");
            callableStatement.setInt("p_idProf", professeur.getIdProf());
            callableStatement.setString("p_isdeletedBy",professeur.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                professeur1.setIdProf(resultSet.getInt("idProf"));
                professeur1.setCodeProf(resultSet.getString("codeProf"));
                professeur1.setNomProf(resultSet.getString("nomProf"));
                professeur1.setPrenomProf(resultSet.getString("prenomProf"));
                professeur1.setMatriculeProf(resultSet.getString("matriculeProf"));
                professeur1.setSexeProf(resultSet.getString("sexeProf"));
                professeur1.setDateNaissanceProf(resultSet.getString("dateNaissanceProf"));
                professeur1.setContactProf(resultSet.getString("contactProf"));
                professeur1.setEmail(resultSet.getString("Email"));
                professeur1.setIsdelete(resultSet.getBoolean("isdelete"));
                professeur1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                professeur1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
                //professeur1.setCreatedBy(resultSet.getString("createdBy"));
                //professeur1.setCreatedOn(resultSet.getDate("createdOn"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return professeur1;

    }

    @Override
    public MProfesseur IupdateProfesseur(Connection cnx, MProfesseur professeur) throws SQLException {
        return null;
    }

    @Override
    public MProfesseur IgetProfesseurByCode(Connection cnx, MProfesseur professeur) throws SQLException {
        MProfesseur professeur1 = new MProfesseur();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllProfByCode(?)");
            callableStatement.setString("P_codeProf", professeur.getCodeProf());

           // callableStatement.setString("p_isdeletedBy",professeur.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                professeur1.setIdProf(resultSet.getInt("idProf"));
                professeur1.setCodeProf(resultSet.getString("codeProf"));
                professeur1.setNomProf(resultSet.getString("nomProf"));
                professeur1.setPrenomProf(resultSet.getString("prenomProf"));
                professeur1.setMatriculeProf(resultSet.getString("matriculeProf"));
                professeur1.setSexeProf(resultSet.getString("sexeProf"));
                professeur1.setDateNaissanceProf(resultSet.getString("dateNaissanceProf"));
                professeur1.setContactProf(resultSet.getString("contactProf"));
                professeur1.setEmail(resultSet.getString("Email"));
                professeur1.setIsdelete(resultSet.getBoolean("isdelete"));
                professeur1.setCreatedBy(resultSet.getString("createdBy"));
                professeur1.setCreatedOn(resultSet.getDate("createdOn"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return professeur1;
    }

}
