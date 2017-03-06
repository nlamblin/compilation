/*
 * analyseur lexical du langage exemple-expr:
 * (voir support de cours CUP)
 *
 * auteur : azim.roussanaly@univ-lorraine.fr
 * (c) 2013
 */

package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;

%%

/* options */
%line
%public
%cup

/* macros */
SEP     =   [ \t]
NUM     =   [0-9]+
FIN     =   \r|\n|\r\n


%%

/* regles */

"+"         { return new Symbol(sym.ADD);}
"*"         { return new Symbol(sym.MUL);}
"("         { return new Symbol(sym.PO);}
")"         { return new Symbol(sym.PF);}
{NUM}       { return new Symbol(sym.NUM);}
{SEP}       { ; }
{FIN}		{ return new Symbol(sym.EOF);}

