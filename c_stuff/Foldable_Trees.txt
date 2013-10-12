/* Foldable Binary Trees */

int is_foldable(struct node* root)
{
	if(root==null)
		return 1;
	mirror(root->left);
	res=is_same_structure(root->left,root->right);
	mirror(root->right);

	return res;
}

int isStructSame(struct node *a, struct node *b)
{
  if (a == NULL && b == NULL)
  {  return true; }
  if ( a != NULL && b != NULL &&
       isStructSame(a->left, b->left) &&
       isStructSame(a->right, b->right)
     )
  {  return 1; }
 
  return 0;
}

bool IsFoldable(struct node *root)
{
     if (root == NULL)
     {  return true;  }
 
     return IsFoldableUtil(root->left, root->right);
}
 
/* A utility function that checks if trees with roots as n1 and n2
  are mirror of each other */
int IsFoldableUtil(struct node *n1, struct node *n2)
{
    /* If both left and right subtrees are NULL,
      then return true */
    if (n1 == NULL && n2 == NULL)
    {  return 1;  }
 
    /* If one of the trees is NULL and other is not,
      then return false */
    if (n1 == NULL || n2 == NULL)
    {  return 0; }
 
    /* Otherwise check if left and right subtrees are mirrors of
       their counterparts */
    return IsFoldableUtil(n1->left, n2->right) &&
           IsFoldableUtil(n1->right, n2->left);
}