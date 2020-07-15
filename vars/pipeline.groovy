import org.devopsgate.*
import static groovy.json.JsonOutput.*

def call(Map param) {
    println prettyPrint(toJson(param))
    def build = new Build(this)
test = """
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
   agent {
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
}
