import org.devopsgate.*
import static groovy.json.JsonOutput.* 
  
def call(Map param){
def buildfun = new Build(this)
pipeline{
  agent {
    kubernetes {
  yaml """
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
    }
  
  }
stages {

stage("clone") {
  steps{
     
    checkout([$class: 'GitSCM',
          userRemoteConfigs: [[name: 'origin', url: param.git_url, credentialsId: ' ']],
          branches: [[name: param.git_branch]],
          extensions: [
            [$class: 'CloneOption', shallow: false, timeout: 60],
            [$class: 'WipeWorkspace']
          ]])  
      }
}
     

stage("Build") {

   steps{
      
     script{

       buildfun.buildMvn("${param.mvnPath}")
}
   }

}

}

}
}
