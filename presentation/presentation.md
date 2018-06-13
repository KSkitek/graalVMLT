name: inverse
layout: true
class: center, middle, inverse
---
# Graal - one VM to rule them all

.footnote[http://github.com/KSkitek/graalVMLT]

---
layout: false
# Why talking about GraalVM

*TODO image of problem*
Java to R
Java to Python

---
# Problems

*TODO image again*
* Performance - network 
* Complexity - you have to provide some R/Python wrapper
* Debugging

---
# GraalVM to the rescue

* Native
* Polyglot
* Embedable

---
# JIT introduction

## Static vs dynamic compilation

???
https://www.slideshare.net/martintoshev/jvm-the-graal-vm

Pytania
* czym jest JIT
* czym jest HotSpot
* C1 i C2?

---
# What it really is

TODO maybe here should be something more introductory???

TODO image of graalVM layers

???
The whole idea is behind building AST and having AST interpreter 
---
name: inverse
layout: true
class: center, middle, inverse
---

# Demo time

---
# Native

### Hello vs native Hello

???

Questions:
* What is AOT?
* When native-image cannot be used?

---
# Polyglot

### Java in R?

[](localhost:8080/svg)

???

Java + R
JS + R
Java + JS

---
# Embedable

### Java + R on one VM?

???

TODO debugging Java + R
https://medium.com/graalvm/debugging-polyglot-node-js-ruby-r-apps-with-graalvm-81b1bb2614db

---
name: inverse
layout: true
class: center, middle, inverse
---
# Questions?