package com.practice.walamrtexercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryDbInterfaceImpl implements InventoryDBInterfacer {

	
	 
	@Override
	public Map<String, Long> getProdcutCounts(List<String> prodIdList) {
		String inventiryQuery="Select product,available_qty from Inventory where p_id in (:prodIdList)";
		
		PreparedStatement st = Conn.createstatement(inventiryQuery);
		ResultSet result = st.get();
		
		Map<String, Long > resultMap = new HashMap<String, Long>();
		
		while(result!=null) {
			
			//populate the map 
			
			
		}
		
		
		/// FOR ONE PROD ID -- 
		
		String inventiryQuery="Select available_qty from Inventory where p_id =?";
		
		PreparedStatement st = Conn.createstatement(inventiryQuery);
		st.set(1,prodId);
		ResultSet result = st.get();
		
		BigDecimal qty = 	result.get();
		
		
		return resultMap;
	}

}
