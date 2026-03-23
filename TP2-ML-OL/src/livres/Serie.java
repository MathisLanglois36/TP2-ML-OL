/**
 * Auteur : Mathis Langlois
 */

package livres;

import java.util.ArrayList;
import java.util.List;

public class Serie {

    private String nom;
    private List <Ouvrage> ouvrages;


    public Serie(String nom) {
        this.nom = nom;
        this.ouvrages = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }
    public void ajouterOuvrage(Ouvrage ouvrage) {
        if (ouvrage != null) {
            ouvrages.add(ouvrage);
        } else {
            System.out.println("Un ouvrage valide doit être spécifié");
        }
    }

    public boolean retirerOuvrage(Ouvrage ouvrage) {
        return ouvrages.remove(ouvrage);
    }

    @Override
    public String toString() {
        return "Série : " + nom + " (" + ouvrages.size() + " ouvrage(s)";
    }
}
