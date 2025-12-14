package com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies;

public class FastEngine200kmphStrategy implements IEngineStrategy {

	@Override
	public void fastEngineStrategy() {

		System.out.println("Fast Engine strategy 200 kmph");
	}

}
