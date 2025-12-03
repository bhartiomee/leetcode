class MedianFinder {
    PriorityQueue<Integer> mxHp=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHp=new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(mxHp.isEmpty()||num<=mxHp.peek())mxHp.offer(num);
        else minHp.offer(num);

        if(mxHp.size()>minHp.size()+1){
            minHp.offer(mxHp.poll());
        }else if(minHp.size()>mxHp.size()){
            mxHp.offer(minHp.poll());
        }
    }
    
    public double findMedian() {
        if(minHp.size()==mxHp.size()){
            return (minHp.peek()+mxHp.peek())/2.0;
        }
        else return mxHp.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */