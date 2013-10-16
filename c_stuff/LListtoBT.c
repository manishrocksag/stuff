/* Given a Singly LinkedList,Convert it to complete Binary Tree
*/

struct node* lList_bst(struct node* root,struct lnode* head)
{
	Queue q;
	if(head==null)
		return;

	root=newNode(head->data);
	q.enqueue(root);
	head=head->next;

	while(head)
	{
		struct node* parent=q.dequeue();
		struct node* leftChild=null,rightChild=null;
		leftChild=newNode(head->data);
		q.enqueue(leftChild);
		head=head->next;
		if(head)
		{
			rightChild=newNode(head->data)
			q.enqueue(rightChild);
			head=head->next;
		}
		parent->left=leftChild;
		parent->right=rightChild;
	}
}
		
