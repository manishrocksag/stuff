/* Print Ancestors of a given node in Binary Tree */

int print_ancestors(struct node* root,int target)
{
	if(root==null)
		return 0;
	if(root->data==target)
		return 1;
	if(print_ancestors(root->left,target)||print_ancestors(root->right,target))
{
	printf("%d",root->data);
	return 1;
}
return 0;
}