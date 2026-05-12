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
}

    // Getters et Setters de base
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
    
    public int getCapaciteBatterie() {
        return capaciteBatterie;
    }
    
    public double getAutonomieKm() {
        return (capaciteBatterie * niveauBatterie / 100) / 5;
    }
    public boolean isEstLoue() { return estLoue; }
    public void setEstLoue(boolean estLoue) { this.estLoue = estLoue; }

    public void afficherInfos() {
        String statut = estLoue ? "Loué" : "Disponible";
        System.out.println("Velo " + modele + " | Batterie: " + niveauBatterie + "%" + " | Autonomie : " + getAutonomieKm() + "Km" + "| Statut: " + statut);
    }
}
