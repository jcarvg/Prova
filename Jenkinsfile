pipeline {

    agent any

    stages{


        stage('Teste de HealthCheck'){

            steps{

                gradle healthCheck

            }

        }
        stage('Teste de Contrato'){

                    steps{

                        gradle contrato
                    }

        }
            stage('Testes Funcionais'){

                            steps{

                                gradle funcional

                            }

                }

    }

}