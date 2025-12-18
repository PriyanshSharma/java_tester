package com.practice.atlassianDesignCode;

public interface MostPopular {

	 void increasePopularity(Integer contentId);

	    Integer mostPopular(); //--> greater than 0 if all content =0 return -1

	    void decreasePopularity(Integer contentId);
}
