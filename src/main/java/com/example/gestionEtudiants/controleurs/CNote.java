package com.example.gestionEtudiants.controleurs;

import com.example.gestionEtudiants.interfaces.IClasse;
import com.example.gestionEtudiants.interfaces.INote;
import com.example.gestionEtudiants.interfaces.IPeriode;
import com.example.gestionEtudiants.modeles.MNote;
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

public class CNote {
    @Autowired
    private Connexion cnx;

    @Autowired
    private INote iNote;

    @RequestMapping(value = "/aadNote", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> aadNote(@RequestBody MNote note) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MNote note1 = new MNote();

        try {
            note1 = this.iNote.IaadNote(cnx.connexionGestionEtudiant(),note);
            if (note1 != null) {
                response.put("message", "enregistrement effetuer.");
                response.put("code", 200);
                response.put("data", note1);

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

    @RequestMapping(value = "/getAllNote", method = RequestMethod.GET, produces = {"application/json"})
    private Map<String, Object> getAllNote() {
        List<MNote> noteList= new ArrayList<>();
        Map<String, Object> response = new HashMap<>();
        Map<String, String> message = new HashMap<>();
        try {
            noteList = this.iNote.IgetAllNote(cnx.connexionGestionEtudiant());
            if (!noteList.isEmpty()) {
                response.put("message", "affichage de note.");
                response.put("code", 200);
                response.put("data", noteList);

            } else {
                response.put("message", "impossible d'affiche.");
                response.put("code", 300);
            }

        } catch (SQLException e) {
            response.put("message", "impossible d'affiche.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            response.put("message", "impossible d'affiche.");
            response.put("code", 300);
            e.printStackTrace();
        } catch (Exception e) {
            response.put("message", "impossible d'affiche.");
            response.put("code", 300);
            e.printStackTrace();
        }

        return response;
    }
    @RequestMapping(value = "/deleteNote", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    private Map<String, Object> deleteNote(@RequestBody MNote note) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        MNote note1 = new MNote();

        try {
            note1 = this.iNote.IDelete(cnx.connexionGestionEtudiant(),note);
            if (note1 != null) {
                response.put("message", "suppresion  effetuer.");
                response.put("code", 200);
                response.put("data", note1);

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

}

