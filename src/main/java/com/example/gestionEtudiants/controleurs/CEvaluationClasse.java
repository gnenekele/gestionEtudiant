package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IEtudiant;
import com.example.gestionEtudiants.interfaces.IEvaluationClasse;
import com.example.gestionEtudiants.modeles.MEtudiant;
import com.example.gestionEtudiants.modeles.MEvaluationClasse;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
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

public class CEvaluationClasse {

    @Autowired
    private Connexion cnx;

    @Autowired
    private final IEvaluationClasse iEvaluationClasse;

    public CEvaluationClasse(IEvaluationClasse iEvaluationClasse) {
        this.iEvaluationClasse = iEvaluationClasse;
    }

    @RequestMapping(value = "/aadEvaluationClasse", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadEvaluationClasse(@RequestBody MEvaluationClasse evaluationClasse) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEvaluationClasse evaluationClasse1 = new MEvaluationClasse();

        try {evaluationClasse1 = this.iEvaluationClasse.IaadEvaluationClasse(cnx.connexionGestionEtudiant(), evaluationClasse);
            if (evaluationClasse1 != null) {
                response.put("message", "supprimer .");
                response.put("code", 200);
                response.put("data", evaluationClasse1);

            } else {
                response.put("message", "impossible de supprimer.");
                response.put("code", 300);
            }

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
    @RequestMapping(value = "/getEvaluationClasseByTypClasse", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> getEvaluationClasseByTypClasse(@RequestBody MEvaluationClasse evaluationClasse) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEvaluationClasse evaluationClasse1 = new MEvaluationClasse();

        try {evaluationClasse1 = this.iEvaluationClasse.IgetEvaluationClasseByTypClasse(cnx.connexionGestionEtudiant(), evaluationClasse);
            if (evaluationClasse1 != null) {
                response.put("message", "info afficher .");
                response.put("code", 200);
                response.put("data", evaluationClasse1);

            } else {
                response.put("message", "aucune donnee trouver.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "aucune donnee trouver.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "aucune donnee trouver.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "aucune donnee trouver.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping(value = "/getEvaluationClasse", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getEvaluationClasse(){
        List<MEvaluationClasse> evaluationClasseList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();


        try {evaluationClasseList = this.iEvaluationClasse.IgetEvaluationClasse(cnx.connexionGestionEtudiant());
            if (evaluationClasseList != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", evaluationClasseList);

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
    @RequestMapping(value = "/deleteEvaluationClasse", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteEvaluationClasse(@RequestBody MEvaluationClasse evaluationClasse) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEvaluationClasse evaluationClasse1 = new MEvaluationClasse();

        try {evaluationClasse1 = this.iEvaluationClasse.IdeleteEvaluationClasse(cnx.connexionGestionEtudiant(), evaluationClasse);
            if (evaluationClasse1 != null) {
                response.put("message", "supprimer .");
                response.put("code", 200);
                response.put("data", evaluationClasse1);

            } else {
                response.put("message", "impossible de supprimer.");
                response.put("code", 300);
            }

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

    @RequestMapping(value = "/getNoteByEtudiant", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> getNoteByEtudiant(@RequestBody MEvaluationClasse evaluationClasse) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEvaluationClasse evaluationClasse1 = new MEvaluationClasse();

        try {evaluationClasse1 = this.iEvaluationClasse.IgetNoteByEtudiant(cnx.connexionGestionEtudiant(), evaluationClasse);
            if (evaluationClasse1 != null) {
                response.put("message", "getnote .");
                response.put("code", 200);
                response.put("data", evaluationClasse1);

            } else {
                response.put("message", "aucune donnee trouver.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "aucune donnee trouver.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "iaucune donnee trouver.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "aucune donnee trouver.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }

}
