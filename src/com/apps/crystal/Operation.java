package com.apps.crystal;

public class Operation {

	private long brightness;
	private long minimalMagnification;
	private long maximalMagnification;

	public long getBrightness() {
		return brightness;
	}

	public long getMinimalMagnification() {
		return minimalMagnification;
	}

	public long getMaximalMagnification() {
		return maximalMagnification;
	}

	public void calculate(long tD, long fL) {

		brightness = (long) tD / fL;
		minimalMagnification = (long) fL / 6;
		maximalMagnification = fL * 2;

	}

}
