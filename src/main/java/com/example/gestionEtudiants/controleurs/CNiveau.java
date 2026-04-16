package com.example.gestionEtudiants.controleurs;
import com.example.gestionEtudiants.interfaces.INiveau;
import com.example.gestionEtudiants.modeles.MNiveau;
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
@RequestMapping(value ="/gestionEtudiants" )

public class CNiveau {

    @Autowired
    private Connexion cnx;

    @Autowired
    private INiveau iNiveau;



    @RequestMapping(value = "/addNiveau", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> addNiveau(@RequestBody MNiveau niveau) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MNiveau niveau1 = new MNiveau();

        try {
            niveau1 = this.iNiveau.IaddNiveau(cnx.connexionGestionEtudiant(),niveau);
            if (niveau1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", niveau1);

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


    @RequestMapping(value = "/deleteNiveau", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteNiveau(@RequestBody MNiveau niveau) throws SQLException {
        MNiveau niveau1 = new MNiveau();
        Map<String, Object> response = new HashMap<>();


        try {
            niveau1 = this.iNiveau.IdeleteNiveau(cnx.connexionGestionEtudiant(),niveau);
            if (niveau1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", niveau1);

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

    @RequestMapping(value = "/getAllNiveau", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getAllNiveau(){
        MNiveau niveau1 = new MNiveau();
        Map<String, Object> response = new HashMap<>();
        List<MNiveau> ListNiveau = new ArrayList<>();

        try {
         ListNiveau = this.iNiveau.IgetAllNiveau(cnx.connexionGestionEtudiant());
            if (!ListNiveau.isEmpty()) {
                response.put("data", ListNiveau);
                response.put("message","affichage des info.");
                response.put("code",200);
                response.put("data", ListNiveau);
            }
            else{
                response.put("message","impossible d'afficher.");
                response.put("code",300);
            }
        } catch (SQLException e) {
            response.put("message","impossible d'afficher.");
            response.put("code",300);
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            response.put("message","impossible d'afficher.");
            response.put("code",300);
            e.printStackTrace();
        }
        catch (Exception e) {
            response.put("message","impossible d'enregistrer.");
            response.put("code",300);
            e.printStackTrace();
        }
        return response;

    }
}

