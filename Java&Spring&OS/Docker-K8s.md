# Docker & Kubernetes

#### What is a Docker

Docker is a containerization technology which packages your application and all dependencies together in the form of containers so as to ensure that your application works similarly in any environment regarding development, test, and production.



#### What is a Docker container

Docker containers include the application and all of its dependencies, which is a runtime instance of Docker images



#### What is a Docker Image

Docker image is the source of Docker containers, it's used to create containers.



#### What is Docker Hub

Docker Hub is a registry that stores Docker images



#### Explain Docker Architecture

1. A server which is a type of long-running program called a daemon process
2. A REST API which specifies interfaces that programs can use to talk to the daemon and instruct it what to do
3. A command line interface client
4. The CLI uses Docker REST API to control or interact with the Docker daemon through CLI



#### What is a Dockerfile

Docker is able to automatically build images by reading the instructions from Dockerfile by using `docker build`

```
FROM 						-- Specifies the image that has to be downloaded
RUN 						-- Specifies the commands to be executed
ENTRYPOINT 			-- Specifies the command which will be executed first
EXPOSE					-- Specifies the port where the container is exposed
CMD							-- The commands need to be run when the container lauched
```



#### What is a Docker Compose file

Docker compose is a YAML file which contains details about the services, networks, and volumes for setting up Docker application, with which we can create separte containers, host them and get them to communicate with each other.



#### Docker basic CMDs



#### What is Kubernetes

Kubernetes is an open-srouce container orchestration platform.



#### How does K8s relate to Docker

When Kubernetes schedules a pod to a node, the kubelet running on that node instructs Docker to launch the containers



#### What is container orchastration

Container orchestration is the automation of components and processes related to running containers. It includes things like configuring and scheduling containers, the availability of containers, allocation of resources between containers, and securing the interation between contains, among other things



#### What is K8s clusteres

A kubernetes cluster is a set of nodes that containerized applications run on



#### What is a pod

A pod is the most basic Kubernetes object. A pod consists of a group of containers running in the cluster.



