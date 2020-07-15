import org.devopsgate.*
import static groovy.json.JsonOutput.* 
  
def call(Map param){
def buildfun = new Build(this)
pipeline{
agent any
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
