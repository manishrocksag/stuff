#include <stdio.h>

int main(void) {
	int a = 10;
	int *pa = &a;
	int **ppa = &pa;
	
	printf("a = %d\n", a);
	printf("&a = %p\n", &a);
	printf("pa = %p\n", pa);
	printf("&pa = %p\n", &pa);
	printf("ppa = %p\n", ppa);
	printf("&ppa = %p\n", &ppa);
	printf("*ppa = %p\n", *ppa);
	printf("**ppa = %d\n", **ppa);
	printf("*&pa = %p\n", *&pa);
	printf("&*pa = %p\n", &*pa);
	
	
	return 0;
}
