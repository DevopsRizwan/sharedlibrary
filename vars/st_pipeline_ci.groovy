import org.devopsgate.*
def call(Map param){

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
      
     def buildfun = new Build(this)

       buildfun.buildMvn("${param.mvnPath}")
}

}

}

}
