/* Find the point where a monotonically increasing function becomes positive first time
*/

int f(x)
{
	return (x*x - 10*x -20);

int getRange()
{
	if(f(0) > 0)
		return 0;
	int i=1;
	while(f(i)<0)
		i=i*2;

	return bin_search(i/2,i);
}
int bin_search(int low,int high)
{
	if(low > high)
		return -1;

	int mid=low + (high-low)/2;

	if(f(mid)>0 && f(mid-1)<0||mid==low)
		return mid;
	if(f(mid)>0)
		return bin_search(low,mid-1);
	else
		return bin_search(mid+1,high);
}
	