class Circle {
  static double pi = 3.14;
  double radio;

  Circle(this.radio);

  double area() {
    return pi * radio * radio;
  }

  static double staticArea(double radioParam) {
    return pi * radioParam * radioParam;
  }
}