/* Convert a BST into sum tree which holds the children sum property */

void sum_tree(struct node* root)
{
	int rsum=0,lsum=0,diff;
	if(root==null||root->left==null&&root->right==null)
		return null;

	sum_tree(root->left);
	sum_tree(root->right);

	if(root->left)
		lsum=lsum+root->left->val;
	if(root->right)
		rsum=rsum+root->right->val;

	diff=(lsum+rsum)-root->data;

	if(diff>0)
		root->data=root->data + diff;
	if(diff<0)
		increment(root,-diff);
}
void increment(struct node* root,int diff)
{
	if(root->left)
	{
		root->left->data=root->left->data + diff;
		increment(root->left,diff);
	}
	else if(root->right)
	{
		root->right->data=root->right->data + diff;
		increment(root->right,diff);
	}
}

/* check children sum property */

int check_sum_tree(struct node* root)
{
	int rsum=0,lsum=0,diff;
	if(root==null||root->left==null&&root->right==null)
		return 1;
	else
	{
		if(root->left)
			lsum=lsum+root->left->val;
		if(root->right)
			rsum=rsum+root->right->val;

		diff=(lsum+rsum)-root->data;
		if(diff==0 && check_sum_tree(root->left) && check_sum_tree(root->right))
			return 1;
		else
			return 0;
	
	}
}


