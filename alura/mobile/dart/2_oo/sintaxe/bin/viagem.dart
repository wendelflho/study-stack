import 'transporte.dart';

class Viagem {
  static int workCode = 2254858;
  double money = 0;
  Transporte transporte;
  Set<String> visitedRegistry = <String> {};
  Map<String, dynamic> priceRegistry = {};

  int _localVisitedPlacesTotal = 20;

  Viagem ({required this.transporte});

  printCode() {
    print(workCode);
  }

  static double staticArea(double radioParam) {
    return workCode * radioParam * radioParam;
  }

  void escolherMeioTransporte(Transporte transporte) {
    switch (transporte) {
      case Transporte.carro:
        print('Vou de CARRO para aventura!');
        break;
      case Transporte.bike:
        print('Vou de BIKE para aventura');
        break;
      default:
        print('Vou para aventura!');
        break;
    }
  }

  void visit(String visitedRegion) {
    visitedRegistry.add(visitedRegion);
    _localVisitedPlacesTotal += 1;
  }

  void registerVisitedPrice(String local, dynamic price) {
    priceRegistry[local] = price;
  }

  // Não precisa de parâmetros, uma vez que apenas pegamos o valor
  int get checkTotalVisitedPlaces {
    return _localVisitedPlacesTotal;
  }

  set alterVisitedPlaces(int newValue) {
    if (newValue < 10) {
      _localVisitedPlacesTotal = newValue;
    } else {
      print("It's is not possible");
    }
  }
}