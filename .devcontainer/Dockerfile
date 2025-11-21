FROM debian:trixie-slim

ENV SDKMAN_JDK_VERSION=25-oracle
ENV SDKMAN_GRADLE_VERSION=9.2.0

RUN apt update && apt install -y git curl wget unzip zip nodejs npm

# Installer des dépendances basiques
RUN apt update && apt install -y git curl wget unzip zip

RUN curl -s "https://get.sdkman.io" | bash

RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java $SDKMAN_JDK_VERSION"
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle $SDKMAN_GRADLE_VERSION"

RUN npm install -g pnpm