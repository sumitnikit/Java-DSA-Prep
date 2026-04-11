import java.util.HashMap;
import java.util.Map;

public class ArrayBasics {

    public static void main(String[] args) {

        // int[] numbers = {5, 2, 9, 1, 7};
        // if (numbers.length > 0) {

        //     int min = numbers[0];
        
        //     for (int i = 1; i < numbers.length; i++) {
        //         if (numbers[i] < min) {
        //             min = numbers[i];
        //         }
        //     }
        
        //     System.out.println("Largest element is: " + min);
        
        // } else {
        //     System.out.println("Array is empty.");
        // }


        // int [] arr ={1,2,3,4,5};
        // int size = arr.length;
        // for(int i=0; i<size-1-i; i++){
        //     int temp = arr[i];
        //     arr[i]=arr[size-1-i];
        //     arr[size-1-i]=temp;
            
        // }
        
        // for(int i :arr){
        //     System.out.println(i);
        // }
        
        // int [] arr ={1,2,3,4,5};
        // int size = arr.length;
        // int j =size-1-i;
        // for(int i=0; i<j; i++){
        //     int temp = arr[i];
        //     arr[i]=arr[j];
        //     arr[j]=temp;
            
        // }
        
        // for(int i :arr){
        //     System.out.println(i);
        // }
//         int [] arr ={1,2,3,4,5};
//         int max = Integer.MIN_VALUE;
// int maxx = Integer.MIN_VALUE;
// boolean foundSecond = false;

// for(int i = 0; i < arr.length; i++) {
//     if(arr[i] > max) {
//         maxx = max;
//         max = arr[i];
//         if(maxx != Integer.MIN_VALUE) {
//             foundSecond = true;
//         }
//     }
//     else if(arr[i] > maxx && arr[i] < max) {
//         maxx = arr[i];
//         foundSecond = true;
//     }
// }

// if(!foundSecond) {
//     System.out.println("Not Present");
// } else {
//     System.out.println(maxx);
// }

    int[] arr = {3,3};
    int n= arr.length;
    // for(int i=0; i<n-1; i++){
    //     for(int j=i+1; j<n; j++){
    //         if(arr[i]+arr[j]==9){
    //             System.out.println(i+" "+j);
    //         }
    //     }
    // }

    Map<Integer,Integer> mp =new HashMap<>();
    for(int i=0; i<n; i++){
        int req =6-arr[i];
        if(mp.containsKey(req)){
            System.out.println(mp.get(req)+"  "+i);
        }else{
            mp.put(arr[i], i);
        }
    }

       
        
       
        
        

    }
}
