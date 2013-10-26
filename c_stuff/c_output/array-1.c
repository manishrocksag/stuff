#include <stdio.h>

int g[5];

int main(void) {	
	int x = 5;
	// int x(5);
	int a[5] = {12, 5, 7, 45, 6};
	int b[5]; // size compulsory
	int c[] = {12, 5, 7, 45, 6}; // correct
	int d[5] = {12, 5, 7}; // d[3] = d[4] = 0
	int e[5] = {0};
	static f[5];
	// b = {12, 5, 7, 45, 6}; error
	
	b[0] = 45;
	b[1] = 67;
	
	for (x = 2; x < 5; x++)
		b[x] = x * 50;
		
	printf("%d %d\n", b[2], d[3]);
	
	for (x = 0; x < 5; x++)
		printf("%d\n", f[x]);
		
	for (x = 0; x < 5; x++)
		printf("%d\n", g[x]);
		
	for (x = 0; x < 5; x++) {
		printf("Enter e[%d]:\n", x);
		scanf("%d", &e[x]);
	}
	
	return 0;
}
