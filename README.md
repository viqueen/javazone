## JavaZone - Make your own Java

### Requirements

1. [mercurial](https://www.mercurial-scm.org/)
2. [git](https://git-scm.com/)
3. [jEnv](http://www.jenv.be/)
4. [mvnvm](http://mvnvm.org/)
5. [ant](https://ant.apache.org/)
6. [jdk 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
7. Common sense
8. Sense of humour

### Scope : Lang-tools

```bash
hg clone http://hg.openjdk.java.net/jdk8/jdk8/langtools jdk8/langtools
```

#### configure it

Use `jenv` to manage jdk versions, you will need to add an existing jdk 8 or 9 as managed version, then set
the current terminal shell to use that version.

```bash
jenv add /path/to/an/existing/jdk/8/or/9/home/directory
jenv shell ${someversion}

```

#### build it

```bash
cd jdk8/langtools
ant -f make/build.xml -Dboot.java.home=$(jenv javahome)

echo "export JAVA_ZONE_COMPILER=$(pwd)/build/bootstrap/bin/javac" >> ~/.bash_profile
```

#### verify this project

```bash
git clone git@github.com:viqueen/javazone.git
cd javazone
mvn -e clean verify
```

