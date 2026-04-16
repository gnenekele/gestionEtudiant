package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IEtudiant;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MEtudiant;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IEtudiant")
public class SEtudiant implements IEtudiant {

    @Override
    public MEtudiant IaddEtudiant(Connection cnx, MEtudiant etudiant) throws SQLException {
        MEtudiant etudiant1 = new MEtudiant();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addEtudiant(?,?,?,?,?,?,?,?,?)");
            callableStatement.setString("p_nom", etudiant.getNomEtudiant());
            callableStatement.setString("p_prenom", etudiant.getPrenomEtudiant());
            callableStatement.setString("p_sexe", etudiant.getSexeEtudiant());
            callableStatement.setDate("p_dateNaissance", etudiant.getDateNaissEtudiant());
            callableStatement.setString("p_contact", etudiant.getContactEtudiant());
            callableStatement.setString("p_Email", etudiant.getEmailEtudiant());
            callableStatement.setString("p_nomParent", etudiant.getNomParent());
            callableStatement.setString("p_contactParent", etudiant.getContactParent());
            callableStatement.setString("p_createdBy", etudiant.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                etudiant1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                etudiant1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                etudiant1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                etudiant1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                etudiant1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                etudiant1.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                etudiant1.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                etudiant1.setContactEtudiant(resultSet.getString("contactEtudiant"));
                etudiant1.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                etudiant1.setNomParent(resultSet.getString("nomParent"));
                etudiant1.setContactParent(resultSet.getString("contactParent"));
                etudiant1.setCreatedBy(resultSet.getString("createdBy"));
                etudiant1.setCreatedOn(resultSet.getDate("createdOn"));
                etudiant1.setIsdelete(resultSet.getBoolean("isdelete"));
            }

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();

    } finally {
        cnx.close();
    }
        return etudiant1;
        }

    @Override
    public List<MInfoEtudiant>  IGetAllEtudiantByCode(Connection cnx, String code) throws SQLException {

        List<MInfoEtudiant> infoEtudiantArrayList = new ArrayList<>();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System .out.println("debut IGetAllEtudiantByCode");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllEtudiantByCode(?)");
            callableStatement.setString("p_codeEtudiant",code);
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                MInfoEtudiant etudiantResult = new MInfoEtudiant();
                etudiantResult.setIdEtudiant(resultSet.getInt("idEtudiant"));
                etudiantResult.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                etudiantResult.setNomEtudiant(resultSet.getString("nomEtudiant"));
                etudiantResult.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                etudiantResult.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                etudiantResult.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                etudiantResult.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                etudiantResult.setContactEtudiant(resultSet.getString("contactEtudiant"));
                etudiantResult.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                etudiantResult.setNomParent(resultSet.getString("nomParent"));
                etudiantResult.setContactParent(resultSet.getString("contactParent"));
               // etudiantResult.setLibFiliere(resultSet.getString("libFiliere"));

                infoEtudiantArrayList.add(etudiantResult);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IGetAllEtudiantByCode");
        return infoEtudiantArrayList;
    }

    @Override
    public List<MEtudiant> IGetAllEtudiant(Connection cnx) throws SQLException {
        ResultSet resultSet;
        List<MEtudiant> etudiantArrayList = new ArrayList<>();
        CallableStatement callableStatement;
        System .out.println("debut IGetAllEtudiant");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllEtudiant()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                MEtudiant  etudiantResult = new MEtudiant();
                etudiantResult.setIdEtudiant(resultSet.getInt("idEtudiant"));
                etudiantResult.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                etudiantResult.setNomEtudiant(resultSet.getString("nomEtudiant"));
                etudiantResult.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                etudiantResult.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                etudiantResult.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                etudiantResult.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                etudiantResult.setContactEtudiant(resultSet.getString("contactEtudiant"));
                etudiantResult.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                etudiantResult.setNomParent(resultSet.getString("nomParent"));
                etudiantResult.setContactParent(resultSet.getString("contactParent"));
                etudiantResult.setCreatedBy(resultSet.getString("createdBy"));
                etudiantResult.setCreatedOn(resultSet.getDate("createdOn"));
                etudiantResult.setIsdelete(resultSet.getBoolean("isdelete"));
                etudiantArrayList.add(etudiantResult);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IGetAllEtudiant");
        return etudiantArrayList;
    }

    @Override
    public MEtudiant IdeleteEtudiant(Connection cnx, MEtudiant etudiant) throws SQLException {

        MEtudiant etudiant1 = new MEtudiant();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System .out.println("debut IdeleteEtudiant");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteEtudiant(?,?)");
           callableStatement.setString("p_codeEtudiant",etudiant.getCodeEtudiant());
           callableStatement.setString("p_isdeletedBy",etudiant.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                etudiant1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                etudiant1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                etudiant1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                etudiant1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                etudiant1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                etudiant1.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                etudiant1.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                etudiant1.setContactEtudiant(resultSet.getString("contactEtudiant"));
                etudiant1.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                etudiant1.setNomParent(resultSet.getString("nomParent"));
                etudiant1.setContactParent(resultSet.getString("contactParent"));
                etudiant1.setCreatedBy(resultSet.getString("createdBy"));
                etudiant1.setCreatedOn(resultSet.getDate("createdOn"));
                etudiant1.setIsdelete(resultSet.getBoolean("isdelete"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IdeleteEtudiant");
        return etudiant1;
    }

    @Override
    public MEtudiant IUpdateEtudiant(Connection cnx, MEtudiant etudiant) throws SQLException {
        MEtudiant etudiant1 = new MEtudiant();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.updateEtudiant(?,?,?,?, ?,?,?,? ,?,?);");
            callableStatement.setInt("p_idEtudiant",etudiant.getIdEtudiant());
            callableStatement.setString("p_nom", etudiant.getNomEtudiant());
            callableStatement.setString("p_prenom", etudiant.getPrenomEtudiant());

            //callableStatement.setString("p_matricule",etudiant.getMatriculeEtudiant());
            callableStatement.setString("p_sexe", etudiant.getSexeEtudiant());
            callableStatement.setDate("p_dateNaissance", etudiant.getDateNaissEtudiant());

            callableStatement.setString("p_contact", etudiant.getContactEtudiant());
            callableStatement.setString("p_Email", etudiant.getEmailEtudiant());
            callableStatement.setString("p_nomParent", etudiant.getNomParent());

            callableStatement.setString("p_contactParent", etudiant.getContactParent());
            callableStatement.setString("p_modifiedBy", etudiant.getModifiedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                etudiant1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                etudiant1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                etudiant1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                etudiant1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                etudiant1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                etudiant1.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                etudiant1.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                etudiant1.setContactEtudiant(resultSet.getString("contactEtudiant"));
                etudiant1.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                etudiant1.setNomParent(resultSet.getString("nomParent"));
                etudiant1.setContactParent(resultSet.getString("contactParent"));
                etudiant1.setModifiedBy(resultSet.getString("modifiedBy"));
                etudiant1.setModifiedOn(resultSet.getDate("modifiedOn"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return etudiant1;
    }

    /** @Override
    public MEtudiant IgetNoteByEtudiant(Connection cnx, MEtudiant etudiant) throws SQLException {
        MEtudiant etudiant1 = new MEtudiant();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System .out.println("debut IdeleteEtudiant");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getNoteByEtudiant(?)");
            callableStatement.setString("P_codeEtudiant",etudiant.getCodeEtudiant());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                etudiant1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                etudiant1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                etudiant1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                etudiant1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                etudiant1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                etudiant1.setSexeEtudiant(resultSet.getString("sexeEtudiant"));
                etudiant1.setDateNaissEtudiant(resultSet.getDate("dateNaissEtudiant"));
                etudiant1.setContactEtudiant(resultSet.getString("contactEtudiant"));
                etudiant1.setEmailEtudiant(resultSet.getString("emailEtudiant"));
                etudiant1.setNomParent(resultSet.getString("nomParent"));
                etudiant1.setContactParent(resultSet.getString("contactParent"));
                etudiant1.setCreatedBy(resultSet.getString("createdBy"));
                etudiant1.setCreatedOn(resultSet.getDate("createdOn"));
                etudiant1.setIsdelete(resultSet.getBoolean("isdelete"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System .out.println("fin IdeleteEtudiant");
        return etudiant1;
    }**/

}

