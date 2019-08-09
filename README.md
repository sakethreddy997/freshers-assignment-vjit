
# freshers-assignment-vjit

# Project Analysis

As part of any software project , the first and foremost thing is to start it with gathering the requirments. <br />
Using these particular requirments identified  , need to analyze how to build the system, and all these documents are placed in Work_progress  , Flow_diagrams folder.<br />

# Requirments
java programming language <br />
jdk 1.7.1 <br />  
junit -to test the application <br />
Any of the ide  ex: Intellij , eclipse , netbeans. <br />
understanding over oops concepts.<br />
Maven ie, used as a build tool.<br />

# Client Requirment Analysis

As per the given requirments from client , the entire application is to be developed using java , and input parameters are to be given through command line interface  .<br />
First and foremost thing is , this is not a gui based project. <br />
Now, any person from any where in the world can execute this project for that we use Maven build tool , so that all the dependencies get downloaded on its own, and user can have a better experience <br />
using Maven we can bring the required dependencies , from remote server to local system.. <br />

# Approch
By making use of java programming , and concepts of object oriented programming , this project can be accomplished.  <br />
when the generated jar file is made to run on the local system , the console asks the user weather he is a new user or not and <br />
### Shows- New user[0] , old user [1]  <br />
if the user **enters 0** , then console prompts the user to enter his/her :  <br />
Name  <br />
email id  <br />
Mobile  no  <br />
and through this the details of the user gets stored in a file (to make these details to get stored into a seperate file ,we use concepts of : <br />
Files <br />
File Buffers  <br />
If User enters **1** , then he would be asked with with his mobile number and password <br />
* And now the user has enterd into the main screen of the recycling kiosk <br />
After the user enters into the Rubicon Kiosk operational Window , user would be shown with 3 operations<br />
Options would be like <br />
1.Plastic<br />
2.Glass<br />
3.Cans<br />
user would select either of them  , and enters the number of cans he want to place in the kiosk<br />
On the basis of the inputs given Kiosk calculates the total recycled weight , and gives user with some points <br />
These points are given as a coupon and can be used to redeem<br />

**user details are taken from the console and stored in a textfile**<br />
**using string tokenizers,user credentials are validated when he logins into the kiosk**<br />
**coupon code will be generated and assigned to a particular user**<br />



# References
To generate coupon code , used the 5th block from https://www.baeldung.com/java-random-string .
i found like this block of code is simple and , which can genrate he code directly.

# Improvments to be done
As of now , a coupon code is generated for a user when he enters all the details , but need to make this application to an <br />
extent of assigning the coupon code with the points.


   
Thankyou .
