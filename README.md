# SER 516 • Project 3 • Team 09

## Building

```bash
git clone https://github.com/SER516/ProjectThree_Team09
cd ProjectThree_Team09
mvn package
```

## Running

The `mvn package` command will build the client into an executable fat JAR file that includes the library dependencies. To execute the client, simply double-click on the JAR file in `target/` or run the following command in a terminal window.

```bash
java -jar target/project3-1.0-jar-with-dependencies.jar
```
## Import Project on Eclipse
File >> Import >> Maven >> Existing Maven Projects >> Browse to Project Folder(Directory with pom.xml) 

## Code Coverage

To run the unit tests and generate a code coverage report, run

```bash
mvn cobertura:cobertura
```

This will generate a static HTML site in `target/site/`. Open `target/site/index.html` in a web browser to view the code coverage report.

## Team Members

Team Members:
1. Zain Siddiqui (105, zsiddiq2@asu.edu)
2. Vishakha Singal (106, vsingal1@asu.edu)
3. Varun Srivastava (107, vsriva12@asu.edu)
4. Ganesh Kumar Subramanian Venkatraman (108, gsubra11@asu.edu)
5. Pratik Suryawanshi (109, psuryawa@asu.edu)
6. Sangeetha Swaminathan (110, sswami11@asu.edu)
7. Manish Tandon (111, mtandon3@asu.edu)
8. Maitreyi Thakkar (112, mthakka2@asu.edu) 
9. Janani Thiagarajan (113, jthiaga1@asu.edu)
10. Naga Ravi Teja Thoram (114, nthoram@asu.edu)
11. Adhiraj Tikku (115, atikku1@asu.edu)
12. Nelson Tran (116, nttran9@asu.edu)
13. Mohan Vasantrao Yadav (117, mvasantr@asu.edu)
