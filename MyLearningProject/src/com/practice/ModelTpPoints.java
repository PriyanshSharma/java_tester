package com.practice;

public class ModelTpPoints {

	private String src;
	private String tp1;
	private String tp2;
	private String tp3;
	private String tp4;
	private String tp5;
	private String dest;
	public ModelTpPoints(String src, String tp1, String tp2, String tp3, String tp4, String tp5, String dest) {
		super();
		this.src = src;
		this.tp1 = tp1;
		this.tp2 = tp2;
		this.tp3 = tp3;
		this.tp4 = tp4;
		this.tp5 = tp5;
		this.dest = dest;
	}
	
	public ModelTpPoints() {
		super();
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getTp1() {
		return tp1;
	}
	public void setTp1(String tp1) {
		this.tp1 = tp1;
	}
	public String getTp2() {
		return tp2;
	}
	public void setTp2(String tp2) {
		this.tp2 = tp2;
	}
	public String getTp3() {
		return tp3;
	}
	public void setTp3(String tp3) {
		this.tp3 = tp3;
	}
	public String getTp4() {
		return tp4;
	}
	public void setTp4(String tp4) {
		this.tp4 = tp4;
	}
	public String getTp5() {
		return tp5;
	}
	public void setTp5(String tp5) {
		this.tp5 = tp5;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}

	@Override
	public String toString() {
		return "ModelTpPoints [src=" + src + ", tp1=" + tp1 + ", tp2=" + tp2 + ", tp3=" + tp3 + ", tp4=" + tp4
				+ ", tp5=" + tp5 + ", dest=" + dest + "]";
	}
	
	
}
