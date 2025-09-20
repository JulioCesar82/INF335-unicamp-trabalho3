pipeline {
    agent any

    tools {
        // Assume que o Maven e o JDK estão configurados no Jenkins
        maven 'Maven_3.8.1' // Substitua pelo nome da sua instalação Maven no Jenkins
        jdk 'JDK_1.8'       // Substitua pelo nome da sua instalação JDK no Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/JulioCesar82/INF335-unicamp-trabalho3.git' // Substitua pela URL do seu repositório
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
    post {
        always {
            // Ações a serem executadas sempre, independentemente do resultado
            echo 'Pipeline finished.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
