package com.example.gestionEtudiants.interfaces;
import com.example.gestionEtudiants.modeles.MPeriode;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface IPeriode {
    MPeriode IaadPeriode (Connection cnx, MPeriode periode)throws SQLException;
    List<MPeriode>IGetallPeriode (Connection cnx)throws SQLException;
}
