
import java.util.*;

public class Encoding
{
   public static Set<String> morseCodes(int m, int n)
   {
      Set<String> result = new TreeSet<>();
      String temp = new String();
      permute(m,n,temp,result);
      return result;
   }

   public static void permute(int m, int n, String str, Set<String> result){
     //base case
     if(m == 0 && n == 0){
       result.add(str);
       return;
     }

     if(m > 0){
       permute(m - 1, n, str + ".", result);
     }

     if(n > 0){
       permute(m, n - 1, str + "-",result);
     }
   }
}
