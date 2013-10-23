/*

 Here I have shown the implementation of very very big numbers which can be infinitely big as long as the memory permits.Numbers are represented in the form of array where each index of array contains one digit.Each digit 0-9 is represented as a single byte character.Various functions are written to perform arithmetic operations on this big bumbers


*/


#include<stdio.h>
#include<stdlib.h>
#define PLUS 1
#define MINUS 0
#define MAXDIGITS 100  /* max_length big num */

typedef struct{
	char digits[MAXDIGITS];
	int signbit;
	int lastdigit;
}bignum;

void print_bignum(bignum *num)
{
	int i;
	if(num->signbit==MINUS)
		printf("-");
	for(i=num->lastdigit;i>=0;i--)
		printf("%c",num->digits[i]);
	printf("\n");
}

initialize_bignum(bignum* num)
{
	num=(bignum*)calloc(sizeof(bignum,MAXSIZE));
}
add_bignum(bignum* a,bignum* b,bignum* c)
{

	int carry;
	int i;

	initialize_bignum(c);

	if(a->signbit==b->signbit)
		c->signbit=a->signbit;
	else
	{
		if(a->signbit==MINUS)
		{
			a->signbit=PLUS;
			subtract_bignum(b,a,c);
			a->signbit=MINUS;
		}
		else
		{
			b->signbit=PLUS;
			subtract_bignum(a,b,c);
			b->signbit=MINUS;
		}
		return;
	}

	c->lastdigit=max(a->lastdigit,b->lastdigit) +1;
	carry=0;
	for(i=c->lastdigit;i>=0;i--)
	{
		c->digit[i]=(char)(carry + a->digit[i] + b->digit[i])%10;
		carry=(carry + a->digit[i] +b->digit[i])/10;

	}
	zero_justify(c);
}

void zero_justify(bignum* num)
{
	while((num->lastdigit >0) && (
num->digit[num->lastdigit]==0)){
		num->lastdigit--;
	}

	if((num->lastdigit==0)&&(n->digit[0]==0))
		num->signbit=PLUS:
}

subtract_bignum(bignum *a, bignum *b, bignum *c)
{
	int borrow; /* anything borrowed? */
	int v; /* placeholder digit */
	int i; /* counter */


	if ((a->signbit == MINUS) || (b->signbit == MINUS)) {
		b->signbit = -1 * b->signbit;
		add_bignum(a,b,c);
		b->signbit = -1 * b->signbit;
	return;
	}

	if (compare_bignum(a,b) == PLUS) {
		subtract_bignum(b,a,c);
		c->signbit = MINUS;
	return;
	}

	c->lastdigit = max(a->lastdigit,b->lastdigit);
	borrow = 0;
	for (i=0; i<=(c->lastdigit); i++) {
		v = (a->digits[i] - borrow - b->digits[i]);
		if (a->digits[i] > 0)
			borrow = 0;
		if (v < 0) {
			v = v + 10;
			borrow = 1;
			}
		c->digits[i] = (char) v % 10;
}
zero_justify(c);
}


int compare_bignum(bignum *a, bignum *b)
{
	int i; /* counter */
	if ((a->signbit==MINUS) && (b->signbit==PLUS)) return(PLUS);

	if ((a->signbit==PLUS) && (b->signbit==MINUS)) return(MINUS);

	if (b->lastdigit > a->lastdigit) return (PLUS * a->signbit);

	if (a->lastdigit > b->lastdigit) return (MINUS * a->signbit);

	for (i = a->lastdigit; i>=0; i--) {
		if (a->digits[i] > b->digits[i])
			return(MINUS * a->signbit);
		if (b->digits[i] > a->digits[i])
			return(PLUS * a->signbit);
	}
	return(0);
}

multiply_bignum(bignum *a, bignum *b, bignum *c)
{
	bignum row; /* represent shifted row */
	bignum tmp; /* placeholder bignum */
	int i,j; /* counters */

	initialize_bignum(c);

	row = *a;
	for (i=0; i<=b->lastdigit; i++) {
		for (j=1; j<=b->digits[i]; j++) {
			add_bignum(c,&row,&tmp);
			*c = tmp;
			}
		digit_shift(&row,1);
	}
	c->signbit = a->signbit * b->signbit;
	zero_justify(c);

}


digit_shift(bignum *n, int d) /* multiply n by 10ˆd */
{
	int i; /* counter */

	if ((n->lastdigit == 0) && (n->digits[0] == 0)) 					return;
	for (i=n->lastdigit; i>=0; i--)
		n->digits[i+d] = n->digits[i];
		for (i=0; i<d; i++)
			 n->digits[i] = 0;
	 n->lastdigit = n->lastdigit + d;
}

divide_bignum(bignum *a, bignum *b, bignum *c)
{
	bignum row; /* represent shifted row */
	bignum tmp; /* placeholder bignum */
	int asign, bsign; /* temporary signs */
	int i,j; /* counters */

	initialize_bignum(c);

	c->signbit = a->signbit * b->signbit;
	asign = a->signbit;
	bsign = b->signbit;
	a->signbit = PLUS;
	b->signbit = PLUS;

	initialize_bignum(&row);
	initialize_bignum(&tmp);

	c->lastdigit = a->lastdigit;
	for (i=a->lastdigit; i>=0; i--) {
		digit_shift(&row,1);
		row.digits[0] = a->digits[i];
		c->digits[i] = 0;
		while (compare_bignum(&row,b) != PLUS) {
			c->digits[i] ++;
			subtract_bignum(&row,b,&tmp);
			row = tmp;
			}
		}
	zero_justify(c);
	a->signbit = asign;
	b->signbit = bsign;

}
		
	
		


     




