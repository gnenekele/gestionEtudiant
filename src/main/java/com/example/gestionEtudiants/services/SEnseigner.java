package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IEnseigner;
import com.example.gestionEtudiants.modeles.MClasse;
import com.example.gestionEtudiants.modeles.MEnseigner;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import com.example.gestionEtudiants.modeles.MInfoProf;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IEnseigner")
public class SEnseigner implements IEnseigner {

    @Override
    public List<MInfoProf> IinfoProf(Connection cnx, String matriculeProf) throws SQLException {

           List<MInfoProf>  infoProfArrayList = new ArrayList<>();
            ResultSet resultSet = null;
            CallableStatement callableStatement;

            System.out.println("debut infoProf");
            try {
                callableStatement = cnx.prepareCall("call gestionetudiants.infoProf(?)");
                callableStatement.setString("p_matriculeProf",matriculeProf);
                callableStatement.executeUpdate();
                resultSet = callableStatement.getResultSet();

                while (resultSet.next()) {
                    MInfoProf profResult = new MInfoProf();
                    profResult.setIdEnseigner(resultSet.getInt("idEnseigner"));
                    profResult.setTypeEnseigner(resultSet.getString("typeEnseigner"));
                    profResult.setIdAnnee(resultSet.getInt("IdAnnee"));
                    profResult.setAnnee(resultSet.getString("annee"));
                    profResult.setIdFiliere(resultSet.getInt("idFiliere"));
                    profResult.setLibFiliere(resultSet.getString("libFiliere"));
                    profResult.setIdNiveau(resultSet.getInt("idNiveau"));
                    profResult.setLibNiveau(resultSet.getString("libNiveau"));
                    profResult.setIdClasse(resultSet.getInt("idClasse"));
                    profResult.setTypeClasse(resultSet.getString("typeClasse"));
                    profResult.setIdMatiere(resultSet.getInt("idMatiere"));
                    profResult.setLibMatiere(resultSet.getString("libMatiere"));
                    profResult.setIdProf(resultSet.getInt("idProf"));
                    profResult.setCodeProf(resultSet.getString("codeProf"));
                    profResult.setNomProf(resultSet.getString("nomProf"));
                    profResult.setPrenomProf(resultSet.getString("prenomProf"));
                    profResult.setMatriculeProf(resultSet.getString("matriculeProf"));
                    profResult.setContactProf(resultSet.getString("contactProf"));
                    profResult.setDateNaissanceProf(resultSet.getString("dateNaissanceProf"));
                    profResult.setEmail(resultSet.getString("email"));
                    profResult.setSexeProf(resultSet.getString("sexeProf"));
                    infoProfArrayList.add(profResult);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                cnx.close();
            }
            System.out.println("fin IInfoProf");
            return infoProfArrayList;
        }


    @Override
    public MEnseigner IaddEnseigner(Connection cnx, MEnseigner enseigner) throws SQLException {
        MEnseigner enseigner1 = new MEnseigner();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut addEnseigner");
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addEnseigner(?,?,?,?,?,?)");
            callableStatement.setInt("p_idProf", enseigner.getIdProf());
            callableStatement.setInt("p_idAnnee", enseigner.getIdAnnee());
            callableStatement.setInt("p_idClasse", enseigner.getIdClasse());
            callableStatement.setInt("p_idMatiere", enseigner.getIdMatiere());
            callableStatement.setString("p_typeEnseigner", enseigner.getTypeEnseigner());
            callableStatement.setString("p_createdBy", enseigner.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                enseigner1.setIdEnseigner(resultSet.getInt("idEnseigner"));
                enseigner1.setTypeEnseigner(resultSet.getString("typeEnseigner"));
                enseigner1.setIdAnnee(resultSet.getInt("IdAnnee"));
                enseigner1.setIdClasse(resultSet.getInt("idClasse"));
                enseigner1.setIdMatiere(resultSet.getInt("idMatiere"));
                enseigner1.setIdProf(resultSet.getInt("idProf"));
                enseigner1.setCreatedBy(resultSet.getString("createdBy"));
                enseigner1.setCreatedOn(resultSet.getDate("createdOn"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin addEnseigner");
        return enseigner1;
    }

    @Override
    public MEnseigner IDeleteEnseigner(Connection cnx, MEnseigner enseigner) throws SQLException {
        MEnseigner enseigner1 = new MEnseigner();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IDeleteEnseigner");
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteEnseigner(?,?)");
            callableStatement.setInt("p_idEnseigner",enseigner.getIdEnseigner());
            callableStatement.setString("p_isdeletedBy",enseigner.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                enseigner1.setIdEnseigner(resultSet.getInt("idEnseigner"));
                enseigner1.setTypeEnseigner(resultSet.getString("typeEnseigner"));
                enseigner1.setIdAnnee(resultSet.getInt("IdAnnee"));
                enseigner1.setIdClasse(resultSet.getInt("idClasse"));
                enseigner1.setIdMatiere(resultSet.getInt("idMatiere"));
                enseigner1.setIdProf(resultSet.getInt("idProf"));
                enseigner1.setIsdelete(resultSet.getBoolean("isdelete"));
                enseigner1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                enseigner1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IDeleteEnseigner");
        return enseigner1;

    }

    @Override
    public MEnseigner IUpdateEnseigner(Connection cnx, MEnseigner enseigner) throws SQLException {
        MEnseigner enseigner1 = new MEnseigner();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IUpdatEnseigner");
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.updateEnseigner(?,?,?,?,?,?,?)");
            callableStatement.setInt("p_idEnseigner",enseigner.getIdEnseigner());
            callableStatement.setInt("p_idProf",enseigner.getIdProf());
            callableStatement.setInt("p_idAnnee",enseigner.getIdAnnee());
            callableStatement.setInt("p_idClasse",enseigner.getIdClasse());
            callableStatement.setInt("p_idMatiere",enseigner.getIdMatiere());
            callableStatement.setString("p_typeEnseigner",enseigner.getTypeEnseigner());
            callableStatement.setString("p_modifiedBy",enseigner.getModifiedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {

                enseigner1.setIdEnseigner(resultSet.getInt("idEnseigner"));
                enseigner1.setTypeEnseigner(resultSet.getString("typeEnseigner"));
                enseigner1.setIdAnnee(resultSet.getInt("IdAnnee"));
                enseigner1.setIdClasse(resultSet.getInt("idClasse"));
                enseigner1.setIdMatiere(resultSet.getInt("idMatiere"));
                enseigner1.setIdProf(resultSet.getInt("idProf"));
                enseigner1.setModifiedBy(resultSet.getString("modifiedBy"));
                enseigner1.setModifiedOn(resultSet.getDate("modifiedOn"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IUpdatEnseigner");
        return enseigner1;

    }


    @Override
    public List<MEnseigner> IGetAllEnseigner(Connection cnx) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        List<MEnseigner> EnseignerArrayList = new ArrayList<>();
        System.out.println("debut IGetAllEnseigner");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllEnseigner()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                MEnseigner EnseignerResult = new MEnseigner();
                EnseignerResult.setIdEnseigner(resultSet.getInt("idEnseigner"));
                EnseignerResult.setTypeEnseigner(resultSet.getString("typeEnseigner"));
                EnseignerResult.setIdAnnee(resultSet.getInt("IdAnnee"));
                EnseignerResult.setIdClasse(resultSet.getInt("idClasse"));
                EnseignerResult.setIdMatiere(resultSet.getInt("idMatiere"));
                EnseignerResult.setIdProf(resultSet.getInt("idProf"));
                EnseignerResult.setCreatedBy(resultSet.getString("createdBy"));
                EnseignerResult.setCreatedOn(resultSet.getDate("createdOn"));
                EnseignerResult.setModifiedBy(resultSet.getString("modifiedBy"));
                EnseignerResult.setModifiedOn(resultSet.getDate("modifiedOn"));
                EnseignerResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                EnseignerArrayList.add(EnseignerResult);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IGetAllEnseigner");
        return EnseignerArrayList;


    }
}


