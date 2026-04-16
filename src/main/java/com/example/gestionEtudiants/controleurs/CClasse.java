package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IClasse;
import com.example.gestionEtudiants.interfaces.IEtudiant;
import com.example.gestionEtudiants.modeles.MClasse;
import com.example.gestionEtudiants.modeles.MEtudiant;
import com.example.gestionEtudiants.services.Connexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@CrossOrigin("*")
@RestController
@RequestMapping(value = "/gestionEtudiants")

public class CClasse {

    @Autowired
    private Connexion cnx;

    @Autowired
    private final IClasse iClasse;

    public CClasse(IClasse iClasse) {
        this.iClasse = iClasse;
    }


    @RequestMapping(value = "/addClasse", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> addClasse(@RequestBody MClasse classe) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MClasse classe1 = new MClasse();

        try {
            classe1 = this.iClasse.IaddClasse(cnx.connexionGestionEtudiant(), classe);
            if (classe1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", classe1);

            } else {
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "impossible d'enregistrer.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible d'enregistrer.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible d'enregistrer.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping(value = "/updateClass", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> updateClass(@RequestBody MClasse classe) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MClasse classe1 = new MClasse();

        try {
            classe1 = this.iClasse.IUpdateClasse(cnx.connexionGestionEtudiant(), classe);
            if (classe1 != null) {
                response.put("message", "modification effetuer.");
                response.put("code", 200);
                response.put("data", classe1);

            } else {
                response.put("message", "impossible de modifier.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "impossible de modifier.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible de modifier.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible de modifier.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping(value = "/deleteclasse", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteclasse(@RequestBody MClasse classe) throws SQLException {
        MClasse classe1 = new MClasse();
        Map<String, Object> response = new HashMap<>();

        try {
            classe1 = this.iClasse.IDeleteclasse(cnx.connexionGestionEtudiant(), classe);
            if (classe1 != null) {
                response.put("message", "classe supprimer .");
                response.put("code", 200);
                response.put("data", classe1);

            } else {
                response.put("message", "impossible de supprimer.");
                response.put("code", 300);
            }
            if (classe1.isIsdelete() == true){
                response.put("message", " classe supprimer.");
                response.put("code", 300);
                response.put("data", classe1);
            }  else {
                response.put("message", "impossible de supprimer.");
                response.put("code", 300);
            }response.put("code", 300);


        } catch (SQLException e) {
            response.put("message", "impossible de supprimer.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible de supprimer.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible de supprimer.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }




    @RequestMapping(value = "/getAllClasse", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getAllClasse() {

        List<MClasse> classeList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();

        try {
            classeList = this.iClasse.IGetAllClasse(cnx.connexionGestionEtudiant());
            if (classeList != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", classeList);

            } else {
                response.put("message", "impossible d'afficher.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "impossible d'afficher.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible d'afficher.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible d'afficher.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }
}
