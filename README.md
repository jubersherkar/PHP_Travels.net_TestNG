# PHP_Travels.net_TestNG
BDD framework using TestNG - Stable framework

How to start

1. Get clone of this repository into local.
2. Install TestNG and Natural plugins from eclips marketplace.
3. Download chromedriver.exe and place in drivers folder.
4. Right click on project --> Build path --> Configure build path --> click on Liabraries tab --> click on add liabrary --> Click on TestNG -->click on next.
5. Update pom.xml file (Do maven update)
6. Clean project by clicking on 'Project' in Menu bar.
7. Execute test using runner class or testng.xml file or pom.xml.
8. Commands to run tests from CLI -->

       mvn clean test -Dcucumber.filter.tags="@login"
	 mvn clean test -Dcucumber.features="src/test/resources/features/HomePage.feature"
	 mvn clean test -Dcucumber.plugin="html:target/cucumber-reports/cucumberReport.html"
	 mvn clean test -Dcucumber.features="src/test/resources/features/LoginPage.feature" -Dcucumber.filter.tags="@ValidCredentials"	 
      
