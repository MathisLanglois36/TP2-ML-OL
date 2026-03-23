package livres;


public class Pays {
    private String nom;
    private String code;

    public Pays (String nom, String code){
        this.nom = nom;
        setCode(code);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null && code.matches("[A-Z]{3}"))
            this.code = code;
        else{ throw new IllegalArgumentException("Erreur il doit y avoir exacteemnt 3 majuscules")
                ;
        }
    }

}