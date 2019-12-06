# README
```sh
cd /root/Cryptowallet.si/docker
docker build -t si .

screen 
docker run --name wallet -it si bash
#<ctrl>+A
#<ctrl>+D

docker cp wallet:/root/Cryptowallet.si/wallet/build/outputs/apk/release/wallet-release-unsigned.apk .
```
