pipeline {

    agent any

    stages{

            stage('Build'){
                steps{
                    git 'https://github.com/jcarvg/Prova.git'
                    bat 'gradlew.bat clean build'
                }
            }

             stage('Run Unit Tests'){
                            steps{
                                bat 'gradlew.bat run test'
                            }
             }
    }
}