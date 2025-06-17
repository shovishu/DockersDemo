pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Get the source code from version control (e.g., Git).'
                git 'https://github.com/shovishu/DockersDemo.gi'
            }
        }
        stage('Build') {
            steps {
                echo 'Compile the maven project...'
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    def deployEnv = 'staging'
                    echo 'Deploying to ${deployEnv} environment...'
                }
            }
        }
    }
}
