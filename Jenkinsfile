pipeline {
    agent any

    triggers {
        cron('30 16 * * *')
    }

    environment {
        deployEnv = 'staging'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Get the source code from version control (e.g., Git).'
                git 'https://github.com/shovishu/DockersDemo.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compile the Maven project...'
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
                echo "Deploying to ${env.deployEnv} environment..."
            }
        }
    }

    post {
        failure {
            emailext (
                subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Hi Team,</p>
                         <p>The build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> has <span style='color:red;'><b>FAILED</b></span>.</p>
                         <p>Check the console output at: <a href='${env.BUILD_URL}'>${env.BUILD_URL}</a></p>""",
                mimeType: 'text/html',
                to: 'shovishu@gmail.com'
            )
        }
        success {
            emailext (
                subject: "✅ Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Hi Team,</p>
                         <p>The build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> was <span style='color:green;'><b>SUCCESSFUL</b></span>.</p>
                         <p>Check the console output at: <a href='${env.BUILD_URL}'>${env.BUILD_URL}</a></p>""",
                mimeType: 'text/html',
                to: 'shovishu@gmail.com'
            )
        }
    }
}
