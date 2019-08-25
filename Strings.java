
import java.util.*;
public class Strings{

  public static String uniqueLetters(String str){
    //store letters we have seen in array, and if we see it again change key to -1.
    Hashtable<Character,Integer> haveSeen = new Hashtable<>();
    String answer = new String();
    char[] strArray = str.toCharArray();

    for(int i = 0; i < str.length(); i++){
      if(!haveSeen.containsKey(strArray[i])){
        haveSeen.put(strArray[i],0);
      }
      else{
        haveSeen.put(strArray[i],-1);
      }
    }

    ArrayList<Character> temp = new ArrayList<>();
    for(Character c: haveSeen.keySet()){
      if(haveSeen.get(c) != -1){
        temp.add(c);
      }
    }

    for(char c: strArray){
      if(temp.contains(c)){
        answer += c;
      }
    }
    return answer;
  }
}
