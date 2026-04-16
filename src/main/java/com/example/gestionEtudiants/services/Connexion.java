package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.Utils.Configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Connexion {
    @Autowired
    Configs configs;

    private Connection cnx;

    public Connection connexionGestionEtudiant() throws ClassNotFoundException, SQLException {
        Class.forName(configs.getMysqlDriver());
        cnx = DriverManager.getConnection(configs.getMysqlHost(), configs.getMysqlUsername(), configs.getMysqlPassword());
        return cnx ;
    }
}
