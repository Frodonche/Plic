package plic ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class Plic {
	
    public Plic(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            
            // Est-ce que l'arbre est valide?
            arbre.verifier();
            
            // Affichage de l'arbre (s'il est valide)
            System.out.println("expression stockée dans l'arbre : " + arbre);
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("main :\n");
            sb.append(arbre.toMIPS());
            sb.append("\nend :\n");
            sb.append("move $v1, $v0\t\n");
            sb.append("li $v0, 10\t\n");
            sb.append("syscall\n");
            
            FileWriter fw;
            
            try {
            	fw = new FileWriter("arbre.mips");
                fw.write(sb.toString());
                fw.close();           
            }
            catch (IOException e) { 
            	System.err.println("Impossible d'écrire le code MIPS dans un fichier");
            }
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
