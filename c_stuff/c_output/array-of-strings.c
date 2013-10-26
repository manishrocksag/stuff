#include <stdio.h>

int main() {
	int i;
	
	char *s[] = {
		"atrayee",
		"debanjana",
		"jaya",
		"sagnik",
		"sarjo",
		NULL
	};
	
	for (i = 0; s[i]; i++)
		printf("%s\n", s[i]);
	
	return 0;
}
