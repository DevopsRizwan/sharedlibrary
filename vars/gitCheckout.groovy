import org.devopsgate.*
import static groovy.json.JsonOutput.*

// vars/sayHello.groovy
def call(Map param) {
          
          print "test"

checkout([$class: 'GitSCM',
          userRemoteConfigs: [[name: 'origin', url: param.git_url, credentialsId: ' ']],
          branches: [[name: param.git_branch]],
          extensions: [
            [$class: 'CloneOption', shallow: false, timeout: 60],
            [$class: 'WipeWorkspace']
          ]])
          
}
