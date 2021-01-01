# FileDB

### What is fileDB?

     FileDB is a library that will store a key value pairs in Json format.
     
## Actions : 

### Create 
  Create, creates an entry in DB.
  
  #### For Example : 
    ``` 
    FileDB fileDB = new FilDB("path (Optional)");
    fileDB.create("key", "Value");
    
    ```
    ##### Throws FileDBException
    
  SNo | Parameter | Type 
--- | --- | --- |
 1. | key | String
 --- | --- | --- |
 2. | value | Object
 --- | --- | --- |
 3. | timeLimit (Optional) | integer (Seconds)
 
### Delete 
  Delete operation deletes a particular key value from the DB.
  
  For Example : 
    ```
        fileDB.delete("key");
    ```
    ##### Throws FileDBException
    
 ### Get 
  Get, retrives specific key's value from the DB
  
  For Example : 
    ```
        fileDB.get("key");
    ```
    ##### Throws FileDBException
    
  ### Limitations : 
   - Key should be a string and should not exceed 32 charachters.
   - Value can be of any type
