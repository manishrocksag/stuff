#include <stdio.h>

/*
void print(int a, int b)
{
	printf("%d %d\n", a, b);
}
*/

void print(a, b, c)
int a, b, c;
{
	printf("%d %d %d\n", a, b, c);
}

int (*changeValue(int (*pa)[], int i, int n))[] {
	(*pa)[i] = n;
	
	return pa;
}

int main(void) {
	int a[] = {10, 20, 30, 40, 50};
	int i;
	(*changeValue(&a, 2, 60))[3] = 70;
	
	for (i = 0; i < 5; i++)
		printf("%d ", a[i]);
	
	print();
	
	return 0;
}
