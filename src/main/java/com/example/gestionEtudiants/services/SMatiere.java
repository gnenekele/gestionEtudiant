package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IMatiere;
import com.example.gestionEtudiants.modeles.MMatiere;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IMatiere")
public class SMatiere implements IMatiere {
    @Override
    public MMatiere IaadMatiere(Connection cnx, MMatiere matiere) throws SQLException {
        MMatiere matiere1 =new MMatiere();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IaadMatiere");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addMatiere(?,?)");
            callableStatement.setString("p_libMatiere",matiere.getLibMatiere());
            callableStatement.setString("p_createdBy",matiere.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                matiere1.setIdMatiere(resultSet.getInt("idMatiere"));
                matiere1.setLibMatiere(resultSet.getString("libMatiere"));
                matiere1.setCreatedBy(resultSet.getString("createdBy"));
                matiere1.setCreatedOn(resultSet.getDate("createdOn"));
                matiere1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                matiere1.setIsdelete(resultSet.getBoolean("isdelete"));
                matiere1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                matiere1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IaadMatiere");
        return matiere1;
    }

    @Override
    public MMatiere IdeleteMatiere(Connection cnx, MMatiere matiere) throws SQLException {
        MMatiere matiere1 =new MMatiere();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        System.out.println("debut IdeleteMatiere");

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.deleteMatiere(?,?)");
            callableStatement.setInt("p_idMatiere",matiere.getIdMatiere());
            callableStatement.setString("p_isdeletedBy",matiere.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()){
                matiere1.setIdMatiere(resultSet.getInt("idMatiere"));
                matiere1.setLibMatiere(resultSet.getString("libMatiere"));
                matiere1.setCreatedBy(resultSet.getString("createdBy"));
                matiere1.setCreatedOn(resultSet.getDate("createdOn"));
                matiere1.setIsdelete(resultSet.getBoolean("isdelete"));
                matiere1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                matiere1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IdeleteMatiere");
        return matiere1;
    }


    @Override
    public List<MMatiere> IGetAllMatiere(Connection cnx) throws SQLException {
        ResultSet resultSet =null;
        CallableStatement callableStatement;
        List<MMatiere> matiereArrayList =new ArrayList<>();

        System.out.println("debut IGetAllMatiere");

        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllMatiere()");
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
                MMatiere matiereResult = new MMatiere();
                matiereResult.setIdMatiere(resultSet.getInt("idMatiere"));
                matiereResult.setLibMatiere(resultSet.getString("libMatiere"));
                matiereResult.setCreatedOn(resultSet.getDate("createdOn"));
                matiereResult.setCreatedBy(resultSet.getString("isdeletedBy"));
                matiereResult.setIsdelete(resultSet.getBoolean("isdelete"));
                matiereResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
             //   matiereResult.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
                matiereArrayList.add(matiereResult);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IGetAllMatiere");
        return matiereArrayList;
    }




}
