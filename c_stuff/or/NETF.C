#include<stdio.h>
#include<conio.h>
void main()
{
	int n,i,j,c[10][10],p[10],m[10],sink,pas,v,n_v,r[10][10];
	clrscr();
	printf("enter the no. of nodes\n");
	scanf("%d",&n);
	printf("enter the matrix\n");
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

	for(i=1;i<=n;i++)
	{
		p[i]=-1;
		m[i]=0;
	}
	pas=1;
	p[pas]=1;
	sink=n;
	while(pas>=1 && p[pas]!=sink)
	{
	v=p[pas];
	n_v=-1;
	for(i=1;i<=n;i++)
	{
		if(m[i]==0 && r[v][i]>0)
		n_v=i;
	}
	if(n_v!=-1)
	{
		pas++;
		p[pas]=n_v;
		m[n_v]=1;
	}
	else
	{
		p[pas]=-1;
		pas--;
	}
	}
	for(i=1;i<=pas;i++)
	printf("%d\t",p[i]);
	getch();
}











