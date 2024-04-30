ATM.class: ATM.java Admin.class User.class Savings.class Checking.class Account.class
	javac -g ATM.java

Admin.class: Admin.java User.class Savings.class Checking.class Account.class
	javac -g Admin.java

User.class: User.java Savings.class Checking.class Account.class
	javac -g User.java

Savings.class: Savings.java Account.class
	javac -g Savings.java

Checking.class: Checking.java Account.class
	javac -g Checking.java

Account.class: Account.java
	javac -g Account.java

run: ATM.class
	java ATM

clean:
	rm *.class

debug: ATM.class
	jdb ATM