     @api   
   Feature: Check Get and Delete http methods
 Background: 
       Given Url
   
	Scenario: Get information for employee
	   When User send Get request for employee with id"1"
       Then User receives JSON responce for this employee
       
       
  
       Scenario: Delete information for employee
	  When User send Delete request for employee with id "1"
      Then User receives message "Successfully! Record has been deleted"
       

	  
    
      