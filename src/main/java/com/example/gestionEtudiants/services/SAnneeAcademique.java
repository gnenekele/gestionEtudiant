package com.example.gestionEtudiants.services;

import com.example.gestionEtudiants.exception.DatabaseException;
import com.example.gestionEtudiants.exception.ValidationException;
import com.example.gestionEtudiants.interfaces.IAnneeAcademique;
import com.example.gestionEtudiants.modeles.MAnneeacademique;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("IAnneeAcademique")
public class SAnneeAcademique implements IAnneeAcademique {

    @Override
    public MAnneeacademique IAadAnneeAcademique(Connection cnx, MAnneeacademique anneeacademique) throws SQLException {
        // ÉTAPE 1 : Vérifier les données AVANT d'aller à la base (inclut anti-désordre)
        validateAnneeAcademique(anneeacademique);

        // 2. APPEL BASE DE DONNÉES
        MAnneeacademique resultat = new MAnneeacademique();
        ResultSet resultSet = null;
        CallableStatement callableStatement = null;

        try {
            callableStatement = cnx.prepareCall("CALL gestionetudiants.addAnneeacademique(?,?)");
            callableStatement.setString("p_annee", anneeacademique.getAnnee());
            callableStatement.setString("p_createdBy", anneeacademique.getCreatedBy());

            boolean hasResults = callableStatement.execute();

            if (hasResults) {
                resultSet = callableStatement.getResultSet();
                if (resultSet.next()) {
                    resultat.setIdAnnee(resultSet.getInt("idAnnee"));
                    resultat.setAnnee(resultSet.getString("annee"));
                    resultat.setCreatedBy(resultSet.getString("createdBy"));
                    resultat.setCreatedOn(resultSet.getDate("createdOn"));
                    resultat.setIsdelete(resultSet.getBoolean("isdelete"));
                }
            }

            // Vérification que l'insertion a marché
            if (resultat.getIdAnnee() == 0) {
                throw new DatabaseException("La création a échoué (aucun ID retourné)");
            }

        } catch (SQLException e) {
            // Transforme SQLException en exception métier
            throw new DatabaseException("Erreur SQL: " + e.getMessage(), e);

        } finally {
            // Fermeture silencieuse
            closeQuietly(resultSet);
            closeQuietly(callableStatement);
            closeQuietly(cnx);
        }

        return resultat;
    }

    // Méthode de validation principale
    private void validateAnneeAcademique(MAnneeacademique annee) {
        Map<String, String> errors = new HashMap<>();

        // Validation champs obligatoires
        if (annee.getAnnee() == null || annee.getAnnee().trim().isEmpty()) {
            errors.put("annee", "L'année est obligatoire");
        } else {
            // Validation format et ordre anti-désordre
            validerFormatAnnee(annee.getAnnee(), errors);
        }

        if (annee.getCreatedBy() == null || annee.getCreatedBy().trim().isEmpty()) {
            errors.put("createdBy", "Le créateur est obligatoire");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException("Données invalides", errors);
        }
    }

    // Validation anti-désordre : empêche 2024-2023, 2023-2025, etc.
    private void validerFormatAnnee(String annee, Map<String, String> errors) {
        // 1. Vérifier le format AAAA-AAAA
        if (!annee.matches("\\d{4}-\\d{4}")) {
            errors.put("annee", "Format invalide. Utilisez: AAAA-AAAA (ex: 2023-2024)");
            return; // Stop ici si format incorrect
        }

        // 2. Extraire les années
        String[] parties = annee.split("-");
        int anneeDebut = Integer.parseInt(parties[0]);
        int anneeFin = Integer.parseInt(parties[1]);

        // 3. ANTI-DÉSORDRE : Vérifier que debut < fin
        if (anneeDebut >= anneeFin) {
            errors.put("annee", "L'année de début doit être antérieure à l'année de fin (ex: 2023-2024, pas 2024-2023)");
            return;
        }

        // 4. Vérifier qu'elles sont consécutives (différence exactement 1)
        if (anneeFin - anneeDebut != 1) {
            errors.put("annee", "Les années doivent être consécutives (ex: 2023-2024, pas 2023-2025 ou 2023-2026)");
            return;
        }

        // 5. Optionnel : Vérifier que ce n'est pas trop dans le futur (max année prochaine)
        int anneeActuelle = LocalDate.now().getYear();
        if (anneeDebut > anneeActuelle + 1) {
            errors.put("annee", "L'année académique ne peut pas dépasser " + (anneeActuelle + 1) + "-" + (anneeActuelle + 2));
        }
    }

    // Helper fermeture
    private void closeQuietly(AutoCloseable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Exception ignored) {}
        }
    }


//    @Override
//    public MAnneeacademique IDeleteAnneeAcademique(Connection cnx, MAnneeacademique anneeacademique) throws SQLException {
//        MAnneeacademique anneeacademique1 = new MAnneeacademique();
//        ResultSet resultSet = null;
//        CallableStatement callableStatement;
//
//        try {
//            callableStatement = cnx.prepareCall("CALL gestionetudiants.deleteAnneeacademique(?,?)");
//            callableStatement.setInt("p_idAnnee",anneeacademique.getIdAnnee());
//            callableStatement.setString("p_isdeletedBy",anneeacademique.getIsdeletedBy());
//            callableStatement.executeUpdate();
//            resultSet = callableStatement.getResultSet();
//
//            while (resultSet.next()) {
//                anneeacademique1.setIdAnnee(resultSet.getInt("idAnnee"));
//                //anneeacademique1.setAnnee(resultSet.getString("annee"));
////                anneeacademique1.setCreatedBy(resultSet.getString("createdBy"));
////                anneeacademique1.setCreatedOn(resultSet.getDate("createdOn"));
//                anneeacademique1.setIsdeletedBy(resultSet.getString("isdeletedBy"));
//                anneeacademique1.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
//                anneeacademique1.setIsdelete(resultSet.getBoolean("isdelete"));
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            cnx.close();
//        }
//        return anneeacademique1;
//    }
//
//    @Override
//    public MAnneeacademique IUpdateAnneeAcademique(Connection cnx, MAnneeacademique anneeacademique) throws SQLException {
//        ResultSet resultSet=null;
//        CallableStatement callableStatement;
//        System.out.println("debut Update anneeAcademiques");
//        MAnneeacademique anneeacademique1=new MAnneeacademique();
//        try{
//            callableStatement= cnx.prepareCall("call gestionetudiants.updateAnnee(?,?,?)");
//            callableStatement.executeUpdate();
//            resultSet=callableStatement.getResultSet();
//            while ((resultSet.next())){
//                MAnneeacademique anneeacademiqueResult = new MAnneeacademique();
//                anneeacademiqueResult.setIdAnnee(resultSet.getInt("idAnnee"));
//                anneeacademiqueResult.setAnnee(resultSet.getString("annee"));
//                anneeacademiqueResult.setModifiedBy(resultSet.getString("modifiedBy"));
//                anneeacademiqueResult.setModifiedOn(resultSet.getDate("modifiedOn"));
//            }
//            resultSet.close();
//        }  catch (SQLException e){
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            cnx.close();
//        }
//        System.out.println("fin Update anneeAcademiques");
//
//        return anneeacademique1;
//        }
//
//
//    @Override
//    public List<MAnneeacademique> IGetAnneeAcademique(Connection cnx) throws SQLException {
//        ResultSet resultSet ;
//        CallableStatement callableStatement;
//        System.out.println("debut Get ALL anneeAcademiques");
//        List<MAnneeacademique> anneeacademiqueArrayList = new ArrayList<>();
//        try {
//            callableStatement = cnx.prepareCall("call gestionetudiants.getAllAnneeAcademique()");
//            callableStatement.executeUpdate();
//            resultSet = callableStatement.getResultSet();
//
//            while(resultSet.next()) {
//                MAnneeacademique anneeacademiqueResult = new MAnneeacademique();
//                anneeacademiqueResult.setIdAnnee(resultSet.getInt("idAnnee"));
//                anneeacademiqueResult.setAnnee(resultSet.getString("annee"));
//                anneeacademiqueResult.setCreatedBy(resultSet.getString("createdBy"));
//                anneeacademiqueResult.setCreatedOn(resultSet.getDate("createdOn"));
//                anneeacademiqueResult.setIsdeletedBy(resultSet.getString("isdeletedBy"));
//                anneeacademiqueResult.setIsdeletedOn(resultSet.getDate("isdeletedOn"));
//                anneeacademiqueResult.setIsdelete(resultSet.getBoolean("isdelete"));
//                anneeacademiqueArrayList.add(anneeacademiqueResult);
//            }
//            resultSet.close();
//        }  catch (SQLException e){
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            cnx.close();
//        }
//        System.out.println("fin Get ALL anneeAcademiques");
//
//        return anneeacademiqueArrayList;
//    }

}



