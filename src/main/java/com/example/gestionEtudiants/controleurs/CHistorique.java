package com.example.gestionEtudiants.controleurs;
import com.example.gestionEtudiants.interfaces.IHistorique;
import com.example.gestionEtudiants.modeles.MEtudiant;
import com.example.gestionEtudiants.modeles.MHistorique;
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

public class CHistorique {

        @Autowired
        private Connexion cnx;

        @Autowired
        private final IHistorique iHistorique;

        public CHistorique(IHistorique iHistorique) {
            this.iHistorique = iHistorique;
        }


    @RequestMapping(value = "/aadHistorique", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadHistorique(@RequestBody MHistorique historique) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MHistorique historique1 = new MHistorique();

        try {historique1 = this.iHistorique.IaadHistorique(cnx.connexionGestionEtudiant(), historique);
            if (historique1 != null) {
                response.put("message", "enregistrement effectue .");
                response.put("code", 200);
                response.put("data", historique1);

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



//    @RequestMapping(value = "/getAllHistByMatEtud", method = RequestMethod.POST, produces = {"application/json"})
//        private Map<String, Object> getAllHistByMatEtud(@RequestBody MHistorique historique) throws SQLException {
//            List<MHistorique> historiqueList = new ArrayList<>();
//            Map<String, String> message = new HashMap<>();
//            Map<String, Object> response = new HashMap<>();
//
//            try {
//                historiqueList = this.iHistorique.IGetAllHistByMatEtud(cnx.connexionGestionEtudiant(), historique);
//                if (!historiqueList.isEmpty()) {
//                    response.put("message", " info afficher.");
//
//                } else {
//                    response.put("message", "impossible d'enregistrer.");
//                    response.put("code", 300);
//                }
//
//            } catch (SQLException e) {
//                response.put("message", "impossible .");
//                response.put("code", 300);
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                response.put("message", "impossible .");
//                response.put("code", 300);
//                e.printStackTrace();
//            } catch (Exception e) {
//                response.put("message", "impossible .");
//                response.put("code", 300);
//                e.printStackTrace();
//            }
//
//            return response;
//        }

    }
