def COLOR_MAP = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']
pipeline {
  agent any

//  triggers {
//    cron('*/5 * * * *')
//  }

  options {
    ansiColor('xterm')
    timestamps()
    buildDiscarder(logRotator(daysToKeepStr: '5'))
  }

  environment {
    ANSIBLE_HOST_KEY_CHECKING = 'False'
    ANSIBLE = '/usr/bin/ansible'
  }

  stages{
    stage("Run ansible command"){
      steps {
        sh """
          ansible-inventory -i labs/host01 --graph
          ${ANSIBLE}  -i labs/host01 nginx
            -e ansible_ssh_user=vagrant \
            -e ansible_ssh_private_key_file=/var/lib/jenkins/vagrant.pem \
            --become  \
            -m shell \
            -a "pwd"
        """
      }
    }
  }

}
