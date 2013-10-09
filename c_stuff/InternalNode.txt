/* Check if each internal node of a BST has exactly one child */

int internal_node(int arr[],int size)
{
	int i,next_i,last_i;
	for(i=0;i<size-1;i++)
	{
		next_i=arr[i]-arr[i+1];
		last_i=arr[i]-arr[size-1]
		if(next_i*last_i<0)
			return 0;
	}
	return 1;
}

int internal_node_child(int arr[],int size)
{
	int i,max,min;
	if(arr[size-1]>arr[size-2])
	{
		max=arr[size-1]
		min=arr[size-2]
	}
	else
	{
		max=arr[size-2]
		min=arr[size-1]
	}
	for(i=size-3;i>=0;i--)
	{
		if(arr[i]<min)
			min=arr[i]
		else if(arr[i]>max)
			max=arr[i]
		else
			return 0;
	}
	return 1;
}