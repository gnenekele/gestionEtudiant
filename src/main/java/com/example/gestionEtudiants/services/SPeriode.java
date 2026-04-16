package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.interfaces.IPeriode;
import com.example.gestionEtudiants.modeles.MPeriode;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("IPeriode")
public class SPeriode implements IPeriode {

    @Override
    public MPeriode IaadPeriode(Connection cnx, MPeriode periode) throws SQLException {
        MPeriode periode1 = new MPeriode();
        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut IaadPeriode");
        try {
            callableStatement = cnx.prepareCall("call gestionetudiants.addPeriode(?,?,?,?,?)");
            callableStatement.setInt("p_idAnnee", periode.getIdAnnee());
            callableStatement.setString("p_typePeriode", periode.getTypePeriode());
            callableStatement.setString("p_dateDeb", periode.getDateDeb());
            callableStatement.setString("p_dateFin", periode.getDateFin());
            callableStatement.setString("p_createdBy", periode.getCreatedBy());
            callableStatement.executeUpdate();
            resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                periode1.setIdPeriode(resultSet.getInt("idPeriode"));
                periode1.setIdAnnee(resultSet.getInt("idAnnee"));
                periode1.setTypePeriode(resultSet.getString("typePeriode"));
                periode1.setDateDeb(resultSet.getString("dateDeb"));
                periode1.setDateFin(resultSet.getString("dateFin"));
                periode1.setCreatedBy(resultSet.getString("createdBy"));
                periode1.setCreatedOn(resultSet.getDate("createdOn"));
                periode1.setIsdelete(resultSet.getBoolean("isdelete"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            cnx.close();
        }
        System.out.println("fin IaadPeriode");
        return periode1;
    }

    @Override
    public List<MPeriode> IGetallPeriode(Connection cnx) throws SQLException {

        ResultSet resultSet = null;
        CallableStatement callableStatement;
        System.out.println("debut Get ALL Periode");

        List<MPeriode> periodeArrayList = new ArrayList<>();

        try{
        callableStatement = cnx.prepareCall("call gestionetudiants.getAllPeriode()");
        callableStatement.executeUpdate();
        resultSet = callableStatement.getResultSet();

        while (resultSet.next()) {

        MPeriode periodeResult = new MPeriode();
        periodeResult.setIdPeriode(resultSet.getInt("idPeriode"));
        periodeResult.setIdAnnee(resultSet.getInt("idAnnee"));
        periodeResult.setTypePeriode(resultSet.getString("typePeriode"));
        periodeResult.setDateDeb(resultSet.getString("dateDeb"));
        periodeResult.setDateFin(resultSet.getString("dateFin"));
        periodeResult.setCreatedBy(resultSet.getString("createdBy"));
        periodeResult.setCreatedOn(resultSet.getDate("createdOn"));
        periodeResult.setIsdelete(resultSet.getBoolean("isdelete"));
        periodeArrayList.add(periodeResult);

                }
                resultSet.close();
            }  catch (SQLException e){
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cnx.close();
            }
            System.out.println("fin Get ALL anneeAcademiques");

            return periodeArrayList;
        }
}