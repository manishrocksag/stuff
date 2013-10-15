/* Construct BST from given preorder traversal */

struct node* tree_construct(int arr[],int low,int high,int *preIndex,int size)
{
	if(*preIndex >=size || low>high)
		return null;
	struct node* root=newNodeode(arr[*preIndex]);
	*preIndex=*preIndex+1;
	if(low==high)
		return root;
	int i;
	for(i=low;i<=high;i++)
		if(arr[i]>root->val)
				break;
	root->left=tree_construct(arr,*preIndex,i-1,preIndex,size);
root->right=tree_construct(arr,i,high,preIndex,size);

}

struct node* constructTreeUtil( int pre[], int* preIndex, int key,
                                int min, int max, int size )
{
    // Base case
    if( *preIndex >= size )
        return NULL;
  
    struct node* root = NULL;
    if( key > min && key < max )
    {
        root = newNode ( key );
        *preIndex = *preIndex + 1;
         
        if (*preIndex < size)
        {
            root->left = constructTreeUtil( pre, preIndex, pre[*preIndex],
                                        min, key, size );
            root->right = constructTreeUtil( pre, preIndex, pre[*preIndex],
                                         key, max, size );
        }
    }
  
    return root;
}

Node* constructTree ( int pre[], int size )
{
    // Create a stack of capacity equal to size
    Stack* stack = createStack( size );
 
    // The first element of pre[] is always root
    Node* root = newNode( pre[0] );
 
    // Push root
    push( stack, root );
 
    int i;
    Node* temp;
 
    // Iterate through rest of the size-1 items of given preorder array
    for ( i = 1; i < size; ++i )
    {
        temp = NULL;
 
        /* Keep on popping while the next value is greater than
           stack's top value. */
        while ( !isEmpty( stack ) && pre[i] > peek( stack )->data )
            temp = pop( stack );
 
        // Make this greater value as the right child and push it to the stack
        if ( temp != NULL)
        {
            temp->right = newNode( pre[i] );
            push( stack, temp->right );
        }
 
        // If the next value is less than the stack's top value, make this value
        // as the left child of the stack's top node. Push the new node to stack
        else
        {
            peek( stack )->left = newNode( pre[i] );
            push( stack, peek( stack )->left );
        }
    }
 
    return root;
}

struct node* constructTreeUtil (int pre[], int post[], int* preIndex,
                                int l, int h, int size)
{
    if (*preIndex >= size || l > h)
        return NULL;
    struct node* root = newNode ( pre[*preIndex] );
    ++*preIndex;
    if (l == h)
        return root;
 
    // Search the next element of pre[] in post[]
    int i;
    for (i = l; i <= h; ++i)
        if (pre[*preIndex] == post[i])
            break;
    if (i <= h)
    {
        root->left = constructTreeUtil (pre, post, preIndex, l, i, size);
        root->right = constructTreeUtil (pre, post, preIndex, i + 1, h, size);
    }
 
    return root;
}
 

 
 
	