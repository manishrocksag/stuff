#include<stdio.h>
#include<conio.h>
void main()
{
	int c[20][20],rc[20][20],n,nv,path[20];
	int i,j,flag=1,f[20][20],mf;
	clrscr();
	printf("\n enter the no. of vertices:");
	scanf("%d",&n);
	printf("\n enter the capacity matrix:");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			scanf("%d",&c[i][j]);
			rc[i][j]=c[i][j];
		}
	}
	printf("\n the residual matrix is:");
	for(i=1;i<=n;i++)
	{
		printf("\n");
		for(j=1;j<=n;j++)
		{
			printf("\t %d",rc[i][j]);
		}
	}
      do
	{
		printf("\n enter the no. of vertices in augmenting path:");
		scanf("%d",&nv);
		printf("\n enter the path:");
		for(i=1;i<=nv;i++)
		{
			scanf("%d",&path[i]);
		}
		printf("\n enter minimum flow:");
		scanf("%d",&mf);
		for(i=1;i<nv;i++)
		{
			rc[path[i]][path[i+1]]=rc[path[i]][path[i+1]]-mf;
			rc[path[i+1]][path[i]]=rc[path[i+1]][path[i]]+mf;
		}
		for(i=1;i<=n;i++)
		{
			printf("\n");
			for(j=1;j<=n;j++)
			{
				printf("\t %d",rc[i][j]);
			}
		}
		printf("\n enter the value of flag:");
		scanf("%d",&flag);
	  }while(flag);
	  for(i=1;i<=n;i++)
	  {
		for(j=1;j<=n;j++)
		{
			f[i][j]=c[i][j]-rc[i][j];
			if(f[i][j]<0)
				f[i][j]=0;
		}
	  }
	  printf("\n the flow matrix is:");
	  for(i=1;i<=n;i++)
	  {
		printf("\n");
		for(j=1;j<=n;j++)
		{
			printf("\t %d",f[i][j]);
		}
	  }
	getch();
}














