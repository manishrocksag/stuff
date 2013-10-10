/* Check if a binary tree is subtree of another binary tree */

int is_sub_tree(struct node* T,struct node* S)
{
	if(T==null)
		return 0;
	if(S==null)
		return 1;

	if(isSame(T,S))
		return 1;
	return is_sub_tree(T->left,S)||is_sub_tree(T->right,S);
}
	