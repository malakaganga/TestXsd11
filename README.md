# TestXsd11

Download the Xerces2 Java 2.11.0 (XML Schema 1.1) (Beta) binaries from Xerces website Link: http://xerces.apache.org/mirrors.cgi. 

And install following jars in to maven locally

1. cupv10k-runtime.jar
2. org.eclipse.wst.xml.xpath2.processor_1.1.0.jar
3. xercesImpl.jar
4. xml-apis.jar

Using following command

mvn install:install-file -Dfile=<path-to-file> -DgroupId=<group-id> -DartifactId=<artifact-id> -Dversion=<version> 
  
And add those dependencies to pom.xml file

Then use mvn clean install to build the project
