package com.practice.tescoPay;

import java.util.Objects;

public class BaseEntity {

	protected String Uid;

	public BaseEntity(String uid) {
		super();
		Uid = uid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(Uid, other.Uid);
	}
}
