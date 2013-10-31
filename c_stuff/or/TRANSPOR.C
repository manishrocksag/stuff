#include<stdio.h>
#include<conio.h>
void main()
{
	int a[10][10],s[10],d[10],m,n,i,j,sum=0,sum1=0,sum2=0,c[10][10];

	clrscr();
	printf("ENTER THE NO. OF SOURCE\n");
	scanf("%d",&m);
	printf("ENTER THE NO. OF DESTINATION\n");
	scanf("%d",&n);
	printf("ENTER THE MATRIX:\n");
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			scanf("%d",&a[i][j]);
		}
	}
	printf("ENTER THE SUPPLY ONE BY ONE");
	for(i=0;i<m;i++)
	{
		scanf("%d",&s[i]);
	}
	printf("ENTER THE DEMAND ONE BY ONE");
	for(i=0;i<n;i++)
	{
		scanf("%d",&d[i]);
	}
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			c[i][j]=0;
		}
	}
	for(i=0;i<m;i++)
	{
		sum1=sum1+s[i];
	}
	for(i=0;i<n;i++)
	{
		sum2=sum2+d[i];
	}
	if(sum1!=sum2)
	{
		printf("THE DEMAND IS NOT EQUAL TO THE SUPPLY.\n");
	}
	else
	{
		i=0;
		j=0;
		while(i<m && j<n)
		{
				if(s[i]<d[j])
				{
					d[j]=d[j]-s[i];
					c[i][j]=s[i];
					sum=sum+(s[i]*a[i][j]);
					i++;
				}
				else if(d[j]<s[i])
				{
					s[i]=s[i]-d[j];
					c[i][j]=d[j];
					sum=sum+(d[j]*a[i][j]);
					j++;
				}
				else
				{
					c[i][j]=d[j];
					sum=sum+(d[j]*a[i][j]);
					i++;
					j++;
				}
			}
		}
		printf("the matrix is:\n");
		for(i=0;i<m;i++)
		{
		for(j=0;j<n;j++)
			{
			printf("%d\t",c[i][j]);
			}
		printf("\n");
	}

	printf("the total cost is %d",sum);
	getch();
}