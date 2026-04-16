package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IFiliere;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MFiliere;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IFiliere")
public class SFilieres implements IFiliere {
    @Override
    public MFiliere IaddFiliere(Connection cnx, MFiliere filiere) throws SQLException {
        MFiliere filiere1 = new MFiliere();
        ResultSet resultSet = null;
        CallableStatement callableStatement;

        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addFiliere(?,?)");
            callableStatement.setString("p_libFiliere",filiere.getLibFiliere());
            callableStatement.setString("p_createdBy",filiere.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                filiere1.setIdFiliere(resultSet.getInt("idFiliere"));
                filiere1.setLibFiliere(resultSet.getString("libFiliere"));
                filiere1.setIsdelete(resultSet.getBoolean("isdelete"));
                filiere1.setCreatedBy(resultSet.getString("createdBy"));
                filiere1.setCreatedOn(resultSet.getDate("createdOn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return filiere1;
    }

    @Override
    public List<MFiliere> IGetAllFiliere(Connection cnx) throws SQLException {
        ResultSet resultSet =null;
        CallableStatement callableStatement ;
        List<MFiliere> filieresArrayList = new ArrayList<>();
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.getAllFiliere()");

            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                MFiliere filiere1 = new MFiliere();
                filiere1.setIdFiliere(resultSet.getInt("idFiliere"));
                filiere1.setLibFiliere(resultSet.getString("libFiliere"));
                filiere1.setIsdelete(resultSet.getBoolean("isdelete"));
                filiere1.setCreatedBy(resultSet.getString("createdBy"));
                filiere1.setCreatedOn(resultSet.getDate("createdOn"));
                filieresArrayList.add(filiere1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        return filieresArrayList;
    }

}
