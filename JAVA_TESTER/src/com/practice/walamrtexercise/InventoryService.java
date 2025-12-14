package com.practice.walamrtexercise;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@service
public class InventoryService {

	@Autowired
	InventoryDBInterfacer dbServc = new InventoryDbInterfaceImpl();
	
	@Autowired
	
	public Map<String,Long> getProductCounts(List<String> prodIdList) {
		
		Map<String,Long> mapper= dbServc.getProdcutCounts(prodIdList);
		
		// Increament the value for map's qty
		
		Map<String, Long> resultMap = incrementQTYForProduct(mapper,10);
		
		return resultMap;
		
	}

	private Map<String, Long>  incrementQTYForProduct(Map<String, Long> mapper, int qty) {
		
		Map<String, Long> resultMap =mapper.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()+qty));
		return resultMap;
	}
}
