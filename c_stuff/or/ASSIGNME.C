#include<stdio.h>
#include<conio.h>
void main()
{
	int i,j,k,l,s,t,a[4][4],m,n,o,p;
	clrscr();
	printf("ENTER THE ARRAY ELEMENTS:\n");
	for(i=0;i<4;i++)
	{
		for(j=0;j<4;j++)
		{
			scanf("%d",&a[i][j]);
		}
	}
	t=2345;
	for(i=0;i<4;i++)
	{
		for(j=0;j<4;j++)
		{
			for(k=0;k<4;k++)
			{
				for(l=0;l<4;l++)
				{
					if(i!=j && j!=k && k!=l && l!=i && i!=k && j!=l)
					{
						s=a[0][i]+a[1][j]+a[2][k]+a[3][l];
						if(s<t)
						{
						t=s;
						m=i+1;
						n=j+1;
						o=k+1;
						p=l+1;
						}
					}
				}
			}
		}
	}
	printf("THE LEAST COST IS %d\n",t);
	printf("THE ASSIGNMENTS ARE:\n");
	printf("A->%d\nB->%d\nC->%d\nD->%d\n",m,n,o,p);
	getch();
}


