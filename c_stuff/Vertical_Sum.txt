/* Vertical Sum in a given Binary Tree */

void vertical_sum(struct node* root,HashMap h,int hD)
{
	if(root==null)
		return;
	vertical_sum(root->left,h,hD-1);

	int prevSum=(h.get(hD)==null)?0:hd.get(hD);
	h.put(hD,prevSum + root->data);

	vertical_sum(root->right,h,hD+1);
}

int sum_tree(struct node* root)
{
	if(root==null)
		return 0;
	int old_data=root-val;

	root->data=sum_tree(root->left) + sumTree(root->right);

	return old_data + root->data;
}