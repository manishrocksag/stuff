#include <stdio.h>
#include <math.h>

double (*f)(double)

double getRatio(double (*f)(double), double val) {
	return f(val);
}


int main(void) {
	double v; 
	int	n;

	printf("Enter a no.\n");
	scanf("%lf", &v);
	printf("press 1> for sin 2> for cos\n");
	scanf("%d", &n);
	if (n == 1)
		printf("sin(%lf) = %lf\n", v, getRatio(sin, v));
	else
		printf("cos(%lf) = %lf\n", v, getRatio(cos, v));

	return 0;
}
