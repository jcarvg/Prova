pipeline {

    agent any

    stages{

      stage('Checkout') {
                steps { //Checking out the repo
                    checkout changelog: true, poll: true, scm: [$class: 'GitSCM', branches: [[name: '*/master']], browser: [$class: 'Github', repoUrl: 'https://github.com/jcarvg/Prova'], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git', url: 'ssh://git@github.com:jcarvg/Prova.git']]]
                }
      }

        stage('Build'){
                    steps{
                        script{
                            sh "./gradlew clean test"
                        }
                    }
        }
        stage('Teste de HealthCheck'){

            steps{
                sshagent(['git']) {
                    script {
                        sh './gradlew HealthCheckTest --no-daemon'
                    }
                }
            }
        }
        stage('Teste de Contrato'){
             steps{
                sshagent(['git']) {
                    script {
                        sh './gradlew ContratoTest --no-daemon'
                    }
                }
            }
        }
            stage('Testes Funcionais'){
                steps{
                    sshagent(['git']) {
                        script {
                            sh './gradlew FuncionalTest --no-daemon'
                        }
                    }
                }
            }
    }
}