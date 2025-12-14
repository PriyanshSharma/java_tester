package com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies;

public class NormalEngine100KmphStrategy implements IEngineStrategy {

	@Override
	public void fastEngineStrategy() {
		
		System.out.println("Normal Engine strategy -- 80 kmph");
		
	}

}
