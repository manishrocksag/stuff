/*  Given an array of of size n and a number k, find all elements that appear more than n/k times
*/

struct eleCount
{
	int ele;
	int count;
}
void more_than_k(int arr[],int n,int k)
{
	struct eleCount temp[k-1];
	if(k<2)
		return;
	int i;

	for(i=0;i<k-1;i++)
		temp[i].count=0;

//process all elements

for(i=0;i<n;i++)
{
	int j;
	for(j=0;j<k-1;j++)
	{
		if(temp[j].ele==arr[i]
		{
			temp[j].count+=1;
			break;
		}
	}
	if(j==k-1)
	{
		int l;
		for(l=0;l<k-1;l++)
		{
			if(temp[l].count==0)
			{
				temo[l].ele=arr[i];
				temp[l].count+=1;
				break;
			}
		}
		if(l==k-1)
			for(l=0;l<l-1;l++)
				temp[l].coumt-=1;
	}
}
for(i=0;i<k-1;i++)
{
	int ac=0;
	for(j=0;j<n;j++)
		if(arr[j]==temp[i].e)
			ac++;
	if(ac > n/k)
		printf("%d",arr[j]);
}
}

	

	
