Calculator Maven Web Application
=================================

Requirements:
- JDK 8 or later
- Maven
- Apache Tomcat 9 (this project uses javax.servlet and is intended for Tomcat 9)

Build:
1. Open a terminal in the Calculator-Maven-Project folder.
2. Run: mvn clean package
3. The WAR file will be created at: target/Calculator.war

Deploy to Tomcat 9:
1. Copy target/Calculator.war into Tomcat's webapps directory.
2. Start Tomcat.
3. Open: http://YOUR_SERVER_IP:8080/Calculator/

Example copy command (adjust the Tomcat path if needed):
sudo cp target/Calculator.war /opt/tomcat/webapps/

For an EC2 instance, allow inbound TCP port 8080 in its security group.
