import 'controllers/bank_controller.dart';
import 'models/account.dart';
import 'exceptions/bank_controller_exception.dart';

void main() {
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
        idSender: "Kako", idReceiver: "Ricarth", amount: 1000);

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