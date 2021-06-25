folder('Tools') {
   displayName ('Tools')
   description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    parameters {
        stringParam("GIT_REPOSITORY_URL", null, "Git URL of the repository to clone")
    }
    steps {
        shell('git clone ${GIT_REPOSITORY_URL}')
    }
    wrappers{
        preBuildCleanup()
    }
}

freeStyleJob('Tools/SEED') {
    parameters {
        stringParam("GITHUB_NAME", null, "GitHub repository owner/repo_name (e.g.: \"EpitechIT31000/chocolatine\")")
        stringParam("DISPLAY_NAME", null, "Display name for the job")
    }
    steps {
        jobDsl {
            scriptText('''
                job(DISPLAY_NAME){
                    properties {
                        githubProjecUrl("git@github.com:"+GITHUB_NAME)
                    }
                    scm{
                        github(GITHUB_NAME)
                    }
                    wrappers{
                        preBuildCleanup()
                    }
                    triggers{
                        scm("* * * * *")
                    }
                    steps{
                        shell("make fclean")
                        shell("make")
                        shell("make test")
                        shell("make clean")
                    }
                }
            '''.stripIndent())
        }
    }
}
    