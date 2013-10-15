/* Diameter of a Binary Tree */


int diameter(struct node* root)
{
	int ld=0,rd=0,lh=0,rh=0;

	if(root==null)
		return 0;
	lh=height(root->left);
	rh=height(root->right);

	ld=diameter(root->left);
	rd=diameter(root->right);

	return max(lh+rh+1,max(ld,rd));
}

int tree_diameter(struct node* root,int *height)
{
	int ld=0,rd=0,lh=0,rh=0;
	if(root==null)
		return 0;

	ld=tree_diameter(root->left,&lh);
	rd=tree_diameter(root->right,&rh);

	*height=max(lh,rh)+1;

	return max(max(ld,rd),lh+rh+1);

}