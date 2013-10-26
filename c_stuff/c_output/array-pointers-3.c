#include <stdio.h>

int main(void) {
	int a[5] = {12, 5, 7, 13, 6};
	int b[5];
	// b = {12, 5, 7, 13, 6}; error
	int c[] = {12, 5, 7, 13, 6};
	int d[5] = {12, 5};
	int e[5] = {12, 5, 7, 13, 6, 18}; // warning
	int n = 123, i;
	int f[] = {12, 5, 7, n, n + 1};
	int g['a'];
	// int h[n]; not possible in turbo c
	
	for (i = 0; i < 5; i++)
		printf("%d\n", f[i]);
		
	a[0] = 13;
	
	for (i = 0; i < 5; i++) {
		printf("Enter a[%d]\n", i);
		scanf("%d", &a[i]);
	}
		
	return 0;
}
