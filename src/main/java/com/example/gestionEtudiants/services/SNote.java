package com.example.gestionEtudiants.services;
import com.example.gestionEtudiants.interfaces.INote;
import com.example.gestionEtudiants.modeles.MNote;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("INote")
public class SNote implements INote {
    @Override
    public MNote IaadNote(Connection cnx, MNote note) throws SQLException {
        MNote note1 =new MNote();
        ResultSet resultSet =null;
        System.out.println("debut IaadNote");
        CallableStatement callableStatement;
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addNote(?,?,?,?)");
            callableStatement.setInt("p_idEtudiant",note.getIdEtudiant());
            callableStatement.setInt("p_idEvaluation",note.getIdEvaluation());
            callableStatement.setString("p_libNote",note.getLibNote());
            callableStatement.setString("p_createdBy",note.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                note1.setIdNote(resultSet.getInt("idNote"));
                note1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                note1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                note1.setLibNote(resultSet.getString("libNote"));
                note1.setCreatedBy(resultSet.getString("createdBy"));
            }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();

    } finally {
        cnx.close();
    }
        System.out.println("debut IaadNote");
        return note1;
}

    @Override
    public MNote IUpdate(Connection cnx, MNote note) throws SQLException {
        return null;
    }


    @Override
    public MNote IDelete(Connection cnx, MNote note) throws SQLException {
        MNote note1 =new MNote();
        ResultSet resultSet =null;
        CallableStatement callableStatement;
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteNote(?,?)");
            callableStatement.setInt("p_idNote",note.getIdNote());
            callableStatement.setString("p_isdeletedBy",note.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                note1.setIdNote(resultSet.getInt("idNote"));
                note1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                note1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                note1.setLibNote(resultSet.getString("libNote"));
                note1.setIsdelete(resultSet.getBoolean("isdelete"));
                note1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
                note1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return note1;

    }
    @Override
    public List<MNote> IgetAllNote(Connection cnx) throws SQLException {
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        List<MNote> noteArrayList = new ArrayList<>();
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllnote()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()){
            MNote noteResult =new MNote();
            noteResult.setIdNote(resultSet.getInt("idNote"));
            noteResult.setIdEtudiant(resultSet.getInt("idEtudiant"));
            noteResult.setIdEvaluation(resultSet.getInt("idEvaluation"));
            noteResult.setLibNote(resultSet.getString("libNote"));
            noteResult.setIsdelete(resultSet.getBoolean("isdelete"));
            noteResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
            noteResult.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
            noteArrayList.add(noteResult);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return noteArrayList;

    }

    @Override
    public MNote IgetNoteByEtudiant(Connection cnx, MNote note) throws SQLException {
        MNote note1 =new MNote();
        ResultSet resultSet =null;
        CallableStatement callableStatement;
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getNoteByEtudiant('?')");
            callableStatement.setString("P_codeEtudiant",note.getCodeEtudiant());

            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                note1.setIdNote(resultSet.getInt("idNote"));
                note1.setLibNote(resultSet.getString("libNote"));
                note1.setIdEtudiant(resultSet.getInt("idEtudiant"));
                note1.setCodeEtudiant(resultSet.getString("codeEtudiant"));
                note1.setNomEtudiant(resultSet.getString("nomEtudiant"));
                note1.setPrenomEtudiant(resultSet.getString("prenomEtudiant"));
                note1.setMatriculeEtudiant(resultSet.getString("matriculeEtudiant"));
                note1.setIdEvaluation(resultSet.getInt("idEvaluation"));
                note1.setLibNote(resultSet.getString("libNote"));
                note1.setIsdelete(resultSet.getBoolean("isdelete"));
                note1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
                note1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return note1;

    }



    }
