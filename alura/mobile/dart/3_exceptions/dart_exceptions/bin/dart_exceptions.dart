import 'dart:math';

import 'controllers/bank_controller.dart';
import 'models/account.dart';
import 'exceptions/bank_controller_exception.dart';

void testNullSafety() {
  Account? myAccount = Account(name: 'Wendel', balance: 200, isAuthenticated: true);

//   Simulando comunicação externa
  Random rng = Random();
  int randomNumber = rng.nextInt(10);

  if (randomNumber % 2 == 0) {
    myAccount.createdAt = DateTime.now();
  }

  print(myAccount.runtimeType);

  // Teste forçado que não funciona
  // print(myAccount.balance);

  if (myAccount != null) {
    print(myAccount.balance);
    if (myAccount.createdAt != null) {
      print(myAccount.createdAt!.day);
    }
  } else {
    print('Conta nula');
  }

  print(myAccount.createdAt);
  print(myAccount.createdAt!.day);

  // Teste usando operador ternário
  // print(myAccount != null ? myAccount.balance : 'Conta nula');

  // Teste usando chamada segura
  // print(myAccount?.balance);
}

void main() {
  testNullSafety();

  // Criando o banco
  BankController bankController = BankController();

  // Adicionando contas
  // Account accountTeste = Account(name: 'Wendel', balance: -200, isAuthenticated: true);
  bankController.addAccount(
      id: "Ricarth",
      account:
          Account(name: "Ricarth Lima", balance: 400, isAuthenticated: true));

  bankController.addAccount(
      id: "Kako",
      account:
          Account(name: "Caio Couto", balance: 600, isAuthenticated: true));

  // Fazendo transferência
  try {
    bool result = bankController.makeTransfer(
        idSender: "Kako", idReceiver: "Ricarth", amount: 599);

    if (result) {
      print('Transação concluída com sucesso!');
    }
  } on SenderIdInvalidException catch (e) {
    print(e);
  } on ReceiverIdInvalidException catch (e) {
    print(e);
  } on SenderNotAuthenticatedException catch(e) {
    print(e);
  } on SenderBalanceLowerThanAmountException catch(e) {
    print(e);
  } on Exception {
    print('Algo deu errado!');
  }


}