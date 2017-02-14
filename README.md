VerifyAddres
============
# Spring beans via spring.xml configuration

Calls USPS Address Verification API to validate a Address

Eclipse Project Properties: Deployment Assembly to add all Maven Dependency to Eclipse Tomcat container. If run on server is failing for eclipse web project, try this option.

#Steps to Convert Maven Project to Eclipse Dynamic WebProject:
1. First check whether your eclipse is in Jave EE Perspective or not. If it was in only Java perspective, run option will not come.Project Settings --> Java Compiler --> Project Facets --> Choose dynamic web project and Java(version 1.8)
2. Project Settings --> Java Compiler --> update to java version :1.8
3. Project Settings --> Maven --> Java EE Integration --> (check)Enable Project Specific Settings,(check)Enable Java EE Configuration
4. Add src/main/webapp as "source folder" to map web-resources (Optional)
5. Eclipse Project Properties: Deployment Assembly to add all Maven Dependency to Eclipse Tomcat container. Also add source: "src/main/webapp", Deploy Path: "/"

#Create a fat jar with maven assembly plugin:
https://www.mkyong.com/maven/create-a-fat-jar-file-maven-assembly-plugin/

#Create a fat jar with maven shade plugin:
https://www.mkyong.com/maven/create-a-fat-jar-file-maven-shade-plugin/
