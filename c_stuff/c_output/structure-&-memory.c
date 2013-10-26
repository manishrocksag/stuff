#include <stddef.h>
#include <stdio.h>

typedef struct book {
	char title[50];
	char author[50];	
	double price;
} Book;

int main(void) {
	Book b = {"Kritik der reinen Vernunft", "Immanuel Kant", 10};
	
	printf("size of Book = %d\n", sizeof (Book));
	
	printf("offset of\n"
		"title: %d\n"
		"author: %d\n"
		"price: %d\n",
		offsetof(Book, title), offsetof(Book, author), 
		offsetof(Book, price)
	);
	
	
	return 0;
}
