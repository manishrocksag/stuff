/* Inorder Tree Traversal without Recursion */

1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = current->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.

void inorder_traversal(struct node* root)
{
	if(root==null)
		return;
	struct sNode* s=null;
	struct node* current=root;
	int done=0;
	while(!done)
	{
		if(current!=null)
		{
			s.push(current->val);
			current=current->left;
		}
		else
		{
			if(!isEmpty(s))
			{
				current=s.pop();
				printf("%d",current->data);
				current=current->right;
			}
			else
			{
				done=1;
			}
		}
	}
}

/* Iterative Preorder Traversal */

1) Create an empty stack nodeStack and push root node to stack.
2) Do following while nodeStack is not empty.
….a) Pop an item from stack and print it.
….b) Push right child of popped item to stack
….c) Push left child of popped item to stack

void preorder_traversal(struct node* root)
{
	if(root==null)
		return;
	Stack s;
	s.push(root);
	while(!isEmpty(s))
	{
		printf("%d",root=s.pop());
		if(root->right)
			push(root->right);
		if(root->left)
			push(root->left);
	}
}

/* Iterative Postorder Traversal */

1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack

void postOrderIterative(struct Node* root)
{
    // Create two stacks
    struct Stack* s1 = createStack(MAX_SIZE);
    struct Stack* s2 = createStack(MAX_SIZE);
 
    // push root to first stack
    push(s1, root);
    struct Node* node;
 
    // Run while first stack is not empty
    while (!isEmpty(s1))
    {
        // Pop an item from s1 and push it to s2
        node = pop(s1);
        push(s2, node);
 
        // Push left and right children of removed item to s1
        if (node->left)
            push(s1, node->left);
        if (node->right)
            push(s1, node->right);
    }
 
    // Print all elements of second stack
    while (!isEmpty(s2))
    {
        node = pop(s2);
        printf("%d ", node->data);
    }
}

1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child 
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.

