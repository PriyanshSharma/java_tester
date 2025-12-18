package com.practice.DS;

import java.util.Comparator;
import java.util.PriorityQueue;





public class MergeKSortedList {

	
	public static void main(String[] args) {
		/**
		 *  { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 },
		 */
		
		int arr[][] = {
						{ 10, 20, 30, 40 },
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 },
						{ 32, 33, 39, 50 }
						
						};
		
		MergeKSortedList obj = new MergeKSortedList();
		//obj.mergeKSorted2DArray(arr);
		
		Node[] lists = new Node [3];
		// [[1,4,5],[1,3,4],[2,6]]
		
		int a[] = {1,4,5};
		int b[]  = {1,3,4};
		int c[] = {2,6};
		Node l1 = LinkedListOperations.createLinkedListfromArray(a);
		Node l2 = LinkedListOperations.createLinkedListfromArray(b);
		Node l3 = LinkedListOperations.createLinkedListfromArray(c);
		
		lists[0]=l1;
		lists[1]=l2;
		lists[2]=l3;
		
//		Node ans =obj.mergeKLists(lists);
		Node ans1 =obj.mergeKLists(new Node [3]);
		LinkedListOperations.printMyLinkedList(ans1);
	}
	
	
	public void mergeKSorted2DArray(int arr[][]) {
		
		PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(Comparator.comparing(hn->hn.element()));
		int n = arr.length;
		
		for (int i = 0 ; i < n ; i++) {
			HeapNode h = new HeapNode(arr[i][0], i, 0);
			minHeap.add(h);
		}
		
		
		
		while(!minHeap.isEmpty()) {
			
			HeapNode minNode = minHeap.poll();
			
			
			int row = minNode.i();
			int col = minNode.j();
			
			System.out.print(minNode.element()+" ");
			if (col+1<n) {
				int nextElement = arr[row][col+1];
				HeapNode nextNode = new HeapNode(nextElement, row, col+1);
				minHeap.add(nextNode);
			}
			
			
			
		}
		
		
	}
	
	public void mergeKSortedArray(int arr[]) {
		
		
	}
	
	public Node mergeKLists(Node[] lists) {
        
		
		if (lists==null || lists.length==0) {
			return null;
		}
    	PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<MyHeapNode>(Comparator.comparing(hn->hn.element()));
        Node headNode =null;
        for (Node n : lists){

        	if (n==null) {
        		return null;
        	}
        	else {
        		MyHeapNode heapnode = new MyHeapNode(n.data, n);
                minHeap.add(heapnode);
        	}

        }


       
       Node currNode = null;
       while(!minHeap.isEmpty()) {

    	   MyHeapNode pollNode = minHeap.poll();
    	   
    	      		   
    	   
            if (headNode==null){
                headNode = new Node(pollNode.element);
                currNode=headNode;
            }

            else {
            Node tempNode=new Node(pollNode.element);
            currNode.next=tempNode;
            currNode = currNode.next;
            }
            if (pollNode.node.next!=null) {

            MyHeapNode insertNode = new MyHeapNode(pollNode.node.next.data,pollNode.node.next);
            minHeap.add(insertNode);

          }

       }
        return headNode;
}
	record MyHeapNode (int element, Node node) {}
}



record HeapNode (int element, int i, int j) {

}
