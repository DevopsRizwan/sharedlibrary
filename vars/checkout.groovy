def call(Map stageParams) {

        /*checkout([$class: 'GitSCM',
          userRemoteConfigs: [[name: 'origin', url: env.GIT_URL, credentialsId: ' ']],
          branches: [[name: env.GIT_BRANCH]],
          extensions: [
            [$class: 'CloneOption', shallow: false, timeout: 60],
            [$class: 'WipeWorkspace']
          ]])
      */
        
        checkout([$class: 'GitSCM', branches: [[name: 'master']],
    userRemoteConfigs: [[url: 'https://github.com/DevopsRizwan/spring-helm-demo.git']]])
        
        }
