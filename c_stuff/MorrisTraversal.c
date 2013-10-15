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

/* Morris Traversal for inorder */

void inorder_morris_traversal(struct node* root)
{
	struct node* current=root;
	struct node* pre=null;
	while(root)
	{
		if(current->left==null)
		{
			printf("%d",current->val);
			current=current->right;
		}
		else
		{
			pre=current->left;
			while(pre->right!=null && pre!=current)
			{
				pre=pre->right;
			}
			if(pre->right==null)
			{
				pre->right=current;
				current=current->left;	
			}
			else
			{
				pre->right=null;
				printf("%d",current->val);
				current=current->right;
			}
		}
	}
}

void morrisTraversalPreorder(struct node* root)
{
    while (root)
    {
        if (root->left == NULL)
        {
            printf( "%d ", root->val );
            root = root->right;
        }
        else
        {
            struct node* current = root->left;
            while (current->right && current->right != root)
                current = current->right;
            if (current->right == root)
            {
                current->right = NULL;
                root = root->right;
            }
 
            else
            {
                printf("%d ", root->val);
                current->right = root;
                root = root->left;
            }
        }
    }
}
/* Print nodes at k distance from root   */

void _print_nodes(struct node* root,int k)
{
	if(root==null)
		return;
	if(k==0)
		printf("%d",root->val);

	_print_nodes(root->left,k-1);
	_print_nodes(root->right,k-1);

}
void main ()
{
  struct node *root = NULL;
  root = insert (root, 9);
  root = insert (root, 7);
  root = insert (root, 6);
  root = insert (root, 17);
  root = insert (root, 20);
	_print_nodes(root,2);
 

}
