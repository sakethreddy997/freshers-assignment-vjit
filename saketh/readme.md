# Swachh Bharat Kiosk
Swachh Bharat Kiosk application functions as follows:
- User can enter his/her details(Username, Password, and Phone number) as arguments, which will be checked against a text file with user details in members.txt.
- After logging in user gets 2 options
   1) General mode and
   2) Specialized mode.
- On selecting general mode the user can select the type of waste, quantity and capacity of each waste material. Quantity and capacity values are multiplied to get a value in ml which will be multiplied with a predefined value(weight of PET bottle/ glass/ can for holding certain ml of drink) in gm/ml and gives a resultant waste weight in gms. 
- On selecting specialized mode the user can directly select a particular waste(which includes brand, type and capacity) and quantity of it. A predefined value for that particular waste is multiplied with quantity to get total weight of waste in gms.
- In both the modes, the resultant waste weight is converted into points based on assumptions of weight to points ratio.
- These credited points are rounded of to nearest number and a unique code is generated to redeem it.

# Technical Information

- Java is the programming language used to develop this solution with command line interface.
- Maven/ Classpath dependencies are included for random coupon generation.
