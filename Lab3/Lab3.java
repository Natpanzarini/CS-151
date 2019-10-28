// Question 1: Write a method dumpArray that prints the elements of any array to System.out, using toString on
// the array elements if the array elements are objects.
import java.awt.Rectangle;
import java.lang.reflect.Array;
class Lab3{

  public static void dumpArray(Object arr){
    for(int i = 0; i < Array.getLength(arr); i++){
      System.out.println(Array.get(arr,i).toString());
    }
  }

  public static void main(String[] args) {
    Object[] testObj = {new Rectangle(50,80)};
    Object[] testString = {"test"};
    int[] ints = {1,2,3};
    dumpArray(testObj);
    dumpArray(testString);
    dumpArray(ints);
  }

}
