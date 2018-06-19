#!/bin/bash

javac Hello.java
native-image Hello

echo

echo "Java"
time java Hello

echo "Java + JVMCI"
time java -XX:-UseJVMCICompiler Hello

echo "natie-image"
time ./hello
