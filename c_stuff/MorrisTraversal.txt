/* Morris Traversal for inorder */

void inorder_morris_traversal(struct node* root)
{
	struct node* current=root;
	struct node* prev=null;
	while(root)
	{
		if(current->left==null)
		{
			printf("%d",current->data);
			current=current->right;
		}
		else
		{
			pre=current->left;
			while(pre->right!=null && pre!=current)
			{
				pre=pre->right;
			}
			if(pre->right==null)
			{
				pre->right=current;
				current=current->left;	
			}
			else
			{
				pre->right=null;
				printf("%d",current->data)'
				current=current->right;
			}
		}
	}
}

void morrisTraversalPreorder(struct node* root)
{
    while (root)
    {
        if (root->left == NULL)
        {
            printf( "%d ", root->data );
            root = root->right;
        }
        else
        {
            struct node* current = root->left;
            while (current->right && current->right != root)
                current = current->right;
            if (current->right == root)
            {
                current->right = NULL;
                root = root->right;
            }
 
            else
            {
                printf("%d ", root->data);
                current->right = root;
                root = root->left;
            }
        }
    }
}