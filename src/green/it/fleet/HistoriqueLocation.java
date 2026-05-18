/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package green.it.fleet;

/**
 *
 * @author sohan
 */
public class HistoriqueLocation {
    private String dateHeureDebut;
    private String dateHeureFin;
    private int batterieConsommee;

    public HistoriqueLocation(String dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = null;
        this.batterieConsommee = 0;
    }

    public void terminer(String dateHeureFin, int batterieConsommee) {
        this.dateHeureFin = dateHeureFin;
        this.batterieConsommee = batterieConsommee;
    }

    public void afficher() {
        String fin = (dateHeureFin != null) ? dateHeureFin : "En cours";
        System.out.println("  Debut: " + dateHeureDebut
            + " | Fin: " + fin
            + " | Batterie consommee: " + batterieConsommee + "%");
    }
}