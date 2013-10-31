#include<stdio.h>
#include<conio.h>
void main()
{
	int n,t[10][10] ,l[10],e[10],i,j,max,min,es,ls,ef,lf,tf,ff;
	clrscr();
	printf("ENTER THE NODES:\n");
	scanf("%d",&n);
	printf("ENTER THE ADJECENCY MATRIX\n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			scanf("%d",&t[i][j]);
		}
	}
	e[1]=0;
	for(j=2;j<=n;j++)
	{
		max=-9999;
		for(i=1;i<=(j-1);i++)
		{
			if(max<(e[i]+t[i][j]) && t[i][j]!=-1)
			{
				max=e[i]+t[i][j];

		e[j]=max;
		}
		}
	}
	l[n]=e[n];
	for(i=(n-1);i>1;i--)
	{
		max=-9999;
		for(j=(i+1);i<=n;i++)
		{
			if(max>(l[j]-t[i][j]) && t[i][j]!=-1)
			{
				min=l[j]-t[i][j];

		l[i]=min;
		}

		}
	}
	for(i=1;i<=n;i++)
	printf("forward pass:\t%d",e[i]);
	for(i=1;i<=n;i++)
	printf("backward pass:\t%d",l[i]);
	printf("early start\t");
	printf("early finish\t");
	printf("latest start\t");
	printf("latest finish\t");
	printf("total float\t");
	printf("free float\n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			if(t[i][j]!=-1)
			{
				es=e[i];
				ef=e[i]+t[i][j];
				lf=l[i];
				ls=l[j]-t[i][j];
				tf=ls-es;
				ff=e[j]-ef;
printf("%d\t%d\t%d\t%d\t%d\t%d\n",es,ef,ls,lf,tf,ff);
			}
		}
	}
getch();
}



