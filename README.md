# REST-Domains-examples
Links for using:
### Links to rest controller that's using hibernate
***************************************************

1. http://localhost:8080/Practice/service/hibernate/goods method = GET -- get goods list 

2. http://localhost:8080/Practice/service/hibernate/goods/{id} method = GET -- get goods by id

3. http://localhost:8080/Practice/service/hibernate/goods method = POST -- save or update goods

4. http://localhost:8080/Practice/service/hibernate/goods method = DELETE -- delete goods

5. http://localhost:8080/Practice/service/hibernate/goods/page?page=&amount= method = GET -- pagination

6. http://localhost:8080/Practice/service/hibernate/goods/asc?field= method = GET -- sorting goods list by
 field in table (id, name, amount, price) by asc
 
7. http://localhost:8080/Practice/service/hibernate/goods/desc?field= method = GET -- sorting goods list by
  field in table (id, name, amount, price) by desc
  
8. http://localhost:8080/Practice/service/hibernate/goods/search/{name} method = GET -- search goods by 
  name with ignore case

9. http://localhost:8080/Practice/service/hibernate/goods/search?from=&to= method = GET -- search any goods which
  are in scope from and to
  
10. http://localhost:8080/Practice/service/hibernate/goods/search/{name}/scope?from=&to= method = GET
 -- search goods by name which are in scope from and to
 
### Links to rest controller that's using jdbcTemplate
***************************************************

1. http://localhost:8080/Practice/service/jdbctemplate/goods method = GET -- get goods list 

2. http://localhost:8080/Practice/service/jdbctemplate/goods/{id} method = GET -- get goods by id

3. http://localhost:8080/Practice/service/jdbctemplate/goods method = POST -- save or update goods

4. http://localhost:8080/Practice/service/jdbctemplate/goods method = PUT -- update goods

5. http://localhost:8080/Practice/service/jdbctemplate/goods/{id} method = DELETE -- delete goods by id

6. http://localhost:8080/Practice/service/jdbctemplate/goods/asc?count=&number=&field= method = GET --
 pagination
 
### Links to rest controller that's using plug
***************************************************

1. http://localhost:8080/Practice/service/goods method = GET -- get goods list 

2. http://localhost:8080/Practice/service/goods/{id} method = GET -- get goods by id

3. http://localhost:8080/Practice/service/goods/search?name= method = GET -- search goods by name