import org.devopsgate.*
import static groovy.json.JsonOutput.*

def call(Map param) {
    println prettyPrint(toJson(param))
    def build = new Build(this)
pipeline {
	agent {
      label "${param.label}" 
  }
  environment {
    MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=128m"
}
  stages {
  stage('checkout'){
        steps{          
             checkout([$class: 'GitSCM', branches: [
				[name: "master"]
				], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [
				[ url: '']
					]])
        }  
    }

    
    stage('mvnBuild'){
        steps{
            script{
               //build.buildMvn("${param.mvnPath}")
             
            }
        }
    }
	
    stage('archive') {
        steps{
            script{              
             // mvnBuild.archiver("${param.artifactsPath}")
             }                         
           }        
           }
  }
}
}