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
- EntryPoint : インスタンス化した際に自身を Forgeのmod系EventBusに登録する. @Modアノテーションされている通り、EntryPointが最初にインスタンス化されて起動する。

- Register
    -


