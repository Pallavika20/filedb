# FileDB

### What is fileDB?

     FileDB is a library that will store a key value pairs in Json format.
     
## Actions : 

### Create 
  Create, creates an entry in DB.
  
  #### For Example : 
    ``` FileDB fileDB = new FilDB("path (Optional)");
        fileDB.create("key", "Value");
    ```
    ### Throws FileDBException

### Delete 
  Delete operation deletes a particular key value from the DB.
  
  For Example : 
    ``` 
        fileDB.delete("key");
    ```
    ###Throws FileDBException
    
 ### Get 
  Get, retrives specific key's value from the DB
  
  For Example : 
    ```
        fileDB.get("key");
    ```
    ###Throws FileDBException
    
  ### Limitations : 
   1. 
