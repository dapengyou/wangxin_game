import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:wangxin_game/wangxin_game.dart' as WangxinGame;

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          // child: Text('Running on: $_platformVersion\n'),
          child: FlatButton(
            onPressed: () {
              WangxinGame.loadWangxinGame(appId: "19", gameCode: "10005");
            },
            child: Text("网星游戏"),
          ),
        ),
      ),
    );
  }
}
