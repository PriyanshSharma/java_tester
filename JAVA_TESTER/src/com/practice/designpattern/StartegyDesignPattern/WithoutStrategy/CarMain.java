package com.practice.designpattern.StartegyDesignPattern.WithoutStrategy;

import com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model.BaseCar;
import com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model.LuxuryCar;
import com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model.NormalcarImpl;
import com.practice.designpattern.StartegyDesignPattern.WithoutStrategy.Model.RacingCar;

public class CarMain {

	public static void main(String[] args) {
		
		BaseCar normalCar = new NormalcarImpl("MarutiCar", "normalCar");
		BaseCar  luxurycar= new LuxuryCar("Volvo car", "Luxury car");
		BaseCar racingCar = new RacingCar("Ferari", "Racing car");
		
		
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
