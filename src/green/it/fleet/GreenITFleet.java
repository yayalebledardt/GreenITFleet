/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.it.fleet;

/**
 *
 * @author MCHAUMES
 */
public class GreenITFleet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Station maStation = new Station("Centre-Ville");

    Velo v1 = new Velo("E-Ride 2000", 200);
    Velo v2 = new Velo("Volt-Bike", 200);

    maStation.ajouterVelo(v1);
    maStation.ajouterVelo(v2);

    maStation.afficherEtatStation();

    // --- Simulation d'une location ---
    v1.louer();                 // Début de location
    v1.setNiveauBatterie(45);   // Batterie après utilisation
    v1.retourner();             // Fin de location

    maStation.afficherEtatStation();

    // --- Affichage de l'historique ---
    v1.afficherHistorique();
}
}
    

