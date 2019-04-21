FROM openjdk:13-alpine

ARG MAVEN_VERSION=3.5.4

# libraries
RUN apk add --no-cache bash curl git ruby vim

# maven
RUN mkdir -p /usr/local/bin \
    && curl -s https://bitbucket.org/mjensen/mvnvm/raw/master/mvn > /usr/local/bin/mvn \
    && chmod 0755 /usr/local/bin/mvn \
    && echo "mvn_version=$MAVEN_VERSION" > mvnvm.properties \
    && mvn --version \
    && rm mvnvm.properties

# jenv
RUN git clone https://github.com/gcuisinier/jenv.git ~/.jenv \
    && echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.bash_profile \
    && echo 'eval "$(jenv init -)"' >> ~/.bash_profile

# javazone
RUN mkdir -p ~/sources \
    && git clone https://github.com/viqueen/javazone.git ~/sources/javazone \
    && git clone https://github.com/viqueen/jdk.git ~/sources/jdk

# devbox
RUN mkdir -p ~/sources \
    && git clone https://github.com/viqueen/devbox.git ~/sources/devbox \
    && cd ~/sources/devbox \
    && ./setup.sh config_box \
    && ./setup.sh config_prompt \
    && ln -sfnv ~/.bash_profile ~/.bashrc

ENV PATH="~/.jenv/bin:${PATH}"
