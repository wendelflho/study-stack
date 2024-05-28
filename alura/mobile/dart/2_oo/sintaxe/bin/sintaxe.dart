import 'viagem.dart';
import 'transporte.dart';

void main() {
  // Pessoa twilight = Pessoa(name: 'Twilight', age: 20, isAuthenticated: true);
  // print(twilight.toMap());

  dynamic myNumber = 7.1;
  print(myNumber.runtimeType);
  myNumber = '7.1';
  print(myNumber.runtimeType);

  Viagem viagem = Viagem(transporte: Transporte.carro);
  Viagem.workCode;
  viagem.printCode();
  print(viagem.checkTotalVisitedPlaces);
  viagem.visit('Museu');
  print(viagem.checkTotalVisitedPlaces);
  viagem.alterVisitedPlaces = 10;
  print(viagem.checkTotalVisitedPlaces);
}
