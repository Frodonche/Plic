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
            
            /* Verification de l'arbre */
            arbre.verifier();
            System.out.println("COMPILATION OK");
            
            /* Recuperation du code MIPS */
            StringBuilder codeMIPS = new StringBuilder();
            
            codeMIPS.append("move $s7, $sp \n");
            codeMIPS.append("addi $sp, $sp, "+ (Tds.getInstance().getTailleZoneDesVariables()*(-4))+"\n");
            codeMIPS.append("main :\n");
            codeMIPS.append(arbre.toMIPS());
            codeMIPS.append("\nend :\n");
            codeMIPS.append("move $v1, $v0\t\n");
            codeMIPS.append("li $v0, 10\t\n");
            codeMIPS.append("syscall\n");
            
            /* Determine le nom de fichier ou enregistrer le code MIPS */
            StringBuilder fichierMIPS = new StringBuilder();
            int suffixe;
            
            suffixe = fichier.lastIndexOf('.');
            
            if (suffixe < 1) {
            	fichierMIPS.append(fichier);
            }
            else {
            	fichierMIPS.append(fichier.substring(0, suffixe));
            }
            
            fichierMIPS.append(".mips");
            
            /* Ecriture du code MIPS */
            FileWriter fw;
            
            try {
            	fw = new FileWriter(fichierMIPS.toString());
                fw.write(codeMIPS.toString());
                fw.close();           
            }
            catch (IOException e) { 
            	System.err.println("Impossible d'ecrire le code MIPS dans un fichier");
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
