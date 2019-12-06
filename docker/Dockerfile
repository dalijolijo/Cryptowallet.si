# Use an official Ubuntu runtime as a parent image
FROM ubuntu:16.04
#FROM eternnoir/ubuntu-java:openjdk-7
#FROM eternnoir/ubuntu-java:oracle-java8

USER root

# Change sh to bash
SHELL ["/bin/bash", "-c"]

ENV ANDROID_HOME="/opt/android-sdk-linux"
ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"

# Running updates and installing required packages
RUN echo '*** Running updates and installing required packages ***' && \
    apt-get update -y && \
    apt-get install -y curl \
                        git \
                        openjdk-8-jdk \
                        vim \
                        wget \
                        zip \
                        unzip

# create sdk folder
RUN mkdir -p $ANDROID_HOME

# set JAVA_HOME and ANDROID_HOME
RUN echo 'JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre"' >> /etc/environment && \
    echo 'ANDROID_HOME="/opt/android-sdk-linux"' >> /etc/environment && \
    source /etc/environment && \
    cat /etc/environment

# download android sdk
RUN cd $ANDROID_HOME && \
    wget https://dl.google.com/android/repository/tools_r25.2.3-linux.zip && \
    unzip tools_r25.2.3-linux.zip

# install all sdk packages
RUN cd ${ANDROID_HOME}/tools && \
    ./android update sdk --no-ui 

# set path
RUN export PATH=${PATH}:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:${ANDROID_HOME}/build-tools/29.0.2/ && \
    source /etc/profile

# accept license
RUN echo "y" | ${ANDROID_HOME}/tools/bin/sdkmanager "platforms;android-28"
RUN echo "y" | ${ANDROID_HOME}/tools/bin/sdkmanager "build-tools;28.0.3"
RUN echo "y" | ${ANDROID_HOME}/tools/bin/sdkmanager "ndk-bundle"
RUN echo "y" | ${ANDROID_HOME}/tools/bin/sdkmanager "tools"
RUN ${ANDROID_HOME}/tools/bin/sdkmanager --list

# build APK
RUN cd && git clone -b master https://github.com/CryptowalletSi/Cryptowallet.si.git
#RUN rm ~/neblio-android/wallet/build.gradle
#COPY build.gradle ~/neblio-android/wallet 
RUN export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8  && \
    cd  ~/Cryptowallet.si && \
    ./gradlew && \
    ./gradlew assembleRelease

RUN echo "Find APK in: /root/Cryptowallet.si/wallet/build/outputs/apk/release/wallet-release-unsigned.apk"

ENV TERM linux
CMD ["/bin/bash"]
