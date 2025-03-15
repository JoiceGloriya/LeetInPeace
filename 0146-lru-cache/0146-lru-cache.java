class LRUCache {

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    Map<Integer, Node> mpp = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!mpp.containsKey(key))
            return -1;
        Node node = mpp.get(key);
        remove(node);
        addAtBeg(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (mpp.containsKey(key))
            remove(mpp.get(key));
        if (capacity == mpp.size())
            remove(tail.prev);
        addAtBeg(new Node(key, value));
    }

    void remove(Node node) {
        mpp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addAtBeg(Node node) {
        mpp.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    class Node {
        Node prev, next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */