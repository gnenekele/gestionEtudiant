package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IFiliere;
import com.example.gestionEtudiants.modeles.MFiliere;
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

public class CFilieres {
    @Autowired
    private  Connexion cnx;

    @Autowired
    private  IFiliere iFiliere;


    @RequestMapping(value = "/aadFiliere", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadFiliere(@RequestBody MFiliere filiere) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MFiliere filiere1 = new MFiliere();

        try {
            filiere1 = this.iFiliere.IaddFiliere(cnx.connexionGestionEtudiant(), filiere);
            if (filiere1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", filiere1);
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
    @RequestMapping(value = "/getFiliere", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getFiliere() {
        List<MFiliere> filiereList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();

        try {

            filiereList = iFiliere.IGetAllFiliere(cnx.connexionGestionEtudiant());
            if (!filiereList.isEmpty()) {
                response.put("message", " affichage des info.");
                response.put("code", 200);
                response.put("data", filiereList);

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
