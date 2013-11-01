#include<stdio.h>
#include<conio.h>
void knapsack(int n,float weight[],float profit[],float capacity)
	{
		float x[20],tp=0;
		int i,j,u;
		u=capacity;
		for(i=0;i<n;i++)
		x[i]=0.0;
		for(i=0;i<n;i++)
		{
			if(weight[i]>u)
			break;
			else
			{
				x[i]=1.0;
				tp=tp+profit[i];
				u=u-weight[i];
				}
				}
				if(i<n)
				x[i]=u/weight[i];
				tp=tp+(x[i]*profit[i]);
				printf("\n The result");
				for(i=0;i<n;i++)
				printf("%f\t",x[i]);
				printf("\n Maximum%f",tp);
				}

				void main()
				{
					float weight[20],profit[20],capacity;
					int n,i,j;
					float ratio[20],temp;
					clrscr();
					printf("\nEnter the no. of object");
					scanf("%d",&n);
					printf("\nEnter the weight and profit of each object:");
					for(i=0;i<n;i++)
					{
						scanf("%f%f",&weight[i],&profit[i]);
						}
						printf("\nenter the capacity of knapsack:-");
						scanf("%f",&capacity);
						for(i=0;i<n;i++)
						{
							ratio[i]=profit[i]/weight[i];
							}
							for(i=0;i<n;i++)
							{
								for(j=i+1;j<n;j++)
								{
								  if( ratio[i]<ratio[j])
								  {
									temp=ratio[j];
									ratio[j]=ratio[i];
									ratio[i]=temp;
									temp=weight[j];
									weight[j]=weight[i];
									weight[i]=temp;
									temp=profit[j];
									profit[j]=profit[i];
									profit[i]=temp;
									}
								  }
							}
							knapsack(n,weight,profit,capacity);
							getch();
							}
