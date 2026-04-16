package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.INiveau;
import com.example.gestionEtudiants.modeles.MNiveau;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("INiveau")
public class SNiveau implements INiveau {
    @Override
    public MNiveau IaddNiveau(Connection cnx, MNiveau niveau) throws SQLException {
        MNiveau niveau1= new MNiveau();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut IaddNiveau");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.addNiveau(?,?)");
            callableStatement.setString("p_libNiveau", niveau.getLibNiveau());
            callableStatement.setString("p_createdBy",niveau.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                niveau1.setIdNiveau(resultSet.getInt("idNiveau"));
                niveau1.setLibNiveau(resultSet.getString("libNiveau"));
                niveau1.setCreatedBy(resultSet.getString("createdBy"));
                niveau1.setCreatedOn(resultSet.getDate("createdOn"));
                niveau1.setIsdelete(resultSet.getBoolean("isdelete"));
                niveau1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                niveau1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));

            }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();

    } finally {
        cnx.close();
    }
        System.out.println("Fin IaddNiveau");
        return niveau1;
    }

    @Override
    public MNiveau IdeleteNiveau(Connection cnx, MNiveau niveau) throws SQLException {
        MNiveau niveau1 = new MNiveau();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut IaddNiveau");

        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.deletedNiveau(?,?)");
            callableStatement.setInt("p_idNiveau", niveau.getIdNiveau());
            callableStatement.setString("p_isdeletedBy",niveau.getIsdeletedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();
            while (resultSet.next()){
            niveau1.setIdNiveau(resultSet.getInt("idNiveau"));
            niveau1.setLibNiveau(resultSet.getString("libNiveau"));
            niveau1.setCreatedBy(resultSet.getString("createdBy"));
            niveau1.setCreatedOn(resultSet.getDate("createdOn"));
            niveau1.setIsdelete(resultSet.getBoolean("isdelete"));
            niveau1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
            niveau1.setIsdeletedBy(resultSet.getString("isdeletedOn"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("Fin IaddNiveau");
        return niveau1;
    }

    @Override
    public List<MNiveau> IgetAllNiveau(Connection cnx) throws SQLException {
        MNiveau niveau1 = new MNiveau();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        List<MNiveau> niveauArrayList = new ArrayList<>();
        System.out.println("debut IgetAllNiveau");
        try{
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllNiveau()");
            callableStatement.executeUpdate();
           resultSet = callableStatement.getResultSet();

               while (resultSet.next()){
                   MNiveau niveauResult = new MNiveau();
                   niveauResult.setIdNiveau(resultSet.getInt("idNiveau"));
                   niveauResult.setLibNiveau(resultSet.getString("libNiveau"));
                   niveauResult.setCreatedBy(resultSet.getString("createdBy"));
                   niveauResult.setCreatedOn(resultSet.getDate("createdOn"));
                   niveauResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
                   niveauResult.setIsdeletedBy(resultSet.getString("isdeletedOn"));
                   niveauArrayList.add(niveauResult);
               }
           } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                cnx.close();
            }
            System.out.println("Fin IgetAllNiveau");
            return niveauArrayList;
        }


}
