#include <stdio.h>

int main(void) {
	int a[5] = {17, 5, 8, 98, 6};
	int *b[5] = {a, a + 1, a + 2, a + 3, a + 4};
	int *p1 = a;
//	int **p2 = +&a;
	int (*p3)[5] = &a;
	int i;
	int *(*p4)[5] = &b;
	int (**p5)[5] = &p3;
				
	printf("a = %p, &a = %p\n", a, &a);
	
	p1 = a + 4;
	for (i = 0; i < 5; i++)
		printf("p1[-%d] = %d\n", i, p1[-i]);
		
	for (i = 0; i < 5; i++)
		printf("%d[a] = %d\n", i, i[a]);
		
	for (p1 = a; p1 <= a + 4; p1++)
		printf("*p1 = %d", *p1);
	
	return 0;
}


// a[i] = *(a + i);

