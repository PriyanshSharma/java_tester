package com.practice;

public class TestMe<T> {
private T t;

public T getT() {
	return t;
}

public void setT(T t) {
	this.t = t;
}
public static void main(String[] args) {
	TestMe a = new TestMe();
	a.setT("demo");
	a.setT("10");
	a.setT("%");
	System.out.println(a.getT());
}
}
