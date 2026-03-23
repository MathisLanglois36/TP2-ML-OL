package tests;

import java.time.LocalDate;
import java.util.List;

import livres.Ouvrage;
import livres.Auteur;
import livres.Pays;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
    }


    public void testOuvrages() {
        Pays canada = new Pays("Canada", "CAN");
        Pays etatsunis = new Pays("États-Unis", "USA");


        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", canada);
        Auteur john = new Auteur("John", "Smith", etatsunis);

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new Ouvrage("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new Ouvrage(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new Ouvrage("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new Ouvrage("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10);
        System.out.println(livre2);

        livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new Ouvrage("Musique du hasard", new Auteur("Paul", "Auster", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new Ouvrage("Test", new Auteur("A", "B", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new Ouvrage("Test", new Auteur("A", "B", etatsunis), Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre6 = new Ouvrage("Test", new Auteur("A", "B", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new Ouvrage("Test", new Auteur("Z", "B", etatsunis), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Pays France = new Pays("France", "FRA");
        Pays Canada = new Pays("Canada", "CAN");

        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", Canada));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", France));
        System.out.println("Livres de Jacques: " + resultat);
    }
    public void testPays() {
        System.out.println("----- TEST CLASS PAYS -----");

        // Codes valides
        Pays p1 = new Pays("Canada", "CAN");
        Pays p2 = new Pays("Etats-Unis", "USA");

        System.out.println("Pays valide 1: " + p1);
        System.out.println("Pays valide 2: " + p2);

        // Codes invalides
        Pays p3 = new Pays("France", "FR");   // trop court
        Pays p4 = new Pays("Mexique", "mex"); // minuscules
        Pays p5 = new Pays("Allemagne", "DEUT"); // trop long

        System.out.println("Pays invalide 1: " + p3);
        System.out.println("Pays invalide 2: " + p4);
        System.out.println("Pays invalide 3: " + p5);

        // Test equals
        Pays p6 = new Pays("Canada", "CAN");
        System.out.println("Equals pays (doit être true): " + p1.equals(p6));
        System.out.println("Equals pays (doit être false): " + p1.equals(p2));

        // Test avec Auteur
        Auteur auteur = new Auteur("Albertine", "Tremblay", p1);
        System.out.println("Auteur avec pays: " + auteur);
    }
}

