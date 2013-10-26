#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {		
	FILE *fp = freopen("console.txt", "rb", stdin);
	char s[4][20];
	scanf("%s%s%s%s", s[0], s[1], s[2], s[3]); 
	printf("%s %s %s %s", s[0], s[1], s[2], s[3]); 	

	return 0;
}
