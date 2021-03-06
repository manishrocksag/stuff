#include<stdio.h>
#include<stdlib.h>
#define null NULL
struct node{
	struct node* left;
	struct node* right;
	int val;
};
struct node* newNode(int val)
{
  struct node *new = (struct node *) malloc (sizeof (struct node));
  new->left = NULL;
  new->right = NULL;
  new->val = val;
  return new;
}

struct node* insert (struct node *root, int val)
{
  if (root == NULL)
    return newNode (val);
  else
    {
      if (val <= root->val)
	root->left = insert (root->left, val);
      else
	root->right = insert (root->right, val);
      return root;
    }
}

void join(struct node* a,struct node* b)
{
	a->right=b;
	b->left=a;
}
struct node* append(struct node* a,struct node* b)
{
	if(a==null)
		return b;
	if(b==null)
		return a;
	struct node* aLast=a->left;
	struct node* bLast=b->left;
	
	join(aLast,b);
	join(bLast,a);
	
	return a;
}
struct node* tree_to_list(struct node* root)
{
	struct node* aList;
	struct node* bList;
	if(root==null)
		return null;
	aList=tree_to_list(root->left);
	bList=tree_to_list(root->right);
	root->left=root;
	root->right=root;

	aList=append(aList,root);
	aList=append(aList,bList);
	
	return aList;
}
void printList(struct node* head) 
{
	struct node* current = head;
	while(current != NULL)
        {
		printf("%d ", current->val);
		current = current->right;
			if (current == head) break;
	}
	printf("\n");
}
void main ()
{

  struct node *root = NULL;
  root = insert (root, 1);
  root = insert (root, 9);
  root = insert (root, 11);
  root = insert (root, 17);
  root = insert (root, 20);
  root = insert (root, 23);
  struct node* head=null;
  head=tree_to_list(root);
  printList(head);
}




