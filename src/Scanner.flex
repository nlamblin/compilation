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
%debug

/* macros */
SEP  	   	=   [ \t]
NUM		    =   [0-9]+
VAR			=	[a-z]+
RETOUR		=	[\\n]+
COMM		=	((\/*){1}.*(\*\/){1})+
FIN     	=   \r|\n|\r\n

%%

/* regles */

{NUM}       { return new Symbol(sym.NUM, yytext());}
{SEP}       { ; }
{COMM}		{}
"("			{ return new Symbol(sym.PO, yytext());}
")"			{ return new Symbol(sym.PF, yytext());}
"{"			{ return new Symbol(sym.ACO, yytext());}
"}"			{ return new Symbol(sym.ACF, yytext());}
";"			{ return new Symbol(sym.DOT);}
"FUNCTION"	{ return new Symbol(sym.FUNCTION, yytext());}
"VOID"		{ return new Symbol(sym.VOID, yytext());}
"INT"		{ return new Symbol(sym.INT, yytext());}
{VAR}		{ return new Symbol(sym.VAR, yytext());}
"VAR"		{ return new Symbol(sym.DEFVAR);}
"AFFECT"	{ return new Symbol(sym.AFFECT);}
"="			{ return new Symbol(sym.EGAL);}
">"			{ return new Symbol(sym.SUP);}
"<"			{ return new Symbol(sym.INF);}
"=="		{ return new Symbol(sym.COMP);}
">="		{ return new Symbol(sym.SUP_EGAL);}
"<="		{ return new Symbol(sym.INF_EGAL);}
"!="		{ return new Symbol(sym.DIFF);}
{RETOUR}	{}
{FIN}		{}
.			{ return null;}

