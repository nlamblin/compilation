METTRE CALL DEVANT CHAQUE APPEL DE FONCION
ON NE PEUT PAS APPELE UNE FONCTION OU UNE VRIABLE SI ELLE N'A PAS ETE CREER AVANT -> FONCTION MAIN TOUT A LA FIN


# Particularité du langage : 

### Déclaration variable : 
VAR x; 

### Affectation variable : 
AFFECT x = 0;

### Focntion :
FUNCTION VOID main() { ... }

### Conditionnelle : 
IF ( x == 0) { ... }
ELSE { ... }

Pas de ELSEIF ni de ET ou OU dans la condition

### Iteration : 
WHILE ( x < 10) { ... }

### Divers : 

Points virgules obligatoires après chaque instruction.
Les mots clés (VAR, AFFECT, FUNCTION, INT, VOID, IF, WHILE, RETURN, CALL) sont en majuscules.
Les variables et les noms de fonction peuvent contenir des lettres minuscules et des chiffres.

Incrémentation : AFFECT x = x + 1;

RETURN obligatoire dans fonction ayant un type de retour.
RETURN non accepté dans une fonction void.
Si fonction avec type de retour, le RETURN doit être sur la dernière ligne de la fonction