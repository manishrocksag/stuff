#include<stdio.h>
#include<conio.h>
void main()
{       int n,p,c[10][10],r[10][10],path[10],min,i,j,o=1,f[10][10];
	clrscr();
	printf("enter the no. of vertices");
	scanf("%d",&n);
	printf("enter the augmented matrix\n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			scanf("%d",&c[i][j]);
		}
	}
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			r[i][j]=c[i][j];
		}
	}
	/*
	do
	{
		printf("enter the length of the path\n");
		scanf("%d",&p);
		printf("enter the path");
		for(i=1;i<=p;i++)
		{
			scanf("%d",&path[i]);
		}
		printf("enter the min value\n");
		scanf("%d",&min);
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			r[path[i]][path[i+1]]=(r[i][j]-min);
			r[path[i+1]][path[i]]=(r[i][j]+min);
		}
	}
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("%d",r[i][j]);
		}
	printf("\n");
	}
	printf("do you want to continue??\n");
	scanf("%d",&o);
	}
	while(o==1);
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			f[i][j]=c[i][j]-r[i][j];
		}
	}
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			if(f[i][j]<0)
			{
				f[i][j]=0;
			}
		}
	}
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("%d",f[i][j]);
		}
		printf("\n");
	}
getch();
}
*/
