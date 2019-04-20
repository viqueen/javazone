## JavaZone - Make your own Java

### Requirements

1. [git](https://git-scm.com/)
2. [jEnv](http://www.jenv.be/)
3. [mvnvm](http://mvnvm.org/)
4. [jdk 12](https://medium.com/r/?url=https%3A%2F%2Fadoptopenjdk.net%2F%3Fvariant%3Dopenjdk12%26jvmVariant%3Dhotspot)
5. Common Sense

#### OpenJDK source

```bash
git clone https://github.com/viqueen/jdk.git
```

#### configure it

Use `jenv` to manage jdk versions, you will need to add an existing jdk 8 or 9 as managed version, then set
the current terminal shell to use that version.

```bash
jenv add /path/to/an/existing/jdk/12/home/directory
jenv shell ${someversion}
```

#### build it

```bash
cd jdk
bash configure

make images
jenv add build/macosx-x86_64-server-release/jdk/

```

#### verify this project

```bash
git clone git@github.com:viqueen/javazone.git
cd javazone

echo "export JAVAZONE_COMPILER=$(jenv javahome)/bin/javac" >> ~/.bash_profile

mvn -e clean verify
```

