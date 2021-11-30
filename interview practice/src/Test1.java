import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

////employee class - use unqiue id, query
//
//import java.util.HashSet;
//import java.util.UUID;
//
////class Employee {
////
////    String id;
////    String name;
////
////    //
////    HashSet<String> setIds = new HashSet<>();
////    Qu
////    Employee( String name  ){
////
////        this.name = name;
////        this.id = queue.pop();
////    }
//    //Transactions - rows,
//
////    input - Account id
////       output - List<Transaction>
////
////    optimize for same queries.
////}
//
//
//ConcurrentHashMap<String,List<Transaction> > map;
//        HashSet<String> setOfCurrentWrites;
////123 , 12
//List<Transaction> getTransactionsForAccountId(String accountId) {
//    try {
//        List<Transaction> result = null;
//    if ( map!=null && ( setOfCurrentWrites.contains(accountId) || map.get(accountId)!=null ){
//        return map.get(accountId);
//    }
//    lock()
//     setOfCurrentWrites.put( accountId );
//    unlock()
//    result = transactionService.fetchTransactionsForAccountIdFromDb( accountId );
//    lock()
//        setOfCurrentWrites.remove( accountId );
//    unlock();
//        map.remove(accountId , result );
//    }
//    catch(Exception e){
//
//    }
//
//    return result;
//}
//
//hashmap - 10
//
//t1 - 1 - line 39
//t2 - 2
//t3 - 10 - line 22 - it will wait
//
//t1 executes
//hashmap - 1, 10
//
//
public class Test1 {

	public static void main(String[] args) {

		 Integer array[] = new Integer[] {1,3,3,5,6,6,6,8,3,4,6,7};
	        ArrayList<Integer> ab = new ArrayList<>();
	        ab.add(1);
	        ab.add(22);
	        Integer noOf3s = (int) ab.stream()
	                    .filter(a->a==2)
	                    .count();
	        
	        Optional<Integer> noOf3s2 =  ab.stream()
                    .reduce((a,b)->Integer.sum(a, b));
	      
	        System.out.println(noOf3s2);
	        List<Integer> ab2 = Arrays.stream(array).sorted().collect(Collectors.toList());
	        
	        Map<Integer, Long> freq = Arrays.stream(array)
	        							.collect(Collectors.groupingBy(Function.identity(),
	        															Collectors.counting()));
	        System.out.println(ab2);
	        System.out.println(freq);

	}
}
