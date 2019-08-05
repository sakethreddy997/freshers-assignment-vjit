/*Stage 1: Creating a Registration view for the user*/

 download mysql connector and add it to your project.
ceate a class (MyConnection) to connect our login and register forms with mysql database

in the register form i have created a function (checkUsername) to check if the username you want to register is already exists in the database table

what we will check when the user click on the register button:
- if the username jtextfield is empty
- if the password jtextfield is empty
- if the retype_password text is equal to the password text
- if the username already exists in the database using the "checkUsername" function
in the login fom it's simple;
the user enter his mobile number and password and click on the login button,
and all we have to do is to check if a user with this mobile number and password already exists on the database
