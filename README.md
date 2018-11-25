##Why Central Exception Handling is Important

###1. You would like to hide the detailed application stacktrace appearing in the client

###2. You would like send a friendly application specific error message to the client

###3. You would not like to scatter exception handling code throughout your application

###4. How to do central exception handling

###5. Create a Domain Class for carrying the Exception Information i.e. RestAPIExceptionInfo.java

###6. Create Specific Exception Classes like HTTP400Exception.java HTTP404Exception.java etc

###7. Create central exception handler in one of two ways

###8. In the AbstractController
	
###9. Create a special class annotated with @ControllerAdvice 

###10. Throw the exception from the Controller / Service classes