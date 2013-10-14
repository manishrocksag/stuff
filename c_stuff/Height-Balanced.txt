/* Check if the given BST is height balanced or not */

int is_balanced(struct node* root,int *height)
{
	int l=0,r=0;
	int lh=0,rh=0;
	if(root==null){
		*height=0;
		 return 0;
	}
	l=is_balanced(root->left,&lh);
	r=is_balanced(root->right,&rh);

	*height=max(lh>rh?lh:rh)+1;

	if((lh-rh >=2)||(rh-lh>=2))
		return 0;
	else
		return l&&r;
}

int is_height_balanced(struct node* root)
{
	if(root==null)
		return 1;
	int lh,rh;
	lh=is_height_balanced(root->left);
	rh=is_height_balanced(root->right)

	if(abs(lh-rh)<=1 && is_height_balanced(root->left) && is_height_balanced(root->right))
		return 1;
	else
		return 0;
}
	
	

	