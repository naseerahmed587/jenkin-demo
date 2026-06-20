pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Code checked out successfully'
            }
        }
        stage('Hello') {
            steps {
                echo "Build triggered by branch: ${env.BRANCH_NAME ?: 'main'}"
                echo "Build number: ${env.BUILD_NUMBER}"
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
    }
}