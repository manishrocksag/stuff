void swapped_nodes(struct node* root,struct node** prev,struct node** first,struct node** middle,struct node** last)
{
	if(root)
	{
		swapped_nodes(root->left,prev,first,middle,last);
		if(*prev && root->data < *prev->data)
		{
			if(!*first)
			{
				*first=*prev;
				*middle=root;
			}
			*last=root;
		}
		*prev=root;
		swapped_nodes(root->right,prev,first,middle,last);
}
void correctBST( struct node* root )
{
    struct node *first, *middle, *last, *prev;
    first = middle = last = prev = NULL;
 
    // Set the poiters to find out two nodes
    swapped_nodes( root,&prev,&first, &middle, &last );
 
    if( first && last )
        swap( &(first->data), &(last->data) );
    else if( first && middle ) // Adjacent nodes swapped
        swap( &(first->data), &(middle->data) );
}
		