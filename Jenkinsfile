pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests with pytest'
                bat '''
                    python --version
                    pip install pytest
                    pytest -q
                '''
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging python file into wheel: calculator-1.0.0.whl'
                bat '''
                    REM Install build tools
                    python -m pip install --upgrade pip
                    pip install setuptools wheel

                    REM Clean previous builds
                    rmdir /s /q build 2>nul
                    rmdir /s /q dist 2>nul
                    del /q *.egg-info 2>nul

                    REM Build wheel
                    python setup.py bdist_wheel

                    REM Rename wheel to exact required name
                    for %%f in (dist\\*.whl) do rename "%%f" calculator-1.0.0.whl

                    REM Verify
                    dir dist
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
