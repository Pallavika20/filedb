# FileDB

### What is fileDB?

     FileDB is a library that will store a key value pairs in Json format.
     
## Actions : 

### Create 
  Create, creates an entry in DB.
  
  #### For Example : 
  
 ```java 
 FileDB fileDB = new FileDB('path'(Optional));
 fileDB.create('key','value','timeToLive'(Optional));
 ```
    
   ##### Throws FileDBException
    
| Parameter | Type |
| ------------- | ------------- |
| Key  | String  |
| Value | Object  |
| Time to Live | Seconds  |
 
### Delete 
  Delete operation deletes a particular key value from the DB.
  
  For Example :
  
```java
        fileDB.delete("key");
 ```
   ##### Throws FileDBException
    
 ### Get 
  Get, retrives specific key's value from the DB
  
  For Example :
  
```java
        fileDB.get("key");
```
  ##### Throws FileDBException
    
  ### Limitations : 
   - Key should be a string and should not exceed 32 charachters.
   - Value can be of any type
   - Overall value size is limited to 16KB

