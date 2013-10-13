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
struct node* del_keys_greater(struct node* root,int k)
{
	struct node* left;
	struct node* right;
	if(root==null)
		return;
	if(root->val > k)
		return root;
	left=del_keys_greater(root->left,k-root->val);
	right=del_keys_greater(root->right,k-root->val);
	if((!left)&&(!right))
	{
		free(root);
		root=null;
	}
	return root;
}
void print_in_order (struct node *root)
{
  if (root == NULL)
    return;
  print_in_order (root->left);
  printf ("%d\t", root->val);
  print_in_order (root->right);
}
/* Extract Leaves of a Binary Tree in a Doubly Linked List */

struct node* extract_leaves(struct node* root,struct node** headRef)
{
	if(root==null)
		return null;
	if(root->left==null && root->right==null)
	{
		root->right=(*headRef);
		if(*headRef!=null)
			(*headRef)->left=root;
		*headRef=root;
		return null;
		
	}
	root->right=extract_leaves(root->right,headRef);
	root->left=extract_leaves(root->left,headRef);

	return root;
}

struct node* pruneUtil(struct node* root,int k,int *sum)
{
	int lsum,rsum;
	if(root==null)
		return;
	lsum=*sum + root->val;
	rsum=lsum;
	 
	root->left=pruneUtil(root->left,k,sum);
	root->right=pruneUtil(root->right,k,sum);
	
	*sum=max(lsum,rsum);
	if(*sum < k)
	{
		free(root);
		root=null;
	}
	return root;
}

/* Check if all leaves are at same level */

int check_leaf_level(struct node* root,int level)
{
	printf(" data is before  %d and level is %d",root->val,level);
	printf("\n");
	if(root==null)
		return 1;
	if(root->left==null && root->right==null)
		return level+1;
	printf(" data is %d and level is %d",root->val,level);
	printf("\n");
	
	return (check_leaf_level(root->left,level+1))==(check_leaf_level(root->right,level+1));
}

int check_same_level(struct node* root,int *leafLevel,int level)
{
	if(root==null)
		return 1;
	if(root->left==null && root->right==null)
	{
		if(*leafLevel==0){
			*leafLevel=level;
			return 1;}
		return *leafLevel==level;
	}
	check_same_level(root->left,leafLevel,level +1)&&check_same_level(root->right,leafLevel,level+1);
}
int max(int a,int b)
{
	return (a>b)?a:b;
}

/* Find depth of the deepest odd level leaf node */

int depth_level(struct node* root,int level)
{
	if(root==null)
		return 0;
	if(root->left==null && root->right==null &&(level%2==1))
		return level;
	return max(depth_level(root->left,level+1),depth_level(root->right,level+1));
}

/* Difference between sums of odd level and even level nodes of a Binary Tree */

int get_level_order_difference(struct node* root)
{
	if(root==null)
		return 0;
	return root->val - get_level_order_difference(root->left) - get_level_order_difference(root->right);
}

void sum(struct node* root,int level,int *osum,int* esum)
{
	if(root==null)
		return;
	if(level%2==0)
		*esum+=root->val;
	else
	{
		*osum+=root->val;
		sum(root->left,level+1,osum,esum);
		sum(root->right,level+1,osum,esum);
	}
}
int print_ancestors(struct node* root,int target)
{
	if(root==null)
		return 0;
	if(root->val==target)
		return 1;
	if(print_ancestors(root->left,target)||print_ancestors(root->right,target)){
	printf("%d",root->val);
	return 1;
			}
return 0;
}

/* 
BST to Doubly Linked List 
   1. If left subtree exists, process the left subtree
   1.a) Recursively convert the left subtree to DLL.
   1.b) Then find inorder predecessor of root in left subtree    (inorder predecessor is rightmost node in left subtree).
   1.c) Make inorder predecessor as previous of root and root as next of inorder predecessor.
   2. If right subtree exists, process the right subtree (Below   3 steps are similar to left subtree).
   2.a) Recursively convert the right subtree to DLL. 
   2.b) Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
   2.c) Make inorder successor as next of root and root as previous of inorder successor. 
   3. Find the leftmost node and return it (the leftmost node is always head of converted DLL).

*/

struct node* bst_to_dll(struct node* root)
{
	if(root==null)
		return;
	if(root->left!=null)
	{
		struct node* left=bst_to_dll(root->left);
		for(;left->right!=null;left=left->right);
		left->right=root;
		root->left=left;
	}
	if(root->right!=null)
	{
		struct node* right=bst_to_dll(root->right);
		for(;right->left!=null;right=right->left);
		right->left=root;
		root->right=right;
	}
	return root;
		
}
struct node* bintree2list(struct node *root)
{
    // Base case
    if (root == NULL)
        return root;
 
    root = bst_to_dll(root);
 
    while (root->left != NULL)
        root = root->left;
 
    return (root);
}
void main()
{
	struct node *root = NULL;
  root = insert (root, 19);
  root = insert (root, 8);
  root = insert (root, 5);
  root = insert (root, 67);;
  root = insert (root, 22);
  root = insert (root, 20);
  root = insert (root, 25);
//print_in_order(root);
//int sum=0;
//root=pruneUtil(root,29,&sum);
//print_in_order(root);
//struct node* headRef=null;
//root=extract_leaves(root,&headRef);
//printf("%d",(headRef)->val);
//while(headRef!=null)
//{
//	printf("%d",headRef->val);
//	headRef=headRef->right;
//
//}
	//printf("%d",depth_level(root,0));
	//print_ancestors(root,5);
	root=bintree2list(root);
while(root!=null)
{
	printf("%d",root->val);
	root=root->right;

}
	
}
	

