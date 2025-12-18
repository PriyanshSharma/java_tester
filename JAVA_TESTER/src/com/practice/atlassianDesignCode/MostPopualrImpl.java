package com.practice.atlassianDesignCode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class MostPopualrImpl implements MostPopular {

	
	Pair headNode ;
	Pair tailNode ;
	
	TreeMap<Integer, Pair> idToPopularityMap = new TreeMap<Integer, Pair>();
	
	
	
	@Override
	public void increasePopularity(Integer contentId) {
		
		if (!idToPopularityMap.containsKey(contentId)) {
			Set<Integer> contentList = new HashSet<Integer>();
			contentList.add(contentId);
			headNode =new Pair();
			headNode.freq=0;
			headNode.prev=null;
		
			
			Pair p = new Pair();
			p.freq=1;
			p.contenctIdList=contentList;
			p.next=null;
			p.prev=headNode;
			
			headNode.next=p;
			
			idToPopularityMap.put(contentId, p);
			tailNode=p;
		}
		
		else {
			
			Pair existingNode = idToPopularityMap.get(contentId);
			
			
			Set<Integer> ls = new HashSet<Integer>();
			ls.add(contentId);
			
			if (existingNode.next==null) {
				Pair newIncrementedNode = new Pair();
				newIncrementedNode.freq++;
				newIncrementedNode.next=null;
				newIncrementedNode.prev=existingNode;
				newIncrementedNode.contenctIdList.add(contentId);
				idToPopularityMap.put(contentId, newIncrementedNode);
				tailNode=newIncrementedNode;
			}
			
			else {
				
				existingNode.next.contenctIdList.add(contentId);
				idToPopularityMap.put(contentId, existingNode.next);
			}
			
			existingNode.contenctIdList.remove(contentId);
			if (existingNode.contenctIdList.isEmpty()) {
				removeNodeFromLinkedList(existingNode);
			}
		}
		
		

	}

	private void removeNodeFromLinkedList(Pair existing) {
		
		
			existing.prev.next = existing.next;
		
			if (existing.next==null) {
				existing.prev.next=null;
			}
			
			else {
				existing.next.prev=existing.prev;
			}
		
	}

	@Override
	public Integer mostPopular() {
		
		
		return tailNode.contenctIdList.stream().findAny().orElse(-1);
	}

	@Override
	public void decreasePopularity(Integer contentId) {
		
	
		if (idToPopularityMap.containsKey(contentId)) {
			Pair existing = idToPopularityMap.get(contentId);
			existing.freq--;
			if (existing.prev!=null) {
				existing.contenctIdList.remove(contentId);
				existing.prev.contenctIdList.add(contentId);
				
				// Remove the node in case popularity becomes zero
				if (existing.freq==0) {
					removeNodeFromLinkedList(existing);
				}
				
			}
			
				
		}
		
		else {
			System.out.println("No content created..");
		}
		
	}

	class Pair {
		int freq=0;
		Set<Integer> contenctIdList = new HashSet<Integer>() ; 
		Pair next=null ; 
		Pair prev=null;
		
	}
}
