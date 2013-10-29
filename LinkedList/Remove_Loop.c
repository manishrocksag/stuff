/* Remove Loop from a Linked List */

void remove_loop(struct node* loop,struct node* head)
{
	struct node* ptr1;
	struct node* ptr2;

	ptr1=head;

	while(1)
	{
		ptr2=loop;
		while(ptr2->next!=loop && ptr2->next!=ptr1)
		{
			ptr2=ptr2->next;
		}
		if(ptr2->next==ptr1)
			break;
		else
			ptr1->ptr1->next;

	}
	ptr2->next=null;
}
		