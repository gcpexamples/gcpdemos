
# Case when packaged war is preexisting

In this demo , we are using prexisting packaged war of a java webapplication,

## Note: war is not provided in repository

1) Step into maven project directory of a maven application and run mvn package -DskipTests=true ,this will give war file in target directory
 
2) make sure application is running on port 8080 in case you want to use this example for cloud run also

3) copy the war and rename is to demo.war  and keep it in the directory where Dockerfile exists

4) now you can do docker image building and running container instance, you can also use this example for cloud run
  
