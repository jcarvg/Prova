pipeline {

    agent any

    stages{


        stage('Teste de HealthCheck'){

            steps{

                gradle test --tests test.java.testeHealthCheck.HealthCheckTest

            }

        }
        stage('Teste de Contrato'){

                    steps{

                        gradle test --tests test.java.testeContrato.ContratoTest
                    }

        }
            stage('Testes Funcionais'){

                            steps{

                                gradle test --tests test.java.testeFuncional.FuncionalTest

                            }

                }

    }

}