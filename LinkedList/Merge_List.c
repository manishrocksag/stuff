#include<stdio.h>
#define null NULL

struct node
{
	int data;
	struct node* next;
};

void mergeListAtAlternatePositions(struct node* p,struct node** q)
{
	struct node* p_current=p;
	struct node* q_current=*q;
	if(p==null||*q==null)
		return;
	struct node* p_next,q_next;

	while(p_current!=null && q_current!=null)
	{
		p_next=p_current->next;
		q_next=q_current->next;

		q_current->next=p_next;
		p_current->next=q_current;

		p_current=p_next;
		q_current=q_next;
	}
*q=q_current;
}
		
	