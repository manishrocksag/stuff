#include<conio.h>
#include<stdio.h>
void main ()
{
	int n,u,len[20][20],count,i,j,k,m,t,d[20][20],a[20];
	clrscr();
	printf("Enter the no.of nodes");
	scanf("%d",&n);
	printf("Enter the connection matrix");
	for(i=1;i<=n;i++)
	for(j=1;j<=n;j++)
	scanf("%d",&d[i][j]);
	for(i=1;i<=m;i++)
	{
		len[1][i]=d[1][i];
	}
	for(k=2;k<=n;k++)
	for(j=1;j<=n;j++)
	{
		count=0;
		for(i=1;i<=n;i++)
		{
			if(i!=j)
			{
				count++;
				a[count]=len[k-1][i]+ d[i][j];
			}
		}
	t=999;
	for(i=1;i<=count;i++)
	{
		if(t<a[i])
		t=t;
		else
		t=a[i];
	}
		if(len[k-1][j]<t)
		len[k][j]=len[k-1][j];
		else
		len[k][j]=t;
	}
	printf("\n resultant matrix is \n");
	for(k=1;k<n;k++)
	{
		for(j=1;j<=n;j++)
		{
			printf("%2d",len[k][j]);
			if (len[n-1][j]=len[n-2][j])
		{
		printf("there is no negative loop ");
		}
		else
		{
		printf("there is negative loop");
		}
		}
	printf("\n");

	}
	getch();
	}

