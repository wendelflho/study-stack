import 'dart:io';

import 'controllers/bank_controller.dart';
import 'models/account.dart';

// void main() {
//   // Criando o banco
//   BankController bankController = BankController();
//
//   // Adicionando contas
//   bankController.addAccount(
//       id: "Ricarth",
//       account:
//           Account(name: "Ricarth Lima", balance: 400, isAuthenticated: true));
//
//   bankController.addAccount(
//       id: "Kako",
//       account:
//           Account(name: "Caio Couto", balance: 600, isAuthenticated: true));
//
//   // Fazendo transferência
//   bool result = bankController.makeTransfer(
//       idSender: "Kako", idReceiver: "Ricarth", amount: 700);
//
//   // Observando resultado
//   print(result);
// }


void main() {
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