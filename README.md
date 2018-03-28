## JavaZone - Make your own Java

### Requirements

1. [mercurial](https://www.mercurial-scm.org/)
2. [git](https://git-scm.com/)
3. [jEnv](http://www.jenv.be/)
4. [mvnvm](http://mvnvm.org/)
5. [ant](https://ant.apache.org/)
6. [jdk 8 or 9](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
7. Common sense
8. Sense of humour

#### get it

```bash
hg clone http://hg.openjdk.java.net/jdk10/jdk10/
cd jdk10
bash get_source.sh
```

Getting the source code will take a while, so in the mean time read up on the 
requirements to [build openjdk](http://hg.openjdk.java.net/jdk10/jdk10/file/62306e615de1/common/doc/building.md) 
on your platform of choice (macOs, windows, linux)


#### configure it

Use `jenv` to manage jdk versions, you will need to add an existing jdk 8 or 9 as managed version, then set
the current terminal shell to use that version.

```bash
jenv add /path/to/an/existing/jdk/8/or/9/home/directory
jenv shell ${someversion}

cd jdk10
bash configure --with-boot-jdk=$(jenv javahome)

bash common/bin/idea.sh # generates IDEA project files
```

#### build it

```bash
cd jdk10
make images
jenv add build/macosx-x86_64-normal-server-release/jdk/  # path varies by platform
```

```bash
cd langtools
ant -f make/build.xml -Djdk.home=$(jenv javahome)

echo "export JAVA_ZONE_COMPILER=$(pwd)/build/bin/javac" >> ~/.bash_profile
```

#### verify it

```bash
git clone git@github.com:viqueen/javazone.git
cd javazone
mvn -e clean verify
```
