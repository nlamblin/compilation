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
RETOUR		=	\n

%%

/* regles */

"("			{ return new Symbol(sym.PO);}
")"			{ return new Symbol(sym.PF);}
"{"			{ return new Symbol(sym.ACO);}
"}"			{ return new Symbol(sym.ACF);}
"+"         { return new Symbol(sym.ADD);}
"*"         { return new Symbol(sym.MUL);}
"-"			{ return new Symbol(sym.SOUS);}
"/"			{ return new Symbol(sym.DIV);}
"function"	{ return new Symbol(sym.FUNCTION, yytext());}
"void"		{ return new Symbol(sym.VOID, yytext());}
"main"		{ return new Symbol(sym.VAR, yytext());}
"="			{ return new Symbol(sym.AFFECT);}
">"			{ return new Symbol(sym.SUP);}
"<"			{ return new Symbol(sym.INF);}
"=="		{ return new Symbol(sym.COMP);}
">="		{ return new Symbol(sym.SUP_EGAL);}
"<="		{ return new Symbol(sym.INF_EGAL);}
"!="		{ return new Symbol(sym.DIFF);}
";"			{ return new Symbol(sym.DOT);}
{NUM}       { return new Symbol(sym.NUM);}
{SEP}       { ; }
{RETOUR}	{ return new Symbol(sym.RETOUR); }
{FIN}		{ return new Symbol(sym.FIN);}
