pipeline {
    agent any

    environment {
            JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'
            PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Code checked out successfully'
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'chmod +x mvnw'
                        sh './mvnw clean package -DskipTests'
                    } else {
                        bat 'mvnw.cmd clean package -DskipTests'
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh './mvnw test'
                    } else {
                        bat 'mvnw.cmd test'
                    }
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
        success {
            echo '✅ Build and tests passed!'
        }
        failure {
            echo '❌ Build failed — check console output above'
        }
    }
}