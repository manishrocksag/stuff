#include<conio.h>
#include<stdio.h>
void main()
{
	int a[20][20],c[10][10],n,i,j,k;
	clrscr();
	printf("Enter the no.nodes");
	scanf("%d",&n);
	printf("Enter the cost matrix");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			scanf("%d",&c[i][j]);
		}
	}
	for(i=1;i<=n;i++)
	for(j=1;j<=n;j++)
	a[i][j]=c[i][j];
	for(k=1;k<=n;k++)
	{

		for(i=1;i<=n;i++)
		{
			printf("\n");
			for(j=1;j<=n;j++)
			{
				if(a[i][j]>(a[i][k]+a[k][j]))
				a[i][j]=a[i][k]+a[k][j];
				if(k==n)
				{
				printf("\n a[%d][%d]+a[%d][%d]",i,k,k,j);
				printf("\t %d",(a[i][k]+a[k][j]));
				}
			}
		}

	}
	 printf(" \nmatrix");
	 for(i=1;i<=n;i++)
	 {
		printf("\n");
		for(j=1;j<=n;j++)
		{
			printf("%d",a[i][j]);
		}

	 }
	 getch();

	 }


