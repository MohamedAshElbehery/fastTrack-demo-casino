This is a Katalon framework that uses chrome browser and written in Java.Groovy built to test demo-casino project as a challenge provided by Fast Track hiring team

To run the project: 
1- Install Katalon studio standalone version (you will find the katalon intsall file in google drive link attached to an email) 
2- open the git Icon and clone the project from the repo 'git@github.com:MohamedAshElbehery/fastTrack-demo-casino.git' 
3- Don't forget to update chrome driver through Tools > Update webdrivers > chrome

- The project uses BDD and POM best practices as you will find the page objects in their own folder labeled by page name

- Also follows OOP rules as you will find the code mudularized to avoid repetition

- The default profile is located in profiles entry it consists of 2 global variables since it's a small project and we don't have a lot of env variables

- You will find a test cases folder that contains of the tests and modules each in their own folder labeled by page name

- I have covered 6 scenarios including signup, login, approved deposit, failed deposit, casino game and buy a lottery ticket. I made the code modularized to avoid repetition and for calling the same module with different parameters and it changes it's behaviour accordingly. As an enhancment I would have added a login module with storing a cookie to avoid login with GUI in every time to save execution time.

- To run the tests you simply go to the tests folder and go to the folder containing the page you want to test then go to the test, it will first open in manual view so you have to go to script view to see the code it's located at the bottom of the page, beside it you will find the variables tab which contains the variables used in the tests

- so to run the test you go to the test and click the green run button on the top of the page

- I covered all the tasks including using the casino busy cat game by switching to it's iframe and filling the data also got the out puts and cleaned it by a string split module and asserted by comparing initial and final balances

- You will find in the modules section some helper modules I created to organize code and avpid repetition

- you will also find videos attached to the repo

- I used git commands like clone, commit, and push http link to repo: [https://github.com/MohamedAshElbehery/nomo-challenge.git](https://github.com/MohamedAshElbehery/fastTrack-demo-casino.git) ssh : git@github.com:MohamedAshElbehery/fastTrack-demo-casino.git

You will find the videos attached to the repo under the folder Videos

##talk to you soon
