pipelineJob('k8s-deploy') {

  def repo = 'https://github.com/sprasad09/app-mono-helmstate.git'

  triggers {
    githubPush()
  }
  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('github-credentials')
            url(repo)
          }
          branch('kube')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}


pipelineJob('image-orchestrator-job') {

  def repo = 'https://github.com/sprasad09/app-mono-orchestrator.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('github-credentials')
            url(repo)
          }
          branch('kube')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}

pipelineJob('app-mono-build-job') {

  def repo = ''

  description("Pipeline for $repo")

  definition {
    cpsScm {
      lightweight(true)
      scm {
        git {
          remote {
            credentials('github-credentials')
            url(repo)
          }
          branch('kube')
          scriptPath('Jenkinsfile')
          extensions { }
        }
      }
    }
  }
}
