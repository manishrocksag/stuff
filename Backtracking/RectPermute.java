public class RectPermute {
    private static int count=0;
    public void permute(String soFar,String rest){
        if("".equals(rest)){
            System.out.println(soFar);
            count++;
        }
        for(int i=0;i<rest.length();i++){
            String remaining=rest.substring(0, i)+rest.substring(i+1);
            permute(soFar+rest.charAt(i),remaining);
            
        }
    }
    public void subsets(String soFar,String rest){
        if("".equals(rest)){
            System.out.println(soFar);
            count++;
        }
        else{
            subsets(soFar+rest.charAt(0),rest.substring(1));
            subsets(soFar,rest.substring(1));
        }
    }
    public void subsetsSum(String soFar,String rest,String sum){
	/* Pruning branches when it violates the constraints */
        if(!soFar.equals("")&&
            sum(soFar).compareTo(sum)>1)return;
        if("".equals(rest)){
            if(!soFar.equals(""))
                if(sum.equals(sum(soFar)))
                    System.out.println(soFar);
        }
            
        else{
            			subsetsSum(soFar+rest.charAt(0),rest.substring(1),sum);
            subsetsSum(soFar,rest.substring(1),sum);
        }
    }
}
