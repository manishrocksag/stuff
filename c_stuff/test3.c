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
int height(struct node* root)
{
	if(root==null)
		return 0;
	int lHeight,rHeight;
	lHeight=height(root->left);
	rHeight=height(root->right);

	if(lHeight>rHeight)
		return lHeight + 1;
	else
		return rHeight + 1;

}



/* Binary Tree to DLL */

void fixPrevPtr(struct node* root)
{
	struct node* prev=null;
	if(root==null)
		return;
	fixPrevPtr(root->left);
	root->left=prev;
	prev=root;
	fixPrevPtr(root->right);
}
struct node* fixNextPtr(struct node* root)
{
	struct node* prev;
	while(root && root->right!=null)
		root=root->right;

	while(root && root->left!=null)
	{	
		prev=root;
		root=root->left;
		root->right=prev;
	}
return root;
}
struct node* bst_to_dll2(struct node* root)
{
	if(root==null)
		return null;
	fixPrevPtr(root);
	return fixNextPtr(root);
}


/* Tree Isomorphism Problem */

int is_isomorphic(struct node* root1,struct node* root2)
{
	if(root1==null && root2==null)
		return 1;
	if(root1!=null||root2!=null)
		return 0;
	if(root1->val!=root2->val)
		return 0;
	return is_isomorphic(root1->left,root2->left)&&is_isomorphic(root1->right,root2->right)||is_isomorphic(root1->left,root2->right)&&is_isomorphic(root1->right,root2->left);

}

/*  Remove BST keys outside the given range   */
struct node* remove_keys_out_of_range(struct node* root,int min,int max)
{

	if(root==null)
		return;
	root->left=remove_keys_out_of_range(root->left,min,max);
	root->right=remove_keys_out_of_range(root->right,min,max);
	if(root->val < min)
	{
		struct node* r_child=root->right;
		free(root);
		return r_child;
	}
	if(root->val > max)
	{
		struct node* l_child=root->left;
		free(root);
		return l_child;
	}
	return root;
}

/* Level Order Tree Traversal */
void level_order_traversal(struct node* root,int level)
{
	if(root==null)
		return;
	if(level==1)
		printf("%d",root->val);
	else if(level > 1)
	{
		level_order_traversal(root->left,level-1);
		level_order_traversal(root->right,level-1);
	}
}


void print_tree(struct node* root)
{
	int h=height(root);
	int i;
	for(i=1;i<=h;i++)
	{
		level_order_traversal(root,i);
	}
}

/* Using Queue Level Order Traversal 
	
void print_level_order_traversal(struct node* root)
{
	struct queue* q=createQueue(SIZE);
	struct node* temp=root;
	q.enqueue(temp->data);
	while(temp)
	{
		
		printf("%d",q.dequeue);
		if(temp->left)
		{
			q.enqueue(temp->left->val);
			temp=temp->left;
		}
		if(temp->right)
		{
			q.enqueue(temp->right->val);
			temp=temp->right;
		}
	}
}
struct node** createQueue(int *front, int *rear)
{
  struct node **queue =
   (struct node **)malloc(sizeof(struct node*)*MAX_Q_SIZE);  
 
  *front = *rear = 0;
  return queue;
} 
 
void enQueue(struct node **queue, int *rear, struct node *new_node)
{
  queue[*rear] = new_node;
  (*rear)++;
}     
 
struct node *deQueue(struct node **queue, int *front)
{
  (*front)++;
  return queue[*front - 1];
}     
 
*/
/* Dynamic Programming | Set 26 (Largest Independent Set Problem)  */

int lis(struct node* root)
{
	if(root==null)
		return 0;
	if(root->size)
		return root->size;
	if(root->left==null && root->right==null)
		root->size=0;
	int exclsv=lis(root->left) + lis(root->right);
	int iclsv=1;
	if(root->left)
		iclsv+=lis(root->left->left) + lis(root->left->right);
	if(root->right)
		iclsv+=lis(root->right->left) + lis(root->right->right);

	root->size=max(exclsv,iclsv);

	return root->size;
}
main()
{
}

	

	
	

 
