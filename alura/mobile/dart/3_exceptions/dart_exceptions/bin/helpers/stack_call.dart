void stackStart() {
  print('Started Main');
  functionOne();
  print('Finished Main');
}

functionOne() {
  print('Started F01');
  try {
    functionTwo();
  } catch (e, stackTrace) {
    print(e);
    print(stackTrace);
    // rethrow; Propagar de volta a exceção para quem estiver abaixo na Pilha
  } finally {
    print('Chegou no Finally');
  }
  print('Finished F01');
}

functionTwo() {
  print('Started F02');
  for (int i = 1; i < 5; i++) {
    print(i);
    double amount = double.parse("Not a number");
  }
  print('Finished F02');
}