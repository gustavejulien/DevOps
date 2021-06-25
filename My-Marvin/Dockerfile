FROM jenkins/jenkins:lts

# copy the list of plugins we want to install
COPY plugins.txt /usr/share/jenkins/plugins.txt

# run the install-plugins script to install the plugins
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

# disable the setup wizard as we will set up jenkins as code :)
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# copy the config-as-code yaml file into the image
COPY my_marvin.yml /usr/local/my_marvin.yml
COPY job_dsl.groovy /usr/local/job_dsl.groovy

# tell the jenkins config-as-code plugin where to find the yaml file
ENV CASC_JENKINS_CONFIG /usr/local/my_marvin.yml