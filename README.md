METTRE CALL DEVANT CHAQUE APPEL DE FONCTION. 
ON NE PEUT PAS APPELER UNE FONCTION OU UNE VARIABLE SI ELLE N'A PAS ÉTÉ CRÉÉE AVANT -> FONCTION MAIN TOUT À LA FIN. 


# Particularités du langage:

### Déclaration d'une variable:
VAR x;

### Affectation d'une variable:
AFFECT x = 0;

### Fonction:
FUNCTION VOID main() { ... }

### Conditionnelle:
IF ( x == 0) { ... }
ELSE { ... }

Pas de ELSEIF ni de ET et OU dans les conditions.

### Iteration:
WHILE ( x < 10) { ... }

### Divers:
Points virgules obligatoires après chaque instruction.
Les mots clés (VAR, AFFECT, FUNCTION, INT, VOID, IF, WHILE, RETURN, CALL) sont en majuscules.
Les variables et les noms de fonction peuvent contenir des lettres minuscules et des chiffres.

Incrémentation : AFFECT x = x + 1;

RETURN obligatoire dans fonction ayant un type de retour.
RETURN non accepté dans une fonction de type void.
Si une fonction a un type de retour, le RETURN doit être sur la dernière ligne de la fonction.

Une fonction intitulée main doit être présente car c'est le point d'entré du programme.