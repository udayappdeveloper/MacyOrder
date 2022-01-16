pipeline {
    agent any
    
    tools{
        
        maven "INSTALLED_MAVEN"
    }
   

    stages {
        stage('Checkout') {
            steps {
               git branch: 'master', credentialsId: 'git_credentials', url: 'https://github.com/udayappdeveloper/MacyOrder.git'
           
            }

        }
        
        stage('Build'){
            
            steps{
                
                bat 'mvn clean package'
            }
        }
       
    stage('Test'){
            
            steps{
                
                bat 'mvn test'
            }
        }
     
    }
}