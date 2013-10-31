#include<stdio.h>
#include<conio.h>
void main()
{
	int c[20][20],rc[20][20],n,v,path[20],src;
	int i,j,pos,mark[20],nxt_v,sink;
	clrscr();

	printf("\n enter the no. of vertices:");
	scanf("%d",&n);

	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			rc[i][j]=0;
		}
	}
	rc[1][2]=2;
	rc[1][3]=3;
	rc[2][4]=1;
	rc[3][4]=4;
	rc[3][5]=2;
	rc[3][6]=6;
	rc[4][2]=2;
	rc[5][6]=2;
	printf("\n enter the source node:");
//	scanf("%d",&src);
	src=1;
	for(i=1;i<=n;i++)
	{
		path[i]=-1;
		mark[i]=0;
	}
	pos=1;
	path[pos]=src;
	mark[src]=1;
	sink=n;
	while(pos>=1 && path[pos]!=sink)
	{
		v=path[pos];
		nxt_v=-1;
		for(i=1;i<=n;i++)
		{
			if(mark[i]==0 && rc[v][i]>0 )
				nxt_v=i;
		}
		if(nxt_v!=-1)
		{
			pos++;
			path[pos]=nxt_v;
			mark[nxt_v]=1;
		}
		else
		{
			path[pos]=-1;
			pos--;
		}
		printf("%d  ",pos);
		getch();

	}
	if(pos<0)
		printf("\n no path from %d to %d:",src,sink);
	else
	{
		printf("\n path from %d to %d:",src,sink);
		for(i=1;i<=pos;i++)
			printf("\t path is %d:",path[i]);
	}
	getch();
}














