package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbole symbol(int type) {
	return new Symbole(type, yyline, yycolumn) ;
  }

  private Symbole symbol(int type, Object value) {
	return new Symbole(type, yyline, yycolumn, value) ;
  }

%}

csteE = [0-9]+
csteB = "vrai" | "faux"

/*plic1*/

csteChaine = [-+*/!"#$%&'(),.:;<=>?@[\]^_`{|}~ \t\n\x0B\f\r_A-Za-z0-9]*
idf = [A-Za-z][_A-Za-z0-9]*

/*fin plic1*/


finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%%
"//"                { return symbol(CodesLexicaux.DOUBLESLASH); }

"+"                	{ return symbol(CodesLexicaux.PLUS); }
"-"                	{ return symbol(CodesLexicaux.MOINS); }
"*"                	{ return symbol(CodesLexicaux.MULT); }
"/"                	{ return symbol(CodesLexicaux.DIV); }

"=="                    { return symbol(CodesLexicaux.EGALEGAL); }
"!="                    { return symbol(CodesLexicaux.DIFF); }
"<"                	{ return symbol(CodesLexicaux.INF); }
">"                	{ return symbol(CodesLexicaux.SUP); }

"et"                	{ return symbol(CodesLexicaux.ET); }
"ou"                	{ return symbol(CodesLexicaux.OU); }
"non"                	{ return symbol(CodesLexicaux.NON); }

"("                	{ return symbol(CodesLexicaux.PAROUV); }
")"                	{ return symbol(CodesLexicaux.PARFER); }

{csteE}      	        { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	        { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }

/*plic1*/

";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }
"="                	{ return symbol(CodesLexicaux.EGAL); }

"classe"                	{ return symbol(CodesLexicaux.CLASS); }
"fin"                	{ return symbol(CodesLexicaux.FIN); }
"privee"                	{ return symbol(CodesLexicaux.PRIVATE); }
"public"                	{ return symbol(CodesLexicaux.PUBLIC); }
"entier"                	{ return symbol(CodesLexicaux.ENTIER); }
"ecrire"                	{ return symbol(CodesLexicaux.WRITE); }


{idf}				{ return symbol(CodesLexicaux.IDF, yytext()) ; }
{csteChaine}        { return symbol(CodesLexicaux.CONSTANTECHAINE, yytext()) ; }
/*fin plic1*/

{espace}                { }

.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
