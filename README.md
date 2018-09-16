# Course-4-Assignment
Problem Statement
In this course, you have learnt about software engineering topics ranging from version control to extreme programming, as well as backend development and using Spring, Hibernate, and PostgreSQL to build a backend application.

 

In this assignment, you’ll apply everything that you have learned in course 4 to build an image hoster similar to Imgur, one of the top 100 most visited websites in the world.

 

Goals of This Assignment
Through working on the image uploader, you’ll get a chance to experience what it is like to join an engineering team as a new, junior software engineer. Specifically, you’ll get a chance to familiarize yourself with the codebase by fixing a few bugs in the codebase. You’ll also get a chance to implement a few well-defined features to the image uploader and improve its functionalities.

 

Lastly, this project will also introduce you to new concepts to Spring MVC, Hibernate, PostgreSQL and unit testing. Some of these concepts will be explained to you, and, for some other concepts, you’ll have used Google and Stack Overflow to learn those concepts on your own. This experience will further enhance the experience of joining a new team as a junior software developer as mentioned above.

 

To-Do Tasks:
Part A: Fixing Issues

 

As part of this assignment, please triage and fix the following bugs in the image uploader:

User signup bugs:

A new user can sign up for an account using a username that has been previously registered. This should not be allowed, and this issue should be fixed

Please see this issue on Github, which provides more information and instructions.
 

Image upload issues:
If you upload an image with the same exact title as a previously uploaded image, it will get uploaded. But then, if you try to navigate to one of the images with the same title. The image uploader will display an error.

Please fix this issue, so that it should not show an error and take you to respective image’s page.

Please see this issue on Github

 

 

Part B: Implement  a new feature

After fixing the above issues, please implement the following features into the image uploader:

Please implement a new feature for user signup, where you will check the a) validity and b) length of the username and password fields upon user signup. Specifically,

The feature will display appropriate error(s) in the user signup view and notify the user if he or she is trying to register with a username that has been taken by another user

The feature will display appropriate error(s) in the user signup view and notify the user that username and password needs to be to be 6 characters or longer

The code to display the error messages in the user signup view has been written for you, and you can see the code for display errors under src/main/java/resources/templates/users/signup.html

If everything is implemented correctly, you should see something similar to the screenshots below.

Note: There is a HTML5 attribute called “minlength” that can do also do this min length check. However, not all browsers support the HTML5 “minlength” attribute. Also, as a general rule of thumb, the server should not blindly trust data send to it by the client.


Error Message
                                        Figure 3 - Username has been registered error message
                                               


Error Message
                                   Figure 4 - Username and password too short error messages

                                         

Allow users to leave comments on images, and, to implement this feature, you’ll have to add the following to the image uploader:

Create a Comment model class

Create a one-to-many relationship between the Image and Comment classes, and add/update the tables in the database accordingly

You can update the database schema by making the following changes to src/main/resources/hibernate.cfg.xm:

Uncomment the following lines:

<property name="hbm2ddl.auto">create</property>

<mapping class="com.upgrad.ImageHoster.model.User" />

<mapping class="com.upgrad.ImageHoster.model.Image" />

<mapping class="com.upgrad.ImageHoster.model.Tag" />

<mapping class="com.upgrad.ImageHoster.model.ProfilePhoto" />

Change <property name="hbm2ddl.auto">create</property> to
Change <property name="hbm2ddl.auto">update</property> 

And add  <mapping class="com.upgrad.ImageHoster.model.Comment" />

Once you make the changes, .please  restart your project. Hibernate will then create the Comment class and the one-to-many relationship between Image and Comment classes for you.

Or you can write SQL to create the Comment class and the one-to-many relationship between Image and Comment classes manually

Add the necessary Comment controller methods for users to create comments for an image

The code to write and display the comments in the image view has been created for you, so you don’t need to write any new views or update any existing views

If you implement this commenting correctly, you should see something similar to the screenshot below
 


Image
                                                         Figure 5 - Adding comments to images

                                                   

Please use Git and Github to conduct version control of your assignment code throughout your assignment development

As you’ve learned in the version control module, it is good software engineering practice to use version control while doing software development

In your submission, please include a link to your Github repo that contains the course 4 assignment code

Additional Notes
Spring, Unit Testing, and Mocking

Although you have learned about unit testing in this course, you’ve yet to learn about unit testing in the context of a Spring Boot project.

 

Therefore, in the Image Uploader project, we have written the unit tests for the controllers for you. We have also added comments to those unit tests to make the tests legible, so you can read the tests and understand what those tests are trying to accomplish.

 

If you would like to learn more about unit testing and mocking with Spring Boot, please refer to the following resources:

Spring MVC Test Framework

Spring: Testing the Web Layer

Spring Boot - Unit Testing and Mocking with Mockito and JUnit

Lastly, please feel to experiment with the unit tests, and write additional unit tests on your own.

 

HTTP Session

In the Image Uploader project, you’ll see that we are storing an User object (representing the currently logged in user) in a HttpSession object. This allows us to check if the current user is logged in or not by:

Looking at the HttpSession object and

See if an User object is stored under the key “currUser”

 

Now, you may wonder: 1) what are HTTP Sessions and 2) how do you use them in Spring? Please refer to the following resources to read more about HTTP Sessions, and how to use them in Spring:

What are sessions? How do they work?

Using Http Session With Spring Based Web Applications


 

@PathParam and @RequestParam

In the image uploader project, you’ll also see that we use two Spring specific concepts:

@PathParam -- to retrieve information about the URL that triggered the controller method

@RequestParam -- data that users have entered into HTML forms
 

You can read more about @PathParam and @RequestParam in the following links:

@RequestParam vs @PathVariable

How to explicitly obtain post data in Spring MVC?

 

Hint: @PathParam and @RequestParam will be very useful for you in implementing the image commenting feature.
