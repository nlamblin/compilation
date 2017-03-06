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
SEP  	   	=   [ \t]
NUM		    =   [0-9]+
FIN		    =   \r|\n|\r\n
COMP		= 	[==]
SUP_EGAL 	=	[>=]
INF_EGAL	= 	[<=]
DIFF		=	[!=]

%%

/* regles */

"+"         { return new Symbol(sym.ADD);}
"*"         { return new Symbol(sym.MUL);}
"-"			{ return new Symbol(sym.SOUS);}
"/"			{ return new Symbol(sym.DIV);}

"="			{ return new Symbol(sym.AFFECT);}
">"			{ return new Symbol(sym.SUP);}
"<"			{ return new Symbol(sym.INF);}
{COMP}		{ return new Symbol(sym.COMP);}
{SUP_EGAL}	{ return new Symbol(sym.SUP_EGAL);}
{INF_EGAL}	{ return new Symbol(sym.INF_EGAL);}
{DIFF}		{ return new Symbol(sym.DIFF);}


"("         { return new Symbol(sym.PO);}
")"         { return new Symbol(sym.PF);}
"{"			{ return new Symbol(sym.CO);}
"}"			{ return new Symbol(sym.CF);}

{NUM}       { return new Symbol(sym.NUM);}
{SEP}       { ; }
{FIN}		{ return new Symbol(sym.EOF);}

