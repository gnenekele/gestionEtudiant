package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IEnseigner;
import com.example.gestionEtudiants.modeles.MEnseigner;
import com.example.gestionEtudiants.modeles.MInfoProf;
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

    public class CEnseigner {

        @Autowired
        private Connexion cnx;

        @Autowired
        private  IEnseigner iEnseigner;



        @RequestMapping(value = "/infoProfParMat/{matriculeProf}", method = RequestMethod.GET,produces = {"application/json"})
        private Map<String, Object> infoProfParMat(@PathVariable("matriculeProf") String matriculeProf) throws SQLException {
             Map<String, Object> response = new HashMap<>();
                    List<MInfoProf> infoProfList = new ArrayList<>();

                    try {infoProfList = this.iEnseigner.IinfoProf(cnx.connexionGestionEtudiant(), matriculeProf);
                        if (!infoProfList.isEmpty()) {
                            response.put("message", "enregistrement effetuer.");
                            response.put("code", 200);
                            response.put("data", infoProfList);

                        }
//            Map<String, Object> response = new HashMap<>();
//            MInfoProf infoProf1 = new MInfoProf();

//            try {
//                infoProf1 = this.iEnseigner.IinfoProf(cnx.connexionGestionEtudiant(), matriculeProf);
//                if (infoProf1 != null) {
//                    response.put("message", "info sur professeur.");
//                    response.put("code", 200);
//                    response.put("data", infoProf1);
//
//                } else {
//                    response.put("message", "professeur n'existe pas.");
//                    response.put("code", 300);
//                }

            } catch (SQLException e) {
                response.put("message", "professeur n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "professeur n'existe pas..");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "professeur n'existe pas.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }
        @RequestMapping(value = "/addEnseigner", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> addEnseigner(@RequestBody MEnseigner enseigner) throws SQLException {


            Map<String, Object> response = new HashMap<>();
            MEnseigner enseigner1 = new MEnseigner();

            try {
                enseigner1 = this.iEnseigner.IaddEnseigner(cnx.connexionGestionEtudiant(), enseigner);
                if (enseigner1 != null) {
                    response.put("message", "enregistrement effetuer.");
                    response.put("code", 200);
                    response.put("data", enseigner1);

                } else {
                    response.put("message", "impossible d'enregistrer.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "impossible d'enregistrer..");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }


        @RequestMapping(value = "/updateEnseigner", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> updateEnseigner(@RequestBody MEnseigner enseigner) throws SQLException {


            Map<String, Object> response = new HashMap<>();
            MEnseigner enseigner1 = new MEnseigner();

            try {
                enseigner1 = this.iEnseigner.IUpdateEnseigner(cnx.connexionGestionEtudiant(), enseigner);
                if (enseigner1 != null) {
                    response.put("message", "modification effetuer.");
                    response.put("code", 200);
                    response.put("data", enseigner1);

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


        @RequestMapping(value = "/deleteEnseigner", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
        private Map<String, Object> deleteEnseigner(@RequestBody MEnseigner enseigner) throws SQLException {


            Map<String, Object> response = new HashMap<>();
            MEnseigner enseigner1 = new MEnseigner();

            try {
                enseigner1 = this.iEnseigner.IDeleteEnseigner(cnx.connexionGestionEtudiant(), enseigner);
                if (enseigner1 != null) {
                    response.put("message", "enregistrement effetuer.");
                    response.put("code", 200);
                    response.put("data", enseigner1);

                } else {
                    response.put("message", "impossible d'enregistrer.");
                    response.put("code", 300);
                }
                if (enseigner1.isIsdelete() == true){
                    response.put("message", "l'Enseigner  n'exixte pas.");
                    response.put("code", 200);
                    response.put("data", enseigner1);
                }  else {
                    response.put("message", "impossible de supprimer.");
                    response.put("code", 300);
                }

            } catch (SQLException e) {
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                response.put("message", "impossible d'enregistrer..");
                response.put("code", 300);
                e.printStackTrace();
            } catch (Exception e) {
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }
        @RequestMapping(value = "/getAllEnseigner", method = RequestMethod.GET, produces = {"application/json"})
        private Map<String, Object> getAllEnseigner(){

            Map<String, String> message = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
            List<MEnseigner>  EnseignerList = new ArrayList<>();

            try {
                EnseignerList = this.iEnseigner.IGetAllEnseigner(cnx.connexionGestionEtudiant());
                if (EnseignerList != null) {
                    response.put("message", "Infos Enseigner.");
                    response.put("code", 200);
                    response.put("data", EnseignerList);

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
                response.put("message", "impossible d'enregistrer.");
                response.put("code", 300);
                e.printStackTrace();
            }

            return response;
        }
}
