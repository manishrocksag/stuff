#include <stdio.h>

// Pointers in C: An introduction

int main(void) {
	int a = 10;
	int *pa = &a;
	int **ppa = &pa;
	
	printf("main = %p\n", main);
	printf("&a = %p\n", &a);
	printf("a = %p\n", a);
	printf("pa = %p\n", pa);
	printf("*pa = %p\n", *pa);
	printf("*&a = %p\n", *&a);
	printf("&pa = %p\n", &pa);
	printf("ppa = %p\n", ppa);
	printf("*ppa = %p\n", *ppa);
	printf("**ppa = %p\n", **ppa);
	// printf("***ppa = %p\n", ***ppa); error
	
	printf("a = %d\n", *(int *)0X0022FF74);
	printf("a = %d\n", *(int *)2293620);
	
	return 0;
}
