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

void print_in_order (struct node *root)
{
  if (root == NULL)
    return;
  print_in_order (root->left);
  printf ("%d\t", root->val);
  print_in_order (root->right);
}
int look_up(struct node* root,int val)
{
	if(root==NULL)
		return -1;
	if(val<root->val)
		return look_up(root->left,val);
	else if(val>root->val)
		return look_up(root->right,val);
	else
		return 1;
} 
int size(struct node* root)
{
	if(root==NULL)
		return 0;
	else
		return 1 + size(root->left) + size(root->right);
}
int max_depth(struct node* root)
{
	int l_depth,r_depth;
	if(root==NULL)
		return 0;
	l_depth=max_depth(root->left);
	r_depth=max_depth(root->right);
	if(l_depth > r_depth)
		return l_depth + 1;
	else
		return r_depth + 1;
}
int min_value(struct node* root)
{
	if(root==NULL)
		return -1;
	while(root->left!=null)
	{
		root=root->left;
	}
	return root->val;
}
int max_value(struct node* root)
{
	if(root==NULL)
		return -1;
	while(root->right!=null)
	{
		root=root->right;
	}
	return root->val;
}
void print_postorder(struct node* root)
{
	if(root==null)
		return;
	print_postorder(root->left);
	print_postorder(root->right);
	printf("%d\t",root->val);
}
void print_preorder(struct node* root)
{
	if(root==null)
		return;
	printf("%d\t",root->val);
	print_preorder(root->left);
	print_preorder(root->right);
	
}

void main ()
{
  /*struct node* x=newNode(4);
     printf("%d",x->val);
     printf("%d",sizeof(struct node));
     printf("%d",sizeof(struct node*)); */
  struct node *root = NULL;
  root = insert (root, 7);
  root = insert (root, 5);
  root = insert (root, 2);
  root = insert (root, 9);
  root = insert (root, 11);
  root = insert (root, 17);
  root = insert (root, 16);
  root = insert (root, 3);
  print_in_order (root);
  printf("%d",look_up(root,17));
  printf("%d",look_up(root,-1));
  printf("\n");
  printf("%d",size(root));
  printf("%d",max_depth(root));
  printf("\n");
	printf("%d\n",max_value(root));
	printf("%d",min_value(root));
	printf("\n");
	printf("postorder \n");
	print_postorder(root);
	printf("\n");
	printf("pre order \n");
	print_preorder(root);
	

}
