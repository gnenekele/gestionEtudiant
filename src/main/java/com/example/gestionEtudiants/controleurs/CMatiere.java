package com.example.gestionEtudiants.controleurs;
import com.example.gestionEtudiants.interfaces.IMatiere;
import com.example.gestionEtudiants.modeles.MMatiere;
import com.example.gestionEtudiants.services.Connexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/gestionEtudiants")

public class CMatiere {

    @Autowired
    private Connexion cnx;

    @Autowired
    private IMatiere iMatiere;




    @RequestMapping(value = "/aadMatiere", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadMatiere(@RequestBody MMatiere matiere) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MMatiere matiere1 = new MMatiere();

        try {
            matiere1 = this.iMatiere.IaadMatiere(cnx.connexionGestionEtudiant(), matiere);
            if (matiere1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", matiere1);

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


    @RequestMapping(value = "/deleteMatiere", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteMatiere(@RequestBody MMatiere matiere) throws SQLException {
        MMatiere matiere1 = new MMatiere();
        Map<String, Object> response = new HashMap<>();

        try {
            matiere1 = this.iMatiere.IdeleteMatiere(cnx.connexionGestionEtudiant(),matiere );
            if (matiere1 != null) {
                response.put("message", "opperation effetuer.");
                response.put("code", 200);
                response.put("data", matiere1);

            } else {
                response.put("message", "impossible supprimer.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "impossible supprimer.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible supprimer.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible supprimer.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }
    @RequestMapping(value = "/getMateriel", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getMateriel() {
        List<MMatiere> matiereList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();

        try {
            matiereList = this.iMatiere.IGetAllMatiere(cnx.connexionGestionEtudiant());
            if (!matiereList.isEmpty()) {
                response.put("message", " affichage des info.");
                response.put("code", 200);
                response.put("data", matiereList);

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
