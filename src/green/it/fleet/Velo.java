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
public class Velo {
    private String modele;
    private int niveauBatterie;
    private boolean estLoue;
    private int capaciteBatterie;
    private HistoriqueLocation[] historique;
    private int nbLocations;
    private int batterieDebutLocation;

    public Velo(String modele, int capaciteBatterie) {
        this.modele = modele;
        this.niveauBatterie = 100;
        this.estLoue = false;
        if (capaciteBatterie < 300) {
            this.capaciteBatterie = 300;
        } else if (capaciteBatterie > 1000) {
            this.capaciteBatterie = 1000;
        } else {
            this.capaciteBatterie = capaciteBatterie;
        }
        this.historique = new HistoriqueLocation[100];
        this.nbLocations = 0;
    }

    public String getModele() { return modele; }

    public int getNiveauBatterie() { return niveauBatterie; }
    public void setNiveauBatterie(int niveauBatterie) {
        if (niveauBatterie < 0) {
            this.niveauBatterie = 0;
        } else if (niveauBatterie > 100) {
            this.niveauBatterie = 100;
        } else {
            this.niveauBatterie = niveauBatterie;
        }
    }

    public boolean isEstLoue() { return estLoue; }
    public void setEstLoue(boolean estLoue) { this.estLoue = estLoue; }

    public int getCapaciteBatterie() { return capaciteBatterie; }

    public double getAutonomieKm() {
        return (capaciteBatterie * niveauBatterie / 100.0) / 5.0;
    }

    public void louer() {
        this.estLoue = true;
        this.batterieDebutLocation = this.niveauBatterie;
        historique[nbLocations] = new HistoriqueLocation(new java.util.Date().toString());
    }

    public void retourner() {
        if (estLoue && historique[nbLocations] != null) {
            int consommee = batterieDebutLocation - this.niveauBatterie;
            historique[nbLocations].terminer(new java.util.Date().toString(), consommee);
            nbLocations++;
        }
        this.estLoue = false;
    }

    public void afficherHistorique() {
        System.out.println("Historique des locations de " + modele + " :");
        if (nbLocations == 0) {
            System.out.println("  Aucune location.");
        } else {
            for (int i = 0; i < nbLocations; i++) {
                historique[i].afficher();
            }
        }
    }

    public void afficherInfos() {
        String statut = estLoue ? "Loué" : "Disponible";
        System.out.println("Velo " + modele
            + " | Batterie: " + niveauBatterie + "%"
            + " | Autonomie : " + getAutonomieKm() + "Km"
            + " | Statut: " + statut);
    }
}

