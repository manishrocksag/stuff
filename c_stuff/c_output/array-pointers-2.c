#include <stdio.h>

int main(void) {	
	int i;
	int a[] = {12, 5, 7, 13, 6};
	int (*pa)[] = &a; // pointer 2 an array of integers
	int *pa2[] = {a, a + 1, a + 2, a + 3, a + 4};
	// array of pointers 2 integers

	for (i = 0; i < 5; i++)
		printf("%d\n", *(*pa + i));
	for (i = 0; i < 5; i++)
		printf("%d\n", *pa2[i]);
	for (i = 0; i < 5; i++)
		printf("%p\n", *(pa2 + i));
	for (i = 0; i < 5; i++)
		printf("%d\n", **(pa2 + i));
	
	return 0;
}
