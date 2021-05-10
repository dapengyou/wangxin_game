import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:wangxin_game/wangxin_game.dart';

void main() {
  const MethodChannel channel = MethodChannel('wangxin_game');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await WangxinGame.platformVersion, '42');
  });
}
