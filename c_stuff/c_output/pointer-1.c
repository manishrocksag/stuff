#include <stdio.h>

int main() {
	int n = 0XA;
	int *pn = &n;
	int **ppn = &pn;
	
	printf("n = %X\n", n);
	printf("&n = %p\n", &n);
	printf("pn = %p\n", pn);
	printf("*pn = %d\n", *pn);
	printf("&pn = %p\n", &pn);
	printf("ppn = %p\n", ppn);
	printf("*ppn = %p\n", *ppn);
	printf("**ppn = %p\n", **ppn);
	/* printf("*n = %X\n", *n); */
	printf("*&n = %X\n", *&n);
	
	return 0;
}
