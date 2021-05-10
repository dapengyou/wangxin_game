import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

const MethodChannel _channel = const MethodChannel('wangxin_game');

Future<bool> loadWangxinGame(
    {@required String appId, @required String gameCode, bool debug}) async {
  return await _channel
      .invokeMethod('wangxinGame', {"appId": appId});
}
