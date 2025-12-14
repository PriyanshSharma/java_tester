package com.practice.walamrtexercise;

import java.util.List;
import java.util.Map;

@repositry
public interface InventoryDBInterfacer {
	
	public Map<String,Long> getProdcutCounts(List<String> prodIdList);
}
