#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
void main()
{
	int m,n,i,j,xb[10];
	float cb[10],smp[10][10],c[10],min,min_r,diff[10],z[10],sum,pivot,factor;
	int flag=0,c_pos,r_pos;
	clrscr();
	printf("\n enter the no. of equations:");
	scanf("%d",&m);
	printf("\n enter the no. of variables:");
	scanf("%d",&n);
	printf("\n enter the simplex matrix:");
	for(i=0;i<=m-1;i++)
	{
		for(j=0;j<=n;j++)
		{
			scanf("%f",&smp[i][j]);
		}
	}
	printf("\n enter the weights:");
	for(i=1;i<=n;i++)
		scanf("%f",&c[i]);
	printf("\n enter the xb values:");
	for(i=0;i<m;i++)
		scanf("%d",&xb[i]);
	while(1)
	{
		for(i=0;i<=m-1;i++)
		{
			cb[i]=c[xb[i]];
		}
		flag=0;
		for(i=1;i<=n;i++)
		{
			sum=0.0;
			for(j=0;j<m;j++)
			{
				sum=sum+smp[j][i]*cb[j];
			}
			z[i]=sum;
			diff[i]=z[i]-c[i];
			if(diff[i]<0)
				flag=1;
		}
		if(flag==1)
		{
			min=9999;
			for(i=1;i<=n;i++)
			{
				if(diff[i]<min)
				{
					min=diff[i];
					c_pos=i;
				}
			}

			min_r=9999;
			r_pos=-1;
			for(i=0;i<=m-1;i++)
			{
			       if(smp[i][c_pos]>0)
			       {
					if(min_r>(smp[i][0]/smp[i][c_pos]))
					{
						min_r=(smp[i][0]/smp[i][c_pos]);
						r_pos=i;
					}

			       }
			}
			if(r_pos==-1)
			{
				printf("\nunbounded solution");
				exit(0);
				getch();
			}

			pivot=smp[r_pos][c_pos];
			for(i=0;i<=n;i++)
			{
				smp[r_pos][i]=smp[r_pos][i]/pivot;
			}
			for(i=0;i<m;i++)
			{
				if(i!=r_pos)
				{
					factor=smp[i][c_pos];
					for(j=0;j<=n;j++)
					{
						smp[i][j]-=(factor*smp[r_pos][j]);
					}
				}
			}
			xb[r_pos]=c_pos;

			printf("rpos: %d   cpos: %d\n",r_pos,c_pos);
			printf("\n the cb matrix is:");
		for(i=0;i<m;i++)
		printf("%6.2f  ",cb[i]);
		printf("\n the xb matrix is:");
		for(i=0;i<m;i++)
			printf("%d \t",xb[i]);
		printf("\n the simplex matrix is:");
		for(i=0;i<=m-1;i++)
		{
			printf("\n");
			for(j=0;j<=n;j++)
			{
				printf("%6.2f  ",smp[i][j]);
			}
		}
		printf("\n the difference matrix is:");
		for(i=1;i<=n;i++)
			printf("%6.2f  ",diff[i]);
		printf("\n");
		printf("\n");



	       }

	else
	{

		printf("\n the cb matrix is:");
		for(i=0;i<m;i++)
		printf("%f \t",cb[i]);
		printf("\n the xb matrix is:");
		for(i=0;i<m;i++)
			printf("%d \t",xb[i]);
		printf("\n the simplex matrix is:");
		for(i=0;i<=m-1;i++)
		{
			printf("\n");
			for(j=0;j<=n;j++)
			{
				printf("%f \t",smp[i][j]);
			}
		}
		printf("\n the difference matrix is:");
		for(i=1;i<=n;i++)
			printf("%f \t",diff[i]);
		printf("\n");
		printf("\n");
		break;
	}

	getch();
     }
	sum=0.0;
	printf("\n the solution is:");
	for(i=0;i<m;i++)
	{
		sum+=c[xb[i]]*smp[i][0];
	}
	printf("\n the sum is %f",sum);
	getch();
}


