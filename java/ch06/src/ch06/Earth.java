package ch06;

public class Earth {
	static final double Earth_Radius = 6400;
	static final double Earth_surface_area;

	static {
		Earth_surface_area = 4 * Math.PI * Earth_Radius * Earth_Radius;
	}
}
