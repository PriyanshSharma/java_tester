package com.practice.designpattern.StartegyDesignPattern.withStrategy;

import com.practice.designpattern.StartegyDesignPattern.withStrategy.Model.BaseCar;
import com.practice.designpattern.StartegyDesignPattern.withStrategy.Model.LuxuryCar;
import com.practice.designpattern.StartegyDesignPattern.withStrategy.Model.NormalcarImpl;
import com.practice.designpattern.StartegyDesignPattern.withStrategy.Model.RacingCar;
import com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies.FastEngine200kmphStrategy;
import com.practice.designpattern.StartegyDesignPattern.withStrategy.strategies.NormalEngine100KmphStrategy;

public class CarMain {

	public static void main(String[] args) {
		
		BaseCar normalCar = new NormalcarImpl("MarutiCar", "normalCar", new NormalEngine100KmphStrategy());
		BaseCar  luxurycar= new LuxuryCar("Volvo car", "Luxury car", new FastEngine200kmphStrategy());
		BaseCar racingCar = new RacingCar("Ferari", "Racing car", new FastEngine200kmphStrategy());
		
		
		System.out.println(normalCar.toString());
		normalCar.driveCapability();
		normalCar.luxuryCapability();
		normalCar.fastEngineCapability();
		
		
		
		System.out.println(luxurycar);
		luxurycar.driveCapability();
		luxurycar.luxuryCapability();
		luxurycar.fastEngineCapability();
		
		System.out.println(racingCar);
		racingCar.driveCapability();
		racingCar.luxuryCapability();
		racingCar.fastEngineCapability();
				
		
	}
}
