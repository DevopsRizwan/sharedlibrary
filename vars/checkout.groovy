#!/usr/bin/env groovy
def call( String test) {

       /* checkout([$class: 'GitSCM',
          userRemoteConfigs: [[name: 'origin', url: env.GIT_URL, credentialsId: ' ']],
          branches: [[name: env.GIT_BRANCH]],
          extensions: [
            [$class: 'CloneOption', shallow: false, timeout: 60],
            [$class: 'WipeWorkspace']
          ]])
     
*/
        
        println "$test"
        
        }
