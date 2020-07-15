import org.devopsgate.*
import static groovy.json.JsonOutput.*

// vars/sayHello.groovy
def call(String name = 'human') {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    echo "Hello, ${name}."
}
/*test = """
apiVersion: "v1"
kind: "Pod"
spec:
  containers:
  - name: node
    image: docker.io/node:latest
    imagePullPolicy: Always
    command:
    - cat
    tty: true
  
  nodeSelector:
    env: jenkins
  restartPolicy: "Never"
  securityContext: {}
  
"""
pipeline {
   agent any
	{
    kubernetes{
          
          yaml test
    }
   }
  stages {
  stage('checkout'){
        steps{          
            println "checkout"
        }  
    }

    
    stage('mvnBuild'){
        steps{
            script{
		    
		    prinln "maven"
               //build.buildMvn("${param.mvnPath}")
             
            }
        }
    }
	
    stage('archive') {
        steps{
            script{    
		    println "Test"
             // mvnBuild.archiver("${param.artifactsPath}")
             }                         
           }        
           }
  }
}

}*/
