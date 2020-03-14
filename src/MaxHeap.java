public class MaxHeap implements Heap {

	int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }
    
    //HOMEWORK HELPER METHODS (Implemented Recursively)
    //------------------------------------------------------------------------------------------
    //BOTTOM ---> UP | SLOWER
    private void siftUp(int child) {
    	int pIndex = (child - 1) / 2;
    	int p = data[pIndex], c = data[child];
    	
    	//Checks placing based on parent
    	if(p < c && child > 0) {
    		itemSwap(pIndex, child);
    		siftUp(pIndex);
    	}
    }
    
    //TOP ---> BOTTOM | FASTER
    private void siftDown(int parent) {
    	int p = data[parent];
    	int r = parent * 2+2, l = parent * 2+1; 
    	//swap logic (left to right)
    	if(l >= size && (r < size && data[r] > p)) {
    		itemSwap(parent, r);
    		siftDown(r);
    	}else if(r >= size && (l < size && data[l] > p)) {
    		itemSwap(parent, l);
    		siftDown(l);
    	}else if((r < size && l < size) && data[l] > data[r] && data[l] > p) {
    		itemSwap(parent, l);
    		siftDown(l);
    	}else if((r < size && l < size) && data[r] > data[l] && data[r] > p) {
    		itemSwap(parent, r);
    		siftDown(r);
    	}
    }
    
    //Simple switch for parent and child nodes based on index
    private void itemSwap(int p, int c) {
    	int temp = data[p];
    	data[p] = data[c];
    	data[c] = temp;
    }
    
    //Simple comparison method
    public boolean equals(Integer[] c) {
    	for(int i = 0; i < data.length; i++) {
    		if(data[i] != c[i]) {
    			return false;
    		}
    	} return true;
    }
    //------------------------------------------------------------------------------------------
    
    //HOMEWORK MANDATORY METHODS
    public void MaxHeapLogN(Integer[] data) {
        for(int i = 0; i < data.length; i++)
        	add(data[i]);
    }

    public void MaxHeapN(Integer[] data) {
    	size = data.length;
        if(size == 0){return;}
    	for(int i = 0; i < data.length; i++) {
        	this.data[i] = data[i];
    	}
        for(int k = (size - 1) / 2; k >= 0; k--) {
        	siftDown(k);
        }
    }

    public boolean add(Integer item) {
    	if(data.length == size || data.length == 0) { return false; }
    		data[size] = item;
    		siftUp(size);
    		size++;
    		return true;
    }

    public Integer get() {
        if(size != 0) {
        	return data[0];
        } return null;
    }

    public Integer pop() {
    	if(size != 0) {
    		int popdItem = data[0];
    	
    		data[0] = data[size - 1];
    		data[size - 1] = null;
    		size--;
    		if(size > 0) {
    			siftDown(0);
    		}
    		return popdItem;
    	} return null;
    }
}