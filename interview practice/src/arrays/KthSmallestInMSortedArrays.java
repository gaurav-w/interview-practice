package arrays;

import java.util.*;

class KthSmallestInMSortedArrays {

  public static int findKthSmallest(List<Integer[]> lists, int k) {
    PriorityQueue<Integer> maxQ = new PriorityQueue<>( (a,b) -> ( b - a) );
    
    for(int i=0; i<lists.size(); i++){
       for(int j=0; j<lists.get(i).length; j++){

         int element = lists.get(i)[j];
         
          if(  !maxQ.isEmpty() && maxQ.peek() > element ){
            maxQ.add(  element );
          } else {
             maxQ.add(  element );
          }
          
          if(  maxQ.size() > k ){
              maxQ.poll();
          }
      }
    }

    return maxQ.poll();
  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[] { 2, 6, 8 };
    Integer[] l2 = new Integer[] { 3, 6, 7 };
    Integer[] l3 = new Integer[] { 1, 3, 4 };
    List<Integer[]> lists = new ArrayList<Integer[]>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}
