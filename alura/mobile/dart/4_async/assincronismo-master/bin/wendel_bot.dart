
import 'dart:io';

import 'questions/time_questions.dart';
import 'questions/good_manners.dart';
import 'timing/waiting_time.dart';

void main() async {
  String wendelBot = 'WendelBOT:\n';
  var a = true;
  String usuario = '';

  var myStream = BotClock().wendelBotStream(1, 10);
  var subscriber = myStream.listen((event) {
    print('                   WendelBot está ativo a $event segundos');
  }, onDone: () {
    print('WendelBot está sendo finalizado, faça a última pergunta');
    a = false;
  });

  print('-- Iniciando o WendelBOT, aguarde..--');

  await BotClock().clock(2);

  print('WendelBOT:\n Oi :) \n Como posso ajudar?');
  do {
    usuario = stdin.readLineSync().toString();
    print('-- Processando pergunta, aguarde..--');
    await BotClock().clock(1);
    if (usuario.contains('xau') ||
        usuario.contains('Xau') ||
        usuario.contains('Adeus') ||
        usuario.contains('adeus')) {
      a = false;
      print(wendelBot + ' Até a próxima!!');
    } else if (TimeQuestions(usuario).isThisTime()) {
      // verificar antes, assim não fazemos toda a função sem precisar.
      await BotClock().clock(2);
      TimeQuestions(usuario).timeQuestion();
    } else if (GoodManners(usuario).isThisGoodManners) {
      GoodManners(usuario).goodManners();
    } else if (false) {
    //   Adicionar novas perguntas
    } else {
        await BotClock().clock(2);
        print(wendelBot +
            ' Não fui treinado para responder a essa pergunta \n Desculpe :( ');
        print(wendelBot + ' Você pode fazer outra pergunta ou dizer Adeus');
    }
  } while (a);

  print('--Encerrando WendelBOT--');
}
