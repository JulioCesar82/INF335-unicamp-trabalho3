// java -jar jenkins-cli.jar -s http://SEU_JENKINS_URL/ -auth SEU_USUARIO:SEU_TOKEN_API groovy = < configure_tools.groovy


import jenkins.model.Jenkins
import hudson.tools.JDKInstaller
import hudson.tools.JDKInstaller.DescriptorImpl
import hudson.tools.JDKInstaller.JDKFamily
import hudson.tools.JDKInstaller.Platform
import hudson.tools.JDKInstaller.CPU
import hudson.model.JDK
import hudson.tasks.Maven
import hudson.tasks.Maven.MavenInstallation

def inst = Jenkins.instance

// Configurar JDK
def jdkName = "JDK_1.8"
def jdkHome = "/usr/lib/jvm/java-8-openjdk-amd64" // Altere para o caminho real do seu JDK no agente
def existingJdk = inst.getDescriptorByType(JDK.DescriptorImpl.class).getInstallations().find { it.getName() == jdkName }

if (!existingJdk) {
    println "Adicionando JDK: ${jdkName}"
    def newJdk = new JDK(jdkName, jdkHome)
    inst.getDescriptorByType(JDK.DescriptorImpl.class).setInstallations(
        inst.getDescriptorByType(JDK.DescriptorImpl.class).getInstallations() + [newJdk]
    )
    inst.save()
} else {
    println "JDK: ${jdkName} já existe."
}

// Configurar Maven
def mavenName = "Maven_3.8.1"
def mavenHome = "/opt/apache-maven-3.8.1" // Altere para o caminho real do seu Maven no agente
def existingMaven = inst.getDescriptorByType(Maven.DescriptorImpl.class).getInstallations().find { it.getName() == mavenName }

if (!existingMaven) {
    println "Adicionando Maven: ${mavenName}"
    def newMaven = new MavenInstallation(mavenName, mavenHome)
    inst.getDescriptorByType(Maven.DescriptorImpl.class).setInstallations(
        inst.getDescriptorByType(Maven.DescriptorImpl.class).getInstallations() + [newMaven]
    )
    inst.save()
} else {
    println "Maven: ${mavenName} já existe."
}

println "Configuração de ferramentas concluída."
