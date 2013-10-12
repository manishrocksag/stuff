/* Get Level of a node in a Binary Tree */

int get_level_node(struct node* root,struct node* node,int level)
{
	if(root==null)
		return 0;
	if(root->data==node->data)
		return level;
	int downLevel=get_level_node(root->left,node,level+1);
	if(downLevel!=0)
		return downLevel;
	downLevel=get_level_node(root->right,node,level+1);
		return downLevel;
}