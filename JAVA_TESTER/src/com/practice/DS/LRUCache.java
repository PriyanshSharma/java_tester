package com.practice.DS;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {
// get=put operation O(1)
// Oldest = end 
	
	
	Map<K, V> cacheMap ;
	final int max;
	
	public LRUCache(int size) {
		this.max = size;
		this.cacheMap = new LinkedHashMap<K,V>();
	}
	public static void main(String[] args) {
		LRUCache<Integer, String> myCache = new LRUCache<Integer, String>(3);
		myCache.addToCache(1, "ONE");
		myCache.addToCache(2, "Two");
		myCache.addToCache(3, "Three");
		myCache.addToCache(4, "Four");
		myCache.addToCache(5, "Five");
		
		
		System.out.println("Get from cache ==> 1 = "+myCache.getValueFromCache(1));
		System.out.println("Get from cache ==> 2 = "+myCache.getValueFromCache(2));
		System.out.println("Get from cache ==> 3 = "+myCache.getValueFromCache(3));
	}
	
	

	
	public void addToCache(K k, V v) {
		if(!cacheMap.containsKey(k)) {
			if(cacheMap.size()< this.max) {
				cacheMap.put(k, v);
				System.out.println("Current Cache == "+cacheMap);
			}else {
				// First Evict the oldest and put the latest
				cacheMap.remove(cacheMap.entrySet().iterator().next().getKey());
				cacheMap.put(k, v);
				System.out.println("Current Cache == "+cacheMap);
			}
		}else {
			// put the updated entry to last so as to make it latest inserted
			
			cacheMap.remove(k);
			cacheMap.put(k, v);
			System.out.println("Current Cache == "+cacheMap);
		}
	}
	
	
	
	
	
	
	
	
	public V getValueFromCache(K k) {
		if(cacheMap.containsKey(k)) {
			System.out.println("Getting from map -- > "+k);
			V v =cacheMap.remove(k);
			
			cacheMap.put(k, v);
			System.out.println("Current Cache == "+cacheMap);
			return v;
		}
		else {
			return null;
		}
		
	}
}
