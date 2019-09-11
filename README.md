# Java Environment VirtualBox

**DOWNLOAD: [VIRTUAL MACHINE](https://github.com/Virtual-Machines/Java-Environment-VirtualBox/releases/download/latest/JavaEnvironmentVirtualBox.ova) - [ONLY PROJECT CODE](https://github.com/Virtual-Machines/Java-Environment-VirtualBox/archive/master.zip)**

Last update: 2019-09-11

*VIRTUAL MACHINE*

![Desktop](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/desktop.png)
![Jasper Reports](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/jasperreports.png)
![FileZilla](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/filezilla.png)
![Putty](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/putty.png)
![GIMP](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/gimp.png)
![Gnumeric](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/gnumeric.png)
![DBeaver](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/dbeaver.png)
![DBeaver Diagram](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/dbeaverDiagram.png)
![Kazam](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/kazam.png)
![uGet](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/uget.png)
![Apache Directory Studio](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/apacheDirectoryStudio.png)
![Project Libre](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/projectLibre.png)

- Minimal Lubuntu 18.04.3 as a lightweight base (lubuntu-core package)
- Linux Kernel 5 HWE (Hardware Enablement)
- VirtualBox Guest Additions (bidirectional clipboard between host and guest, shared folders capable, Seamless Mode...)
- Synaptic package manager
- Basic python http server included. Example: python3 -m http.server 8080
- Command-line download manager: wget
- NAT port forwarding configured on 8080 that allows web browser testing outside virtual machine
- OpenJDK 8
- Eclipse 4.12 (2019-06) Java EE with Maven, Gradle, JPA, JSF, Mylyn and Egit (Git)
- Java project configured
- JasperSoft Studio Community (JasperReports) as Eclipse plugin
- SonarLint (real-time code audit by SonarSource, the creators of SonarQube) as Eclipse plugin
- Subclipse (SVN Team Provider) as Eclipse plugin (SVN connector installed and configured)
- ObjectAid Class Diagram Tool
- PostgreSQL and DBeaver
- PuTTy
- FileZilla
- Local mail testing server that is easy to integrate with javax.mail: Postfix (SMTP), mailutils, courier-pop and courier-imap
- Mozilla Thunderbird as mail client with account example: lubuntu@lubuntu
- Basic python http server included. Example: python3 -m http.server 8080
- NAT port forwarding configured on 8080 that allows web browser testing outside virtual machine
- Mozilla Firefox
- Chromium browser
- Useful tools for website images processing and optimization: optipng, pngquant, jpegoptim and ImageMagick
- GIMP
- Gnumeric: a spreadsheet computer program that can automate scripts through formulas like Excel and Calc
- VLC as audio and video player
- Kazam as screen recorder
- uGet Download Manager
- Apache Directory Studio (bundled with ApacheDS) as LDAP and Kerberos tool
- Project Libre


- User and pass of system is the same: **lubuntu**
- Postgresql pass is the default: **postgres**
- Import OVA on VirtualBox using "File -> Import Appliance (or Control + I)"

*PROJECT CONTENTS*

![Eclipse](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/eclipse.png)
![Tomcat](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/tomcatRun.png)
![App Login](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/appLogin.png)
![App List](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/appList.png)
![App New User Validation](https://raw.githubusercontent.com/Virtual-Machines/Java-Environment-VirtualBox/master/appNewUserValidation.png)

**FRONTEND (see webapp folders)**
- HTML5, CSS and JS
- Jquery
- Bootstrap
- Font Awesome

**BACKEND (see Maven pom.xml)**
- Spring MVC
- Jackson databind for JSON response body (convert DTOs to json)
- Spring Security (authentication): config, web and taglibs
- Javax validation (form validation)
- Spring ORM
- Hibernate (map DB tables to Java Entities)
- PostgreSQL driver (change to other BDs driver if needed)
- HikariCP (Database Connection Pool)
- Javax servlet, JSP and JSTL
- JUnit (unit testing)
- Selenium Java (functional testing)
- Monte screen recorder (useful for storing automated testing as video)
- Log4j2 (register logs)
- Apache Commons Lang and Collections (utilities libraries)
- Dozer Mapper (convert Entities to DTOs)
- Javax Mail (send mail on application)
- Jasper Reports (create PDF reports)
- JavaMelody Monitoring (see application status)
