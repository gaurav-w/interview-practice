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
}
