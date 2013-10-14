/* Find the maximum sum leaf to root path in a Binary Tree */

struct node* max_sum_leafPath(struct node* root,int* max_sum,int sum,struct node* target)
{
	if(root==null)
		return;
	sum=sum+root->data;
	if(root->left==null && root->right==null)
	{
		if(sum > *max_sum)
		{
			*max_sum=sum;
			*target=root;
		}
	}
	max_sum_leafPath(root->left,max_sum,sum,target);
	max_sum_leafPath(root->right,max_sum,sum,target);
}
int print_leaf_path(struct node* root,struct node* target)
{
	if(root==null)
		return;
	if(root==target||print_leaf_path(root->left,target)||print_leaf_path(root->right,target)
{
		print root->data;
		return 1;
}
return 0;
}
	
	
