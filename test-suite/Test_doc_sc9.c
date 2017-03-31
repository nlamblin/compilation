/* 
int Fibonacci(int);
 
main()
{
   int n, i = 0, c;
 
   scanf("%d",&n);
 
   printf("Fibonacci series\n");
 
   for ( c = 1 ; c <= n ; c++ )
   {
      printf("%d\n", Fibonacci(i));
      i++; 
   }
 
   return 0;
}
 
int Fibonacci(int n)
{
   if ( n == 0 )
      return 0;
   else if ( n == 1 )
      return 1;
   else
      return ( Fibonacci(n-1) + Fibonacci(n-2) );
} 
*/

FUNCTION VOID main(INT n){
	CALL fibonacci(n)
}

FUNCTION INT fibonacci(INT n){
	VAR res;
	IF ( n < 2 ){
		AFFECT res = n;
	} ELSE {
		AFFECT res = (fibonacci(n-1) + fibonacci(n-2));
	}
	RETURN res;
}

FUNCTION INT fibonacci_iter(INT n){
	VAR i;
	AFFECT i = 0;
	VAR prec;
	VAR curr;
	VAR tmp;
	AFFECT curr = 1;
	CALL print(0);
	WHILE(i < n){
		CALL print(prec + curr);
		AFFECT tmp = curr;
		AFFECT curr = curr + prec;
		AFFECT prec = tmp;
		AFFECT i = i +1;
	}
}
