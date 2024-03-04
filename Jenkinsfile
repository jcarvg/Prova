pipeline {

    agent any

    stages{


        stage('Teste de HealthCheck'){

            steps{

                sh 'gradle test --tests java/testeHealthCheck/HealthCheckTest.java'

            }

        }
        stage('Teste de Contrato'){

                    steps{

                       sh 'gradle test --tests java/testeContrato/ContratoTest.java'
                    }

        }
            stage('Testes Funcionais'){

                            steps{

                                sh 'gradle test --tests java/testeFuncional/FuncionalTest.java'

                            }

                }

    }

}