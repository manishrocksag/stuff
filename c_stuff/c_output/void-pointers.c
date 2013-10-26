#include <stdio.h>

int main(void) {
	int a = 10;
	void *pa = &a;
	void **ppa = &pa;
	void *pa2 = &pa;
	
	// printf("%d", (int)*pa); error
	printf("%d", *(int *)pa);
	// printf("%d", **ppa); error
	printf("%d", *(int *)*ppa);
	printf("%d", **(int **)ppa);
	printf("%d", **(int **)pa2);
	printf("%d", *(int *)*(void **)pa2);
	
	return 0;
}
