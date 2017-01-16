package plic ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

/** Série de commandes pour compiler la grammaire
 * 
 * Se mettre sous analyse
 * java  -jar  /opt/depot/projetToucan/java-cup-11a.jar  -parser  AnalyseurSyntaxique  -symbols CodesLexicaux  Grammaire.cup
 * java  -jar  /opt/depot/projetToucan/jflex-1.6.1.jar  AnalyseurLexical.jflex
 * 
 * cd ..
 * cd ..
 * javac  -cp  /opt/depot/projetToucan/java-cup-11a.jar:.  plic/analyse/*.java
 * javac -cp /opt/depot/projetToucan/java-cup-11a.jar:. plic/Plic.java
 * 
 * java  -cp  /opt/depot/projetToucan/java-cup-11a.jar:.  plic.Plic.java  fichier
 *
 */

public class Plic {
    
    public Plic(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            System.err.println("expression stockée dans l'arbre : " + arbre);
            
            
            //Analyse sémantique + génération de code
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Plic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar plic.jar <fichierSource.plic>") ;
            System.exit(1) ;
        }
        new Plic(args[0]) ;
    }
    
}
