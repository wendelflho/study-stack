void main() {
  // Transporte.tiposTransporte();
  // escolherMeioTransporte(Transporte.skate);

  // List<String> destinos = [];
//   Receber um destino
//   String destino = 'Rio de Janeiro';
//   destinos.add(destino);
//   destinos.add(destino);

  // Set<String> registrosVisitados = <String>{};
  // registrosVisitados = registrarDestino('Rio de Janeiro', registrosVisitados);
  // registrosVisitados = registrarDestino('Recife', registrosVisitados);
  // registrosVisitados = registrarDestino('São Paulo', registrosVisitados);
  // registrosVisitados = registrarDestino('Rio de Janeiro', registrosVisitados);
  //
  // print(registrosVisitados);
  //
  // print(registrosVisitados.contains('São Paulo'));
  // print(registrosVisitados.contains('Natal'));

  // List<int> numeros = [1, 2, 3, 3, 2, 1];
  // var subLista = numeros.getRange(1, 4);
  // print(subLista);
  // print(subLista.runtimeType);
  //
  // List<int> listaSubLista = subLista.toList();
  // print(listaSubLista);
  // print(listaSubLista.runtimeType);

  // Map<String, dynamic> registrarPrecos = {};

  // registrarPrecos['São Paulo'] = 1200;
  // registrarPrecos['Rio de Janeiro'] = 1500;
  // registrarPrecos['Nova York'] = 'Muito caro';
  // registrarPrecos.remove('São Paulo');

  // print(registrarPrecos);

  Pessoa twilight = Pessoa(name: 'Twilight', age: 20, isAuthenticated: true);
  print(twilight.toMap());
}

Set<String> registrarDestino(String destino, Set<String> banco) {
  banco.add(destino);
  return banco;
}

void escolherMeioTransporte(Transporte locomocao) {
  switch (locomocao) {
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

enum Transporte {
  carro,
  bike,
  andando,
  skate,
  aviao,
  patins,
  trem;

  static void tiposTransporte() {
    print('Carro, bike, andando, skate, avião, patins e trem');
  }
}

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
