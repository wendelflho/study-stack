import 'dart:async';

void main() async {
  Stream myStream(int interval, [int? maxCount]) async* {
    int i = 1;

    while (i != maxCount) {
      print('Counting: $i');
      await Future.delayed(Duration(seconds: interval));
      yield i++;
    }

    print('The Stream is finished;');
  }

  var wendelStream = myStream(1).asBroadcastStream();

  StreamSubscription mySubscriber = wendelStream.listen((event) {
    if (event.isEven) {
      print('This number is even!');
    }
  }, onError: (e) {
    print('An Error happened!');
  }, onDone: () {
    print('The subscriber is gone.');
  });

  wendelStream.map((event) => 'Subscriber 2 is watching: $event').listen(print);

  await Future.delayed(Duration(seconds: 3));
  mySubscriber.pause();
  print('Stream paused');
  await Future.delayed(Duration(seconds: 3));
  mySubscriber.resume();
  print('Stream resumed');
  await Future.delayed(Duration(seconds: 3));
  mySubscriber.cancel();
  print('Stream canceled');

  print('Main is finished');
}
