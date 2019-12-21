# Build apk for Android

## Clean project
```sh
docker run --rm -v "$PWD":/home/gradle/ -w /home/gradle android-build:android-gradle gradle -PdisablePreDex clean
```

## Lint run
```sh
docker run --rm -v "$PWD":/home/gradle/ -w /home/gradle android-build:android-gradle gradle -PdisablePreDex lint
```

## Build release and debug apk
```sh
docker run --rm -v "$PWD":/home/gradle/ -w /home/gradle/wallet android-build:android-gradle gradle -PdisablePreDex build
```

## Sign apk (needed for testing on Android)
```sh
cp wallet/build/outputs/apk/release/wallet-release-unsigned.apk .
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore ../codesigning/LIMXTEC.keystore wallet-release-unsigned.apk LIMXTEC
```

