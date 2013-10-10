/* Print nodes at k distance from root   */

void _print_nodes(sruct node* root,int k)
{
	if(root==null)
		return;
	if(k==0)
		printf("%d",root->data);

	_print_nodes(root->left,k-1);
	_print_nodes(root->right,k-1);

}