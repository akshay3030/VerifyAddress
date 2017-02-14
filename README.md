VerifyAddres
============
# Spring beans via spring.xml configuration

Calls USPS Address Verification API to validate a Address

Eclipse Project Properties: Deployment Assembly to add all Maven Dependency to Eclipse Tomcat container. If run on server is failing for eclipse web project, try this option.

#Steps to Convert Maven Project to Eclipse Dynamic WebProject:
1. First check whether your eclipse is in Jave EE Perspective or not. If it was in only Java perspective, run option will not come. Right click on your project, go to properties.Click on Project Facets.Check whether Dynamic Web module is check marked or not. If not just check marked it. Along with Java 8 ,if necessary.
2. Project Settings --> Java Compiler --> update to java version :1.8
3. Project Settings --> Maven --> Java EE Integration --> (check)Enable Project Specific Settings,(check)Enable Java EE Configuration
4. Add src/main/webapp as "source folder" to map web-resources (Optional)
5. Eclipse Project Properties: Deployment Assembly to add all Maven Dependency to Eclipse Tomcat container. Also add source: "src/main/webapp", Deploy Path: "/"

#Create a fat jar with maven assembly plugin:
https://www.mkyong.com/maven/create-a-fat-jar-file-maven-assembly-plugin/

#Create a fat jar with maven shade plugin:
https://www.mkyong.com/maven/create-a-fat-jar-file-maven-shade-plugin/
