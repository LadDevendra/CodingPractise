// LRU cache!

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

// Follow up:
// Could you do both operations in O(1) time complexity?

// Example:

// LRUCache cache = new LRUCache( 2 /* capacity */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4

class LRUCache {

    class Node{
        public int key;
        public int value;
        public Node next;
        public Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;
        
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            //we have to remove this temp node and put it at the head of doubly linkedList
            removeNode(temp);
            setHead(temp);
            return temp.value;
        }
        else
            return -1;
    }
    
    public void removeNode(Node temp){
        if(temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;
        
        if(temp.next != null)
            temp.next.prev = temp.prev;
        else
            end = temp.prev;
    }
    
    public void setHead(Node temp){
        //set pointers
        temp.next = head;
        temp.prev = null;
        
        if(head!= null)
            head.prev = temp;
        
        head = temp;
        //if end is null,, now it should be head since its only element in list | very important to set value of end for first time.
        if(end == null)
            end = head;
    }
    
    public void put(int key, int value) {
        //if key is present, just update its value and put it at the head of queue.
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.value = value;
            removeNode(temp);
            setHead(temp);
        }else{
            //if key is NOT present, and ie adding a new key and size() reached. remove end and add (key, value) Node as a head.
            Node temp1 = new Node(key, value);
            if(map.size() >= capacity){
                //remember **END.key** to be removed from hashMap as well..
                map.remove(end.key);
                removeNode(end);
            }
            //either ways, set new node to head of linkedList and add it to hashmap
            setHead(temp1);
            map.put(key, temp1);
        }
    }
}