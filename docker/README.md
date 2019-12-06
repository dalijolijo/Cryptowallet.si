# README
```sh
cd /root/Cryptowallet.si/docker
docker build -t si .

screen 
docker run -it si bash
#<ctrl>+A
#<ctrl>+D

docker cp si:/root/Cryptowallet.si/wallet/build/outputs/apk/release/wallet-release-unsigned.apk .
```
