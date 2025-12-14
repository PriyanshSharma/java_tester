package com.practice.walamrtexercise;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventryController {
	
	@Autowired
	InventoryService invService;
	
	
//	Method - Get
	@GetMapping("/products")
	public ResponseEntity<Map<String,Long>> getProductInventoryCoount(@RequesParam List<String> productListId){
		
		if(!productListId.isEmpty()) {
			return ResponseEntity.ok(invService.getProductCounts(productListId)) ;
		}
		else 
			return ResponseEntity.HTPP_BAD_REQUEST;
		
	}
}
