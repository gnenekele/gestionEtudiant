package com.example.gestionEtudiants.controleurs;
import com.example.gestionEtudiants.interfaces.IPeriode;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import com.example.gestionEtudiants.modeles.MPeriode;
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

public class CPeriode {
    @Autowired
    private  Connexion cnx;

    @Autowired
    private  IPeriode iPeriode;


    @RequestMapping(value = "/aadPeriode", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadPeriode(@RequestBody MPeriode periode) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MPeriode periode1 = new MPeriode();

        try {
            periode1 = this.iPeriode.IaadPeriode(cnx.connexionGestionEtudiant(), periode);
            if (periode1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", periode1);

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

    @RequestMapping(value = "/getAllPeriode", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getAllPeriode() {
        List<MPeriode> periodeList = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();
        try {
            periodeList = this.iPeriode.IGetallPeriode(cnx.connexionGestionEtudiant());
            if (!periodeList.isEmpty()) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", periodeList);

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
}
