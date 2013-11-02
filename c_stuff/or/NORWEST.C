#include<stdio.h>
#include<conio.h>
void main()
{
	int d[10],s[10],i,j,m,n,cost=0;
	int a[10][10],c[10][10],s1=0,s2=0;
	clrscr();
	printf("\n enter the rows and columns:");
	scanf("%d%d",&m,&n);
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			a[i][j]=0;
		}
	}
	printf("\n enter the value of supply:");
	for(i=0;i<m;i++)
	{
		scanf("%d",&s[i]);
		s1=s1+s[i];
	}
	printf("\n enter the value of demand:");
	for(i=0;i<n;i++)
	{
		scanf("%d",&d[i]);
		s2=s2+d[i];
	}
	if(s1!=s2)
		printf("\n demand and supply not equal:");
	else
	{
		printf("\n enter the cost matrix:");
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				scanf("%d",&c[i][j]);
			}
		}

	i=j=0;

	while(i<m && j<n)
	{
		if(s[i]<d[j])
		{
			a[i][j]=s[j];
			d[j]=d[j]-s[i];
			cost+=c[i][j]*s[i];
			i++;
		}
		else
		{
			if(s[i]>d[j])
			{
				a[i][j]=d[j];
				s[i]=s[i]-d[j];
				cost+=c[i][j]*d[j];
				j++;
			}
			else
			{
				a[i][j]=d[j];
				s[i]=s[i]-d[j];
				cost+=c[i][j]*d[j];
				d[j]-=s[i];
				i++;
				j++;
			}
		}
	 }
	 for(i=0;i<m;i++)
	 {
		printf("\n");
		for(j=0;j<n;j++)
		{
			printf("\n the allocation is %d",a[i][j]);
		}
	 }
		printf("\n the cost is %d",cost);
      }
		getch();
}
