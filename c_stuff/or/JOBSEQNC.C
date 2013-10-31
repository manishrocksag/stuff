#include<conio.h>
#include<stdio.h>
int jobseq(int d[6],int j[6],int n)
{
	int q,i,r,k;d[0]=0;
	j[0]=0;
	j[1]=1;
	k=1;
	for(i=2;i<=n;i++)
	{
	r=k;
	while((d[j[r]]>d[i]) && (d[j[r]]!=r))
	r=r-1;
	if((d[j[r]]<=d[i]) && (d[i]>r))
	{
	for(q=k;q>=r+1;q--)
	{
	j[q+1]=j[q];
	}
	j[r+1]=i;
	k=k+1;
	}
	}
	return k;
}
void main()
	{
	int d[6],j[6],p[6],k,i,cost=0,n;
	clrscr();
	printf("Enter the no of jobs:");
	scanf("%d",&n);
	printf("Enter the deadlines:");
	for(i=1;i<=n;i++)
	scanf("%d",&d[i]);
	printf("Enter the profit:");
	for(i=1;i<=n;i++)
	scanf("%d",&p[i]);
	for(i=1;i<=n;i++)
	j[i]=i;
	k=jobseq(d,j,n);
	printf("\n The solution job sequence");
	for(i=1;i<=k;i++)
	{
	printf("\n %d",j[i]);
	cost=cost+p[j[i]];
	}
	printf("\n the total cost %d",cost);
	getch();
	}


