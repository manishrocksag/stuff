
/* Floor and Ceiling in BST */
 int ceil_search(struct node* root,int input)
 {
	if(root==null)
		return -1;
	if(input==root->val)
		return root->val;
	if(input > root->val)
		return ceil_search(root->right,input);
	int ceil=ceil_search(root->left,input);
	
	return (ceil>=input)?ceil:root->key;
}

int floor_search(struct node* root,int input)
{
	if(root==null)
		return -1;
	if(input==root->val)
		return root->val;
	if(input < root->val)
		return floor_search(root->left,input);
	int floor=floor_search(root->right);

	return (fllor<=input && floor!=-1)?floor:root->key;
}
