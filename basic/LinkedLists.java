import java.util.LinkedList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class LinkedLists{

    public static void main(String Args[]){
        LinkedList<Integer> li = new LinkedList<>();
        for(int i = 0; i<10000;i++){
            li.add(i/1000);
        }
        Collections.shuffle(li);
        deleteDups(li);
    }

    static void deleteDups(LinkedList<Integer> n){
        HashSet<Integer> set = new HashSet<>();
        Iterator<Integer> iterator = n.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            if (set.contains(i)) {
                iterator.remove();
            } else {
                set.add(i);
            }
        }
    }

}