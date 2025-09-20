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
                git branch: 'feature/atividade-04', url: 'https://github.com/JulioCesar82/INF335-unicamp-trabalho3.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn -f atividade04/pom.xml clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn -f atividade04/pom.xml test'
            }
        }
        stage('Package') {
            steps {
                bat 'mvn -f atividade04/pom.xml package'
            }
        }
    }
    post {
        always {
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
