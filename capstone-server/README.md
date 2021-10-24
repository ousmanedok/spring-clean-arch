#Capstone Server
Springboot server using mongodb as a database, ``gradle`` as build tool, ``docker`` to helping with running the server
##File Structure:
``buildsystem/`` contains the scripts to run the server (See below for running the server)

```docker/``` contains the script that runs the java application. (``start_server.sh`) is run by docker after building the image.

```src/``` source code for the server


##Running the server using docker
1. If you don't have docker running on your local machine, install it using https://docs.docker.com/get-docker/
2. generate the jar file by running: ```./buildsystem/compile-and-test.sh```
3. command to start: ``./buildsystem/start-docker.sh``
4. If you want to clean resources and rebuild the docker images: ``./buildsystem/clean-and-rebuild.sh``

