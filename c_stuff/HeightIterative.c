/* find the height of the tree without using recursion */

int height(struct node* root,Queue q)
{
	if(root==null)
		return 0;
	q.enqueue(root);
	int height=0;

	while(1)
	{
		int node_count=q.size();
		if(node_count==0)
			return height;
		
		height++;
		while(node_count > 0)
		{
			Node temm=q.dequeue();

			if(temp->left)
				q.enqueue(temp->left);
			if(temp->right)
				q.enqueue(temp->right);
			node_count--;
		}
	}
}
			
		
		