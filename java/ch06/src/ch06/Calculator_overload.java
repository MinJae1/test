package ch06;

public class Calculator_overload {
	double areaRect(double width) {
		return width * width;
	}

	double areaRect(double width, double height) {
		return width * height;
	}
}
