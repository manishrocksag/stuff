#include <stdio.h>

int main(void) {	
	int a[] = {12, 5, 7, 13, 6};
	int i;	
	int *p;
	/* int **pa = &a; warning */
	int (*pa)[] = &a;
	
	for (i = 0; i < 5; i++)
		printf("&a[%d] = %p, a + %d = %p\n", i, &a[i], i, a + i);
	
	printf("a = %p, &a[0] = %p\n", a, &a[0]);
	
	printf("*a = %d, a[0] = %d\n", *a, a[0]);	
	
	printf("a = %p, &a = %p\n", a, &a);
	
	for (i = 0; i < 5; i++)
		printf("a[%d] = %d, *(a + %d) = %d\n", i, a[i], i, *(a + i));
	
	for (i = 0; i < 5; i++)
		printf("%d[a] = %d\n", i, i[a]);
	
	p = a + 4;
	for (i = 0; i < 5; i++)
		printf("p[-%d] = %d\n", i, p[-i]);
		
	return 0;
}
