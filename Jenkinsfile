pipeline {

    agent any

    stages{


        stage('Teste de HealthCheck'){

            steps{

                sh 'gradle test --tests test.java.testeHealthCheck.HealthCheckTest'

            }

        }
        stage('Teste de Contrato'){

                    steps{

                       sh 'gradle test --tests test.java.testeContrato.ContratoTest'
                    }

        }
            stage('Testes Funcionais'){

                            steps{

                                sh 'gradle test --tests test.java.testeFuncional.FuncionalTest'

                            }

                }

    }

}