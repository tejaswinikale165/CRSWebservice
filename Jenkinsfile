pipeline{

    agent any

    stages {

        stage('Git Checkout'){

            steps{

                script{

                    git branch: 'main', url: 'https://github.com/tejaswinikale165/CRSWebservice.git'
                }
            }
        }
        stage('UNIT testing'){

            steps{

                script{
                    sh 'mvn test'

                    //sh 'mvn test'
                }
            }
        }
        stage('Integration testing'){

            steps{

                script{

                    sh 'mvn verify -DskipUnitTests'
                }
            }
        }
        stage('Maven build'){

            steps{

                script{

                    sh 'mvn clean install'
                }
            }
        }
        stage('Static code analysis'){

            steps{

                script{

                    withSonarQubeEnv(credentialsId: 'jenkin-auth') {

                        sh 'mvn clean package sonar:sonar'
                    }
                   }

                }
            }
            stage('Quality Gate Status'){

                steps{

                    script{

                        waitForQualityGate abortPipeline: false, credentialsId: 'jenkin-auth'
                    }
                }
            }
            stage('Deploy'){
                
                steps{
                
                    script{
                    
                        deploy adapters: [tomcat9(credentialsId: '57d5c814-2636-4c4c-8f3f-473a75b612a1', path: '', url: 'http://localhost:8443/')], contextPath: 'Sprinboot', onFailure: false, war: '**/*.war'
                
                    }
            
                }
            }
        }

}
