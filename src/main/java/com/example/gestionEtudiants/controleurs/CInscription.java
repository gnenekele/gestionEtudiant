package com.example.gestionEtudiants.controleurs;
import com.example.gestionEtudiants.interfaces.IInscription;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MInfoEtudiant;
import com.example.gestionEtudiants.modeles.MInscription;
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

    public class CInscription {

        @Autowired
        private Connexion cnx;

        @Autowired
        private final IInscription iInscription;

        public CInscription(IInscription iInscription) {
            this.iInscription = iInscription;
        }


        @RequestMapping(value = "/addInscription", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> addInscription(@RequestBody MInscription inscription) throws SQLException {


            Map<String, Object> response = new HashMap<>();
            MInscription inscription1 = new MInscription();

            try {
                inscription1 = this.iInscription.IaddInscription(cnx.connexionGestionEtudiant(), inscription);
                if (inscription1 != null) {
                    response.put("message", "inscription effetuer.");
                    response.put("code", 200);
                    response.put("data", inscription1);

                } else {
                    response.put("message", "impossible d'effetuer inscription.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }

        @RequestMapping(value = "/deleteInscription", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> deleteInscription(@RequestBody MInscription inscription) throws SQLException {
            Map<String, Object> response = new HashMap<>();
            MInscription inscription1 = new MInscription();

            try {
                inscription1 = this.iInscription.IdeleteInscription(cnx.connexionGestionEtudiant(), inscription);
                if (inscription1 != null) {
                    response.put("message", "inscription effetuer.");
                    response.put("code", 200);
                    response.put("data", inscription1);

                } else {
                    response.put("message", "impossible d'effetuer inscription.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }
        @RequestMapping(value = "/getAllInscription", method = RequestMethod.GET,  produces = {"application/json"})
        private Map<String, Object> getAllInscription(){
            Map<String, String> message = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
           List<MInscription>  inscriptionList = new ArrayList<>();

            try {
                inscriptionList = this.iInscription.IgetAllInscription(cnx.connexionGestionEtudiant());
                if (inscriptionList != null) {
                    response.put("message", "inscription effetuer.");
                    response.put("code", 200);
                    response.put("data", inscriptionList);

                } else {
                    response.put("message", "impossible d'effetuer inscription.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "impossible d'effetuer inscription.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }

        @RequestMapping(value = "/infoEtudiant", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> infoEtudiant(@RequestBody MInfoEtudiant infoEtudiant) throws SQLException {

            Map<String, Object> response = new HashMap<>();
            MInfoEtudiant inscription1 = new MInfoEtudiant();

            try {
                inscription1 = this.iInscription.IInfoEtudiant(cnx.connexionGestionEtudiant(), infoEtudiant);
                if (inscription1!= null) {
                    response.put("message", " info sur etudiant.");
                    response.put("code", 200);
                    response.put("data", inscription1);

                } else {
                    response.put("message", " etudiant n'existe pas.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "etudiant n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "etudiant n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "etudiant n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }

        @RequestMapping(value = "/getlisteByClasse", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> getlisteByClasse(@RequestBody MInscription inscription) throws SQLException {

            Map<String, Object> response = new HashMap<>();
            MInscription inscription1 = new MInscription();

            try {
                inscription1 = this.iInscription.IgetlisteByClasse(cnx.connexionGestionEtudiant(), inscription);
                if (inscription1!= null) {
                    response.put("message", " info sur etudiant.");
                    response.put("code", 200);
                    response.put("data", inscription1);

                } else {
                    response.put("message", " etudiant n'existe pas.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "etudiant n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "etudiant n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "etudiant n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }



    }
