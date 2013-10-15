#define null NULL
#define INT_MAX 32,767
#define INT_MIN -32,767
#include<stdio.h>
#include<stdlib.h>
struct node
{
  struct node *right;
  struct node *left;
  int val;
  int size;
};
struct node* newNode (int val)
{
  struct node *new = (struct node *) malloc (sizeof (struct node));
  new->left = NULL;
  new->right = NULL;
  new->val = val;
  new->size=0;
  return new;
}
int max(int a,int b)
{
	return (a>b)?a:b;
}
int size(struct node* root)
{
	if(root==null)
		return 0;
	else
		return size(root->left) +size(root->right) +1;
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

	root->size=1 + size(root->left) + size(root->right);
      return root;
    }
}
int get_height(struct node* root)
{
	if(root==null)
		return 0;
	int lHeight,rHeight;
	lHeight=get_height(root->left);
	rHeight=get_height(root->right);

	if(lHeight>rHeight)
		return lHeight + 1;
	else
		return rHeight + 1;

}

/* Maximum width of a binary tree */

int util_get_width(struct node* root,int level)
{
	if(root==null)
		return 0;	
	if(level==1)
		return 1; 
	else if(level >1)
	{
		return util_get_width(root->left,level-1) + util_get_width(root->right,level-1);
	}
}

int get_width(struct node* root)
{
	if(root==null)
		return 0;
	int height=get_height(root);
	int i;
	int max_width=0;
	for(i=1;i<=height;i++)
	{
		int width=util_get_width(root,i);
		if(width>max_width)
			max_width=width;
	}
	return max_width;
}


/* Method 2-Using Count Array */
int get_max(int arr[],int n)
{
	int maxCount=0;
	int i;
	for(i=0;i<n;i++)
		if(arr[i]>maxCount)
			maxCount=arr[i];
return maxCount;
}
void fill_count_array(struct node* root,int level,int arr[])
{
	if(root)
	{
		arr[level]++;
		fill_count_array(root->left,level+1,arr);
		fill_count_array(root->right,level+1,arr);
	}
}
int get_max_width(struct node* root)
{
	if(root==null)
		return 0;
	int height=get_height(root);

	int *count=(int*)calloc(sizeof(int),height);
	int level=0;
	fill_count_array(root,level,count);
	return get_max(count,height);
}
/* Inorder Successor in Binary Search Tree */
struct node* min(struct node* root)
{
	while(root->left)
		root=root->left;
return root;
}

struct node* _inorderSuccessor(struct node* root,struct node* node)
{
	if(root==null)
		return null;
	if(node->right)
		return min(node->right);
	struct node* succ=null;
	while(root)
	{
		if(root->val>node->val)
		{
			succ=root;
			root=root->left;	
		}
		else if(node->val>root->val)
			root=root->right;
		else
			break;
	}
	return succ;
}

/* Sorted order printing of a given array that represents a BST */

void printSorted(int arr[], int start, int end)
{     
  if(start > end)
    return;

  // print left subtree
  printSorted(arr, start*2 + 1, end);

  // print root
  printf("%d  ", arr[start]);

  // print right subtree
  printSorted(arr, start*2 + 2, end);  
}
/* max sum from root to leaf path */
 
void max_sum_leafPath(struct node* root,int* max_sum,int sum)
{
	if(root==null)
		return;
	sum=sum+root->val;
	if(root->left==null && root->right==null)
	{
		if(sum > *max_sum)
		{
			*max_sum=sum;
		}
	}
	max_sum_leafPath(root->left,max_sum,sum);
	max_sum_leafPath(root->right,max_sum,sum);
}
			
void main()
{
	struct node *root = NULL;
  root = insert (root, 20);
  root = insert (root, 8);
  root = insert (root, 22);
  root = insert (root, 4);;
  root = insert (root, 12);
  root = insert (root, 10);
  struct node* temp=newNode(10);

	//printf("%d",get_width(root));
	int max_sum=0;
//struct node* tem=_inorderSuccessor(root,temp);
max_sum_leafPath(root,&max_sum,0);
printf("%d",max_sum);
}
