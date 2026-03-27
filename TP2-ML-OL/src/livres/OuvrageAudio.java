package livres;

import java.time.LocalDate;

public class OuvrageAudio extends Ouvrage{

    public enum FormatAudio {
        NUMERIQUE, ANALOGIQUE
    }
    private int durerMinutes;
    private FormatAudio formatAudio;

    public OuvrageAudio(String titre, Auteur auteur, Format type, LocalDate date, int nombreExemplaires, int durerMinutes, FormatAudio formatAudio) {
        super(titre, auteur, type, date, nombreExemplaires);
        this.durerMinutes = durerMinutes;
        this.formatAudio = formatAudio;
    }
    public OuvrageAudio(String titre, Auteur auteur, Format type) {
        super(titre, auteur, type);
        }

    public FormatAudio getFormatAudio() {
        return formatAudio;
    }

    public void setFormatAudio(FormatAudio formatAudio) {
        this.formatAudio = formatAudio;
    }
    @Override
    public String toString() {
        return super.toString() + "nombre de minutes" + durerMinutes + "format audio" + formatAudio;
    }
}
