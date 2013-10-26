#include <stdio.h>

int main() {
	int n = 10;
	
	printf("%p\n", &n);
	printf("%d\n", *(int *)0x000000000022FE5C);
	printf("%d\n", n);
	printf("%d\n", *&n);
	printf("%d\n", (&n)[0]);
	printf("%d\n", 0[&n]);
	printf("%d\n", (&n + 5)[-5]);
	printf("%d\n", 0[(int *)0x000000000022FE5C]);

	
	return 0;
}
