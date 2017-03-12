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
VAR			=	([a-z]|[0-9])+
FUNCIN		=	[a-zA-Z\-\_]
RETOUR		=	[\\n]+
COMM		=	"/*"([^*]|(\*+[^*/]))*\*+\/
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
"VOID"		{ return new Symbol(sym.VOID, yytext());}
"FUNCTION"	{ return new Symbol(sym.FUNCTION, yytext());}
"AFFECT"	{ return new Symbol(sym.AFFECT);}
"CALL"		{ return new Symbol(sym.CALL);}
"RETURN"	{ return new Symbol(sym.RETURN);}
"INT"		{ return new Symbol(sym.INT, yytext());}
"IF"		{ return new Symbol(sym.IF, yytext());}
"ELSE"		{ return new Symbol(sym.ELSE, yytext());}
"WHILE"		{ return new Symbol(sym.WHILE, yytext());}
{VAR}		{ return new Symbol(sym.VAR, yytext());}
"VAR"		{ return new Symbol(sym.DEFVAR, yytext());}
"="			{ return new Symbol(sym.EGAL);}
">"			{ return new Symbol(sym.SUP);}
"<"			{ return new Symbol(sym.INF);}
"=="		{ return new Symbol(sym.COMP);}
">="		{ return new Symbol(sym.SUP_EGAL);}
"<="		{ return new Symbol(sym.INF_EGAL);}
"!="		{ return new Symbol(sym.DIFF);}
"+"			{ return new Symbol(sym.PLUS);}
"-"			{ return new Symbol(sym.MOINS);}
"/"			{ return new Symbol(sym.DIV);}
"*"			{ return new Symbol(sym.MULT);}
","			{ return new Symbol(sym.VIRGUL);}
{RETOUR}	{}
{FIN}		{}
.			{ return null;}
