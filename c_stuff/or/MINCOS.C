#include<stdio.h>
#include<conio.h>
void main()
{
	int d[10],s[10],i,j,m,n,cost=0,flag,r,c1,min;
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



	flag=1;
	while(flag)
	{
		min=329;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				if(s[i]!=0 && d[j]!=0)
				{
					if(c[i][j]<min)
					{
						min=c[i][j];
						r=i;
						c1=j;
					}
				}
		       }
		}
		if(s[r]<=d[c1])
		{
			a[r][c1]=s[r];
			d[c1]-=s[r];
			s1-=s[r];
			s[r]=0;
		}
		else
		{
			a[r][c1]=d[c1];
			s[r]-=d[c1];
			s1-=d[c1];
			d[c1]=0;
		}


			if(s1==0)
			flag=0;


       }
	for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				cost+=a[i][j]*c[i][j];
				printf("\n allocation is %d:",a[i][j]);
			}
		 }
			printf("\n cost is%d:",cost);
	}
       getch();
}







