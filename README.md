# PlivoTest

Prerequisite
Eclipse
Jdk 1.8


About Project 

There are two test classes 
1. sendMessage 
2. getMessage
<br>sendMessage test class has test data for sending message ie src,dst and message and a testcase Id.
resposne from sendMessage is set in MessageLogs testcase id(t1)
getMessage is invoked from testng and testdata provided in this class must have same testcas id as of sendMessage testcase id(t1)
response from getMessage is Asserted on basis of message_status to be sent


Steps To Run 
1. Clone and import in your eclipse as  maven project.
2. Execute at suite level run testng.xml file as Testng Suite.
3. Reports are generated as Emailable report in test-output folder 



