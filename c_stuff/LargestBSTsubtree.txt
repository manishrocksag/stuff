/* Largest BST Subtree */
int largest_subtree(struct node* root)
{
	if(root==null)
		return 0;
	if(is_bst(root))
		return size(root);
	else
		return max(largest_subtree(root->left),largest_subtree(root->right));
}

/* Connect Nodes at same level */

void connect_same_level(struct node* root)
{
	if(!root)
		return;
	if(root->left)
		root->left->next_right=root->right;
	if(root->right)
		root->right->next_right=(root->next_right)?root->next_right->left:null;

	connect_same_level(root->left);
	connect_same_level(root->right);

}