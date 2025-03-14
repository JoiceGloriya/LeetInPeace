class StockSpanner {
    List<Integer> list = new ArrayList<>() ; 
    public StockSpanner() {
        List<Integer> list = new ArrayList<>();
    }
    
    public int next(int price) {
        int ct = 1;
        for(int i = list.size() - 1; i >= 0; i --) {
            if(list.get(i) <= price) ct++;
            else break;
        }
        list.add(price);
        return ct;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */