#include<stdio.h>
#include<conio.h>
void main()
{
	int a[10][10],s[10],d[10],m,n,i,j,sum=0,sum1=0,sum2=0,rp,cp,c[10][10],min;
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

	while(sum1!=0)
	{       min=678;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				if(s[i]!=0 && d[j]!=0)
				{
					if(a[i][j]<min)
					{
						min=a[i][j];
						rp=i;
						cp=j;
					}
				}
			}
		}
		if(s[rp]<=d[cp])
		{
			sum1-=s[rp];
			d[cp]=d[cp]-s[rp];
			c[rp][cp]=s[rp];
			s[rp]=0;
			sum=sum+(c[rp][cp]*a[rp][cp]);
		}
		else
		{
			sum1-=d[cp];
			s[rp]=s[rp]-d[cp];
			c[rp][cp]=d[cp];
			d[cp]=0;
			sum=sum+(c[rp][cp]*a[rp][cp]);
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