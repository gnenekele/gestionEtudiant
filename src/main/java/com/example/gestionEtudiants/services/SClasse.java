package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IClasse;
import com.example.gestionEtudiants.modeles.MClasse;
import com.example.gestionEtudiants.modeles.MEtudiant;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IClasse")
public class SClasse implements IClasse {
    @Override
    public MClasse IaddClasse(Connection cnx, MClasse classe) throws SQLException {
        MClasse classe1 = new MClasse();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IaddClasse");
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addClasse(?,?,?,?)");
            callableStatement.setInt("p_idFiliere", classe.getIdFiliere());
            callableStatement.setInt("p_idNiveau", classe.getIdNiveau());
            callableStatement.setString("p_typeClasse", classe.getTypeClasse());
            callableStatement.setString("p_createdBy", classe.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                classe1.setIdClasse(resultSet.getInt("idClasse"));
                classe1.setIdNiveau(resultSet.getInt("idNiveau"));
                classe1.setIdFiliere(resultSet.getInt("idFiliere"));
                classe1.setTypeClasse(resultSet.getString("typeClasse"));
                classe1.setCreatedBy(resultSet.getString("createdBy"));
                classe1.setCreatedOn(resultSet.getDate("createdOn"));
                classe1.setIsdelete(resultSet.getBoolean("isdelete"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IaddClasse");
        return classe1;
    }

    @Override
    public List<MClasse> IGetAllClasse(Connection cnx) throws SQLException {
       ResultSet resultSet =null;
       CallableStatement callableStatement;
        List<MClasse> classeArrayList = new ArrayList<>();
        System .out.println("debut IGetAllClasse");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllClasse()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                MClasse  classeResult = new MClasse();
                classeResult.setIdClasse(resultSet.getInt("idClasse"));
                classeResult.setIdNiveau(resultSet.getInt("idNiveau"));
                classeResult.setIdFiliere(resultSet.getInt("idFiliere"));
                classeResult.setTypeClasse(resultSet.getString("typeClasse"));
                classeResult.setCreatedBy(resultSet.getString("createdBy"));
                classeResult.setCreatedOn(resultSet.getDate("createdOn"));
                classeResult.setIsdelete(resultSet.getBoolean("isdelete"));
                classeArrayList.add(classeResult);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IGetAllClasse");
        return classeArrayList;
    }

    @Override
    public MClasse IUpdateClasse(Connection cnx, MClasse classe) throws SQLException {
       ResultSet resultSet=null;
       CallableStatement callableStatement;
        MClasse classe1 = new MClasse();
        System.out.println("debut IUpdateClasse");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.updateClasse(?,?,?,?,?)");
            callableStatement.setInt("p_idClasse",classe.getIdClasse());
            callableStatement.setInt("p_idFiliere",classe.getIdFiliere());
            callableStatement.setInt("p_idNiveau",classe.getIdNiveau());
            callableStatement.setString("p_typeClasse", classe.getTypeClasse());
            callableStatement.setString("p_modifiedBy",classe.getModifiedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                classe1.setIdClasse(resultSet.getInt("idClasse"));
                classe1.setIdNiveau(resultSet.getInt("idNiveau"));
                classe1.setIdFiliere(resultSet.getInt("idFiliere"));
                classe1.setTypeClasse(resultSet.getString("typeClasse"));
                classe1.setModifiedBy(resultSet.getString("modifiedBy"));
                classe1.setModifiedOn(resultSet.getDate("modifiedOn"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IUpdateclasse");
        return classe1;
        }



    @Override
    public MClasse IDeleteclasse(Connection cnx, MClasse classe) throws SQLException {
        CallableStatement callableStatement;
        ResultSet resultSet ;
        MClasse classe1 = new MClasse();

        System.out.println("debut IDeleteclasse");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteclasse(?,?)");
            callableStatement.setInt("p_idClasse",classe.getIdClasse());
            callableStatement.setString("p_isdeletedBy",classe.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                classe1.setIdClasse(resultSet.getInt("idClasse"));
                classe1.setIdNiveau(resultSet.getInt("idNiveau"));
                classe1.setIdFiliere(resultSet.getInt("idFiliere"));
                classe1.setTypeClasse(resultSet.getString("typeClasse"));
               // classe1.setCreatedBy(resultSet.getString("createdBy"));
               // classe1.setCreatedOn(resultSet.getDate("createdOn"));
                classe1.setIsdelete(resultSet.getBoolean("isdelete"));
                classe1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IDeleteclasse");
        return classe1;
    }

}

