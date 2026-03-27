

package livres;

import java.time.LocalDate;

public class OuvragePapier extends Ouvrage {
    private int nombrePages;

    public OuvragePapier(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int nombrePages) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.nombrePages = nombrePages;
    }
    public OuvragePapier(String titre, Auteur auteur) {
        super(titre, auteur);

    }
    @Override
    public String toString() {
        return super.toString() + "nombre de pages: " + nombrePages;
    }
}
