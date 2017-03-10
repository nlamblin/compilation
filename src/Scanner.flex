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
VAR			=	[a-zA-Z]+
RETOUR		=	[\\n]*
COMM		=	(\/*){1}.*(\*\/){1}
FIN     	=   \r|\n|\r\n

%%

/* regles */

{NUM}       { return new Symbol(sym.NUM, yytext());}
{SEP}       { ; }
{COMM}		{ return new Symbol(sym.COMM, yytext());}
"("			{ return new Symbol(sym.PO, yytext());}
")"			{ return new Symbol(sym.PF, yytext());}
"{"			{ return new Symbol(sym.ACO, yytext());}
"}"			{ return new Symbol(sym.ACF, yytext());}
"function"	{ return new Symbol(sym.FUNCTION, yytext());}
"void"		{ return new Symbol(sym.VOID, yytext());}
"int"		{ return new Symbol(sym.INT, yytext());}
{VAR}		{ return new Symbol(sym.VAR, yytext());}
"="			{ return new Symbol(sym.AFFECT);}
">"			{ return new Symbol(sym.SUP);}
"<"			{ return new Symbol(sym.INF);}
"=="		{ return new Symbol(sym.COMP);}
">="		{ return new Symbol(sym.SUP_EGAL);}
"<="		{ return new Symbol(sym.INF_EGAL);}
"!="		{ return new Symbol(sym.DIFF);}
{RETOUR}	{ return new Symbol(sym.RET);}
{FIN}		{ return new Symbol(sym.EOF);}
.			{ return null;}

