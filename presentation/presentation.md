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
# What it really is

TODO maybe here should be something more introductory???

TODO image of graalVM layers

---
# 

---
name: inverse
layout: true
class: center, middle, inverse

# Demo time

---
# Native

TODO do I want to talk about it?

myabe just demo native java, show startup time and image size

???
```git branch  ```

possible question - anyone knows when it cannot be used?

---
# Polyglot

[](localhost:8080/)

---
name: inverse
layout: true
class: center, middle, inverse
# Questions?

---
layout: false
# Simple-complex app

![](app-arch.svg)

---
# What is kubernetes?

[Kubernetes](kubernetes.io) is an open-source system for automating deployment, scaling, and management of containerized applications.

Not an orchestrator but rather an controller, 
  a manager of containers that promisses to keep desired state of containers configuration.

![](ui-dashboard-node.png.jpg)
<!-- .footnote[kubernetes.io] -->

---
# Contenerization - Docker

```Dockerfile
FROM scratch

EXPOSE 8080

COPY k8sFirstSteps-linux /usr/bin/app
ENTRYPOINT [ "/usr/bin/app", "8080" ]
```

---
# Create a k8s cluster

```bash
gcloud beta container clusters create "cluster-1"
  --machine-type "g1-small"
  --preemptible
  --num-nodes "3"
```

---
# The "real" command

```bash
gcloud beta container clusters create "cluster-1"
  --machine-type "g1-small"
  --preemptible
  --num-nodes "3"
  --enable-cloud-logging
  --disk-size "10"
  --cluster-version "1.9.6-gke.0"
  --username "admin"
  --scopes "https://www.googleapis.com/auth/compute","https://www.googleapis.com/auth/devstorage.read_only","https://www.googleapis.com/auth/logging.write","https://www.googleapis.com/auth/monitoring","https://www.googleapis.com/auth/servicecontrol","https://www.googleapis.com/auth/service.management.readonly","https://www.googleapis.com/auth/trace.append"
  --enable-cloud-monitoring 
  --addons HorizontalPodAutoscaling,HttpLoadBalancing,KubernetesDashboard
```
???
```
gcloud beta container clusters create "cluster-1" --machine-type "g1-small" --preemptible --num-nodes "3" --enable-cloud-logging --disk-size "10" --cluster-version "1.9.6-gke.0" --username "admin" --scopes "https://www.googleapis.com/auth/compute","https://www.googleapis.com/auth/devstorage.read_only","https://www.googleapis.com/auth/logging.write","https://www.googleapis.com/auth/monitoring","https://www.googleapis.com/auth/servicecontrol","https://www.googleapis.com/auth/service.management.readonly","https://www.googleapis.com/auth/trace.append" --enable-cloud-monitoring  --addons HorizontalPodAutoscaling,HttpLoadBalancing,KubernetesDashboard
```

---
# Start using the cluster

```bash
gcloud container clusters get-credentials test1
make dpush
kubectl run k8sfs --image eu.gcr.io/jugpoznan2018/k8sfirststeps
kubectl get all
```
???
```
gcloud container clusters get-credentials test1
make dpush
kubectl run k8sfs --image eu.gcr.io/jugpoznan2018/k8sfirststeps
kubectl get all
```

---
# k8s deployment building blocks

* Containers under the hood
* Workloads-Pod
* Controllers
* Service
* Storage
* Configuration & Administration

.footnote[https://kubernetes.io/docs/concepts/]
---
# Pod

![](pod.jpg)

---
# Pod

Basic building block.

Usually you don't create it by yourself. 

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: httpcmd
spec:
  containers:
    - name: httpcmd
      image: registry.gitlab.com/kskitek/httpcmd:latest
```

---
# Controllers

* Deployments
* ReplicaSets
* ReplicationControllers
* StatefulSets
* CronJobs

???
You describe a desired state in a Deployment 

Pod + ReplicaSet ~= Deployment
```bash
kubectl rollout history
kubectl rollout undo
kubectl scale deployment
kubectl set image
```

---
# Storage

* Volumes
* PersistentVolumes

???

Volumes in Docker are just directories..

In k8s Volume lives inside Pod. Kill a container (Deployment) inside 

---
# Secrets

```bash
kubectl create secret docker-registry gitlab
 --docker-server=registry.gitlab.com
 --docker-username=kskitek
 --docker-email=krzysztof.skitek@gmail.com
 --docker-password=???
```

???
Administration & Configuration

Also:
* ConfigMaps
* Labels
* Proxy
* Device Plugins (GPUs, TPUs, RDMA)
* Certificates, Auth, Authorization
* Metrics and Auditing

---
# Why?

TODO https://thenewstack.io/kubernetes-an-overview/

---
# Contenerization - docker-compose
.left-column[
```yaml
version: '3'
services:
  influx:
    image: influxdb
    ports:
      - 8086:8086
    expose:
      - 8086
    deploy:
      resources:
        limits:
          memory: 100M
    environment:
      - INFLUXDB_DB=mes
  
  chronograf:
    image: chronograf
    ports:
      - 8888:8888
    deploy:
      resources:
        limits:
          memory: 50M
```
]
.right-column[
```yaml
  generator:
    image: none_yet
    ports:
      - 8080:8080
    deploy:
      resources:
        limits:
          memory: 5M














_
```
]

---
# kompose.io

```bash
kompose convert -f docker-compose.yaml
```

---
# Dashboard

```terminal
kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/src/deploy/recommended/kubernetes-dashboard.yaml
```
![](https://d33wubrfki0l68.cloudfront.net/a144cb4570dc95ebc2e35b4b748a0e5ee71879dd/e3d2d/images/docs/ui-dashboard-node.png)

---
# minikube

---
# Private docker images

TODO deployment with private image
Secrets

---
# GKE

---
# gcloud build triggers

---
# gitlab integration

---
# Jenkins X

---
# Helm

---
name: inverse
layout: true
class: center, middle, inverse
# Questions?
