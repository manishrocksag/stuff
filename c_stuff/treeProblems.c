#include<stdio.h>
#include<stdlib.h>
#define null NULL
struct node
{
  struct node *right;
  struct node *left;
  int val;
};
struct node* newNode (int val)
{
  struct node *new = (struct node *) malloc (sizeof (struct node));
  new->left = NULL;
  new->right = NULL;
  new->val = val;
  return new;
}
void view(struct node*,int*,int);

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
void print_in_order (struct node *root)
{
  if (root == NULL)
    return;
  print_in_order (root->left);
  printf ("%d\t", root->val);
  print_in_order (root->right);
}

void print_left_view(struct node* root)
{
	int max_level=0;
	view(root,&max_level,1);
}
void view(struct node* root,int *max_level,int level)
{
	if(root==null)
		return;
	if(level > *max_level)
	{
		printf("%d\t",root->val);
		*max_level=level;
	}
	view(root->left,max_level,level+1);
	view(root->right,max_level,level+1);
}
void all_keys_greater(struct node* root,int* sum)
{
	if(root==null)
		return;
	all_keys_greater(root->right,sum);
	*sum+=root->val;
	root->val=*sum;
	all_keys_greater(root->left,sum);
}
void main()
{
  struct node *root = NULL;
  root = insert (root, 10);
  root = insert (root, 5);
  root = insert (root, 6);
  root = insert (root, 4);
  root = insert (root, 9);
  root = insert (root, 3);
  root = insert (root, 23);
  root = insert (root,11);
  root = insert (root,25);
  //print_left_view(root);
  print_in_order(root);
  printf("\n\n");
	int sum=0;
	all_keys_greater(root,&sum);
  print_in_order(root);
	
 


}
	
