import java.util.LinkedList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class LinkedLists{

    public static void main(String[] Args){
        LinkedList<Integer> li = new LinkedList<>();
        for(int i = 0; i<10000;i++){
            li.add(i/1000);
        }
        Collections.shuffle(li);
        deleteDups(li);
        LinkedList<Integer> lu = new LinkedList<>();
        for(int i = 0; i<5;i++){
            lu.add(i);
        }
        assert klast(lu,2) == 3;
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

    static Integer klast(LinkedList<Integer> n, int k){
        Iterator<Integer> iterator = n.iterator();
        int index = n.size() - k + 1;
        for (int i = 0; i < index - 1; i++){
            iterator.next();
        }
        return iterator.next();
    }

}