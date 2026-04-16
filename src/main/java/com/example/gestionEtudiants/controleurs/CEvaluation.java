package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IEvaluation;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MEvaluation;
import com.example.gestionEtudiants.services.Connexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping(value = "/gestionEtudiants")
@RestController
public class CEvaluation {
    @Autowired
    private Connexion cnx;
    @Autowired
    public  IEvaluation iEvaluation;


    @RequestMapping(value = "/aadEvaluation", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadEvaluation(@RequestBody MEvaluation evaluation) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEvaluation evaluation1 = new MEvaluation();

        try {
            evaluation1 = this.iEvaluation.IaadEvaluation(cnx.connexionGestionEtudiant(), evaluation);
            if (evaluation1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", evaluation1);

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

    @RequestMapping(value = "/deleteEvaluation", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteEvaluation(@RequestBody MEvaluation evaluation) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEvaluation evaluation1 = new MEvaluation();

        try {
            evaluation1 = this.iEvaluation.IdeleteEvaluation(cnx.connexionGestionEtudiant(), evaluation);
            if (evaluation1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", evaluation1);

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
    @RequestMapping(value = "/getEvaluation", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getEvaluation() {
        List<MEvaluation> evaluationList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();

        try {

            evaluationList = iEvaluation.IgetEvaluation(cnx.connexionGestionEtudiant());
            if (!evaluationList.isEmpty()) {
                response.put("message", " affichage des info.");
                response.put("code", 200);
                response.put("data", evaluationList);

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

    @RequestMapping(value = "/getEvaluationByMatiere", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> getEvaluationByMatiere(@RequestBody MEvaluation evaluation) throws SQLException {
        List<MEvaluation> getEvaluationByMatiereList = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        Map<String, Object> response = new HashMap<>();

        try {
            getEvaluationByMatiereList = this.iEvaluation.IgetEvaluationByMatiere(cnx.connexionGestionEtudiant(), evaluation);
            if (!getEvaluationByMatiereList.isEmpty()) {
                response.put("message", " info afficher.");
                response.put("code", 200);
                response.put("data", getEvaluationByMatiereList);

            } else {
                response.put("message", "impossible de afficher.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "impossible de afficher.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible de afficher.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible de afficher.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }

}

