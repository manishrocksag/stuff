/* Find two Numbers in a BST which pairs to a given sum */

int is_pair_present(struct node* root,int target)
{
	if(root==null)
		return 0;

	struct stack *s1;
	struct stack* s2;

	struct node* cur1=root;
	struct node* cur2=root;
	int val1=0,val2=0;
while(1)
{
	while(!done1)
	{
		if(cur1!=null)	
		{
			s1.push(cur1->data);
			cur1=cur1->left;
		}
		else
		{
			if(!isEmpty(s1))
			{
				cur1=s1.pop();
				val1=cur1->val;
				cur1=cur1->right;
				done1=1;
			}
			else
				done1=1;
		}
	}
	while(!done2)
	{
		if(cur2=null)	
		{
			s2.push(cur2->data);
			cur2=cur2->right;
		}
		else
		{
			if(!isEmpty(s2))
			{
				cur2=s2.pop();
				val2=cur2->val;
				cur2=cur2->left;
				done2=1;
			}
			else
				done2=1;
		}
	}
	if(val1!=val2 && val1 + val2==target)
	{
		printf("pair found %d and %d",val1,val2);
		return 1;
	}
	else if(val1 + val2 < target)
		done1=0;
	else if(val1 + val2 < target) 
		done2=0;
	if(val1 >=val2)
		return 0;
  }
}
		


	
		