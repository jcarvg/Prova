pipeline {

    agent any

    tools{
        nodejs "node 20.11.1"
    }

    stages{
            stage('Checkout'){
                steps {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url:'https://github.com/jcarvg/Prova.git']]])
                }
            }

            stage('Build'){
                steps{
                    bat 'npm install'
                    bat 'npm run build'
                }
            }

             stage('Run Unit Tests'){
                            steps{
                                bat 'npm run test'
                            }
             }
    }
}