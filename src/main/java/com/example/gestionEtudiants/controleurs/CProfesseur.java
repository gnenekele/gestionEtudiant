package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IProfesseur;
import com.example.gestionEtudiants.modeles.MProfesseur;
import com.example.gestionEtudiants.services.Connexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

    @CrossOrigin("*")
    @RestController
    @RequestMapping(value = "/gestionEtudiants")

    public class CProfesseur {

        @Autowired
        private Connexion cnx;

        @Autowired
        private final IProfesseur iProfesseur;

        public CProfesseur(IProfesseur iProfesseur) {
            this.iProfesseur = iProfesseur;
        }


        @RequestMapping(value = "/addProfesseur", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> addProfesseur(@RequestBody MProfesseur professeur) throws SQLException {
            Map<String, Object> response = new HashMap<>();
            MProfesseur professeur1 = new MProfesseur();

            try {professeur1 = this.iProfesseur.IaddProfesseur(cnx.connexionGestionEtudiant(), professeur);
                if (professeur1 != null) {
                    response.put("message", "enregistrement effetuer.");
                    response.put("code", 200);
                    response.put("data", professeur1);

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


        @RequestMapping(value = "/deleteProf", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> deleteProf(@RequestBody MProfesseur professeur) throws SQLException {
            Map<String, Object> response = new HashMap<>();
            MProfesseur professeur1 = new MProfesseur();

            try {
                professeur1 = this.iProfesseur.IdeleteProfesseur(cnx.connexionGestionEtudiant(), professeur);
                if (professeur1 != null) {
                    response.put("message", "opperation effetuer avec succes.");
                    response.put("code", 200);
                    response.put("data", professeur1);

                } else {
                    response.put("message", "opperation impossible.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "opperation impossible.");
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

        @RequestMapping(value = "/getProfByCode", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> getProfByCode(@RequestBody MProfesseur professeur) throws SQLException {
            Map<String, Object> response = new HashMap<>();
            MProfesseur professeur1 = new MProfesseur();

            try {
                professeur1 = this.iProfesseur.IgetProfesseurByCode(cnx.connexionGestionEtudiant(), professeur);
                if (professeur1 != null) {
                    response.put("message", "opperation effetuer avec succes.");
                    response.put("code", 200);
                    response.put("data", professeur1);

                } else {
                    response.put("message", "opperation impossible.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "opperation impossible.");
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

    }
