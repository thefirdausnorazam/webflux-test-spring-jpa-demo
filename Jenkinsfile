pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }

  post {
    always {
      archive 'target/**/*.jar'
    }
  }
  
}