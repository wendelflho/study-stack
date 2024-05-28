class Pessoa {
  String name;
  int age;
  bool isAuthenticated;

  Pessoa({
    required this.name,
    required this.age,
    required this.isAuthenticated
  });

  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'age': age,
      'isAuthenticated': isAuthenticated
    };
  }
}