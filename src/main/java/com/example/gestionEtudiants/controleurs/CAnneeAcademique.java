package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IAnneeAcademique;
import com.example.gestionEtudiants.interfaces.IClasse;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MClasse;
import com.example.gestionEtudiants.services.Connexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/gestionEtudiants")

public class CAnneeAcademique {
    @Autowired
    private Connexion cnx;

    @Autowired
    private final IAnneeAcademique iAnneeAcademique;

    public CAnneeAcademique(IAnneeAcademique iAnneeAcademique) {
        this.iAnneeAcademique = iAnneeAcademique;
    }


    @PostMapping(value = "/aadAnneeAcademique", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> aadAnneeAcademique(@RequestBody MAnneeacademique anneeacademique)
            throws Exception {

        MAnneeacademique created = iAnneeAcademique.IAadAnneeAcademique(
                cnx.connexionGestionEtudiant(),
                anneeacademique
        );

        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "enregistrement effectué.");
        response.put("data", created);

        return ResponseEntity.ok(response);
    }

//    @RequestMapping(value = "/updateAnneeAcademique", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
//    private Map<String, Object> updateAnneeAcademique(@RequestBody MAnneeacademique anneeacademique) throws SQLException {
//        Map<String, Object> response = new HashMap<>();
//        MAnneeacademique anneeacademique1 = new MAnneeacademique();
//
//        try {
//            anneeacademique1 = this.iAnneeAcademique.IAadAnneeAcademique(cnx.connexionGestionEtudiant(), anneeacademique);
//            if (anneeacademique1 != null) {
//                response.put("message", "modification effetuer.");
//                response.put("code", 200);
//                response.put("data", anneeacademique1);
//
//            } else {
//                response.put("message", "impossible de modifier.");
//                response.put("code", 300);
//            }
//
//        } catch (SQLException e) {
//            response.put("message", "impossible de modifier.");
//            response.put("code", 300);
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            response.put("message", "impossible de modifier.");
//            response.put("code", 300);
//            e.printStackTrace();
//        } catch (Exception e) {
//            response.put("message", "impossible de modifier.");
//            response.put("code", 300);
//            e.printStackTrace();
//        }
//
//        return response;
//    }
//
//
//    @RequestMapping(value = "/deleteAnneeAcademique", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
//    private Map<String, Object> deleteAnneeAcademique(@RequestBody MAnneeacademique anneeacademique) throws SQLException {
//        MAnneeacademique anneeacademique1 = new MAnneeacademique();
//        Map<String, Object> response = new HashMap<>();
//
//
//        try {
//            anneeacademique1 = this.iAnneeAcademique.IDeleteAnneeAcademique(cnx.connexionGestionEtudiant(),anneeacademique );
//            if (anneeacademique1 != null) {
//                if (anneeacademique1 != null) {
//                    response.put("message", "suppression effetuer.");
//                    response.put("code", 200);
//                    response.put("data", anneeacademique1);
//
//                } else {
//                    response.put("message", "impossible de supprimer.");
//                    response.put("code", 300);
//                }
//                if (anneeacademique1.isIsdelete() == true){
//                    response.put("message", "annee academique inconnu.");
//                    response.put("code", 300);
//                    response.put("data", anneeacademique1);
//                }  else {
//                    response.put("message", "impossible de supprimer.");
//                    response.put("code", 300);
//                }response.put("code", 300);
//            }
//
//        } catch (SQLException e) {
//            response.put("message", "impossible d'enregistrer.");
//            response.put("code", 300);
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            response.put("message", "impossible d'enregistrer.");
//            response.put("code", 300);
//            e.printStackTrace();
//        } catch (Exception e) {
//            response.put("message", "impossible d'enregistrer.");
//            response.put("code", 300);
//            e.printStackTrace();
//        }
//
//        return response;
//    }
//
//
//
//
//
//    @RequestMapping(value = "/getAnneeAcademique", method = RequestMethod.GET, produces = {"application/json"})
//    private Map<String, Object> getAnneeAcademique() {
//        List<MAnneeacademique> anneeacademiqueList = new ArrayList<>();
//        Map<String, Object> response = new HashMap<>();
//        Map<String, String> message = new HashMap<>();
//
//        try {
//
//            anneeacademiqueList = iAnneeAcademique.IGetAnneeAcademique(cnx.connexionGestionEtudiant());
//            if (!anneeacademiqueList.isEmpty()) {
//                response.put("message", "Info sur les annees academique.");
//                response.put("code", 200);
//                response.put("data", anneeacademiqueList);
//
//            } else {
//                response.put("message", "impossible d'afficher.");
//                response.put("code", 300);
//            }
//
//        } catch (SQLException e) {
//            response.put("message", "impossible d'afficher.");
//            response.put("code", 300);
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            response.put("message", "impossible d'afficher.");
//            response.put("code", 300);
//            e.printStackTrace();
//        } catch (Exception e) {
//            response.put("message", "impossible d'afficher.");
//            response.put("code", 300);
//            e.printStackTrace();
//        }
//
//        return response;
//    }

}
