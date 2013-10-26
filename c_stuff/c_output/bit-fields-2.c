#include <stdio.h>

typedef struct type {
	int a: 4;
	int b: 8;
	int : 22;
	int c: 12;
	int d: 8;
} Type;

int main(void) {
	Type var = {7, 127, 2047, 127};
	
	printf("Size of Type = %d\n", sizeof (Type));
	// printf("%p %p %p %p", &var.a, &var.b, &var.c, &var.d);
	
	return 0;
}
