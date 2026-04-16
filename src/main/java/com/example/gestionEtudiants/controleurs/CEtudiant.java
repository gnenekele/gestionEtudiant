package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IEtudiant;

import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MEtudiant;

import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import com.example.gestionEtudiants.modeles.MProfesseur;
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

public class CEtudiant {

    @Autowired
    private Connexion cnx;

    @Autowired
    private final IEtudiant iEtudiant;

    public CEtudiant(IEtudiant iEtudiant) {
        this.iEtudiant = iEtudiant;
    }


    @RequestMapping(value = "/addEtudiant", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> addEtudiant(@RequestBody MEtudiant etudiant) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEtudiant etudiant1 = new MEtudiant();

        try {etudiant1 = this.iEtudiant.IaddEtudiant(cnx.connexionGestionEtudiant(), etudiant);
            if (etudiant1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", etudiant1);

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
    @RequestMapping(value = "/updateEtudiant", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> updateEtudiant(@RequestBody MEtudiant etudiant) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEtudiant etudiant1 = new MEtudiant();

        try {etudiant1 = this.iEtudiant.IUpdateEtudiant(cnx.connexionGestionEtudiant(), etudiant);
            if (etudiant1 != null) {
                response.put("message", "modification effetuer.");
                response.put("code", 200);
                response.put("data", etudiant1);

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
    @RequestMapping(value ="/GetAllEtudiantByCode/{code}", method =  RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> GetAllEtudiantByCode(@PathVariable("code") String code) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        List<MInfoEtudiant> infoEtudiantList = new ArrayList<>();

        try {infoEtudiantList = this.iEtudiant.IGetAllEtudiantByCode(cnx.connexionGestionEtudiant(), code);
            if (!infoEtudiantList.isEmpty()) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", infoEtudiantList);

            } else {
                response.put("message", "opperation impossible.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "opperation impossibler.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "opperation impossible.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "opperation impossible.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping(value = "/getAllEtudiant", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getAllEtudiant(){
        List<MEtudiant> etudiantList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();


        try {etudiantList = this.iEtudiant.IGetAllEtudiant(cnx.connexionGestionEtudiant());
            if (etudiantList != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", etudiantList);

            } else {
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300
                );
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

    @RequestMapping(value = "/deleteEtudiant", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteEtudiant(@RequestBody MEtudiant etudiant) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MEtudiant etudiant1 = new MEtudiant();

        try {etudiant1 = this.iEtudiant.IdeleteEtudiant(cnx.connexionGestionEtudiant(), etudiant);
            if (etudiant1 != null && etudiant1.isIsdelete() == true) {
                response.put("message", "supprimer .");
                response.put("code", 300);
                response.put("data", etudiant1);

            }  else {
                response.put("message", " etudiant inconnu.");
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

}


