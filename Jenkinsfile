pipeline {
    agent any
    environment { SONARQUBE_SERVER = 'sonarqube' }
    stages {
        stage('Checkout') { steps { checkout scm } }
        stage('Build & Test') { steps { sh 'mvn -B clean test' } }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("$"+"{SONARQUBE_SERVER}") { sh 'mvn -B sonar:sonar' }
            }
        }
        stage('Quality Gate') {
            steps { timeout(time: 5, unit: 'MINUTES') { waitForQualityGate abortPipeline: true } }
        }
    }
    post { always { junit 'target/surefire-reports/*.xml' } }
}