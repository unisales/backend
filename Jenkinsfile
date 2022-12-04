pipeline {
  agent {
    docker { image 'uniapps/jdk' }
  }
  stages {
    stage('build') {
      steps {
        sh './gradlew --info build'
      }
    }
  }
}
