pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                // Pull code from GitHub SCM
                checkout scm
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests with pytest'
                sh '''
                    python3 --version
                    pip3 install --user pytest
                    pytest -q
                '''
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging python file into wheel: calculator-1.0.0.whl'
                sh '''
                    # Install build tools
                    python3 -m pip install --user --upgrade pip
                    python3 -m pip install --user setuptools wheel

                    # Clean previous builds
                    rm -rf build dist *.egg-info

                    # Build wheel
                    python3 setup.py bdist_wheel

                    # Rename wheel to exact required name
                    mv dist/*.whl dist/calculator-1.0.0.whl

                    # Verify
                    ls -l dist
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check logs for errors.'
        }
    }
}
