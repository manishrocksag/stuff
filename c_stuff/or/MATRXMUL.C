#include<conio.h>
#include<stdio.h>
void print(int,int);
void matrixchain(int [],int);
int m[100][100],s[100][100];
void main()
{
	int i,j,p[100],n;
	clrscr();
	printf("enter the no. matrix");
	scanf("%d",&n);
	printf("\nEnter the dimension\n");
	for(i=0;i<=n;i++)
	scanf("%d",&p[i]);
	matrixchain(p,n);
	printf("\nEnter the cost matrix\n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("\t%d",m[i][j]);
		}
		printf("\n");
	}
	printf("\nSequence matrix\n");
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n;j++)
		{
			printf("\t%d",s[i][j]);
		}
		printf("\n");
	}
	print(1,n);
	printf("\n\n cost of matrix multiplication= %d",m[1][n]);
	getch();
	}
	void matrixchain(int p[],int n)
	{
		int i,j,k,l,q;
		for(i=1;i<=n;i++)
		{
			m[i][i]=0;
		}
	  for(l=2;l<=n;l++)
	  {
		for(i=1;i<=n-l+1;i++)
		{
			j=i+l-1;
			m[i][j]=9999;
			for(k=i;k<=j-1;k++)
			{
				q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
				if(q<m[i][j])
			       {	m[i][j]=q;
				s[i][j]=k;
				}
			}
		}
	       }
	}
	void print(int i,int j)
	{
		if(i==j)
		{
		printf("a%d",i);
		}
		else
		{
			printf("(");
			print(i,s[i][j]);
			print((s[i][j]+1),j);
			printf(")");
		}
	}


