package com.practice.Immutable;

import java.util.Map;

public final class  ImmutableClass {
	
	private final int id;
	private final String name;
	private final Map<Integer,String> metaMap ;
	public ImmutableClass(int id, String name, Map<Integer, String> metaMap) {
		super();
		this.id = id;
		this.name = name;
		this.metaMap = metaMap;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Map<Integer, String> getMetaMap() {
		return metaMap;
	}
	@Override
	public String toString() {
		return "ImmutableClass [id=" + id + ", name=" + name + ", metaMap=" + metaMap + "]";
	}
	
}
