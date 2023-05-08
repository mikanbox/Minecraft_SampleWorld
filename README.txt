# Minecraft SampleWorld

## QuickStart
setting up project
```
git clone <Repository>
./gradlew genIntellijRuns
```

run minecraft app
```
./gradle run ""
```

Test registered dimenstion
```
/execute in sampleworld:sample_world_location run tp ~ ~ ~5
```


## 用語
- EventBus(Forge)
バニラやModで発生したイベントをインターセプトする。いわゆるコールバックやリスナーの類か？
- FMLJavaModLoadingContext : Mod系のイベントをリッスンするEventBus

## 構造
- EntryPoint : EventBusの取得とレジストリのリストの作成。EventBusへの登録
- SampleDimension : 登録用オブジェクト作成
- SampleBlock : 右クリック時にテレポート発動
- SampleMesageBlock : 右クリック時にチャットに投稿
