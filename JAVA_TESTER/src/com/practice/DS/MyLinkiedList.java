package com.practice.DS;

public class MyLinkiedList {

	public static void main(String[] args) {
		
	}
	public void addTwoNumbers(Node l1, Node l2) {
		
		int carry=0;
		Node p1=l1;
		Node p2=l2;
		int ans =0;
		ans = p1.data+p2.data;
		if(ans>9) {
			ans = ans%10;
			carry=1;
		}
		p1=p1.next;
		p2=p2.next;
		
		Node head = new Node(ans);
		Node curr=head;
		
		while(p1!=null || p2!=null) {
			
			if(p1==null && p2!=null) {
				ans = p2.data + carry;
				p2=p2.next;
			}
			else if (p2==null && p1!=null) {
				ans = p1.data + carry;
				p1=p1.next;
			} else {
				ans = p1.data + p2.data +carry;
				p1=p1.next;
				p2=p2.next;
			}
			
			if(ans>9) {
				ans = ans%10;
				carry=1;
			}else {
				carry=0;
			}
			Node t = new Node(ans);
			curr.next=t;
			curr=curr.next;
			
		}
	}
	
}
