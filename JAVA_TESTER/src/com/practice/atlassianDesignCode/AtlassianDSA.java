package com.practice.atlassianDesignCode;


/**
 * interface MostPopular {

    void increasePopularity(Integer contentId);

    Integer mostPopular(); --> greater than 0 if all content =0 return -1

    void decreasePopularity(Integer contentId);

}
 */

public class AtlassianDSA {

	public static void main(String[] args) {
		
		MostPopular popularDS=new MostPopualrImpl();
		
		popularDS.increasePopularity(1);
		popularDS.increasePopularity(1);
//		System.out.println(popularDS.mostPopular());
		popularDS.increasePopularity(2);
		popularDS.increasePopularity(2);
		
		System.out.println(popularDS.mostPopular());
	}
}
