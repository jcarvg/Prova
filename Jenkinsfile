pipeline {

    agent any

    stages{


        stage('Build'){

                    steps{
                        bat "gradle clean test"

                    }

                }
        stage('Teste de HealthCheck'){

            steps{
                sh './gradlew test --tests "HealthCheckTest"'

            }

        }
        stage('Teste de Contrato'){

                    steps{
                       sh './gradlew test --tests "ContratoTest"'
                    }

        }
            stage('Testes Funcionais'){

                            steps{

                                sh 'gradle test --tests "FuncionalTest.java"'

                            }

                }

    }

}