/* Print PostOrder Traversal from the given preorder and inorder traversal */

int searchRoot(int in[],int x,int n)
{
	int i;
	for(i=0;i<n;i++)
		if(in[i]==x)
			return i;
	return -1;
}
void _printPostOrder(int pre[],int in[],int n)
{
	int root=searchRoot(in,pre[0],n);

	if(root!=-1)
		_printPostOrder(pre+1,in,n);
	if(root!=n-1)
		_printPostOrder(in+root+1,pre+root+1,n-root-1);
	printf("%d",pre[0]);
}