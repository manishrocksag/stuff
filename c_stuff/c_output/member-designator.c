#include <stdio.h>

typedef struct name {
	char first[50];
	char last[50];
} Name;

typedef struct book {
	char title[50];
	Name authors[10];
	char description[100];
	double price;
} Book;

int main(void) {
	Book b = {.authors = {{.last = "lapierre", 
		.first = "dominique"}, {"larry", "collins"}},
		.title = "or i'll dress you in mourning",
		.description = "an extraordinary life of el cordobis",
		61.95
	};
	Book b2 = {
		"or i'll dress you in mourning",
		{{"dominique", "lapierre"}, {"larry", "collins"}},
		"an extraordinary life of el cordobis",
		61.95
	};
	
	printf("%s %s %s %s %.2lf", b.title, b.authors[0].first,
		b.authors[0].last, b.description, b.price);
	return 0;
}
