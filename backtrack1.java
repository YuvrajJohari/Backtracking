
public class backtrack1 {
    public static void Findsubset(String str,String ans,int i){
        if (i==str.length()){
            System.out.println(ans);
            return;

            
        }
        //wants to include 
        Findsubset(str, ans+str.charAt(i), i+1);

        //doesnt wants to include
         Findsubset(str, ans, i+1);





    }
    public static void main(String args[]){
        String str="abc";
        Findsubset(str, "", 0);
    }

    
}
