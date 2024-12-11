aggenda:
what is redis?
redis advantage?
how apis work without redis?
how apis work with redis(as cache)?
implementing redis cache for apis
implementing different time to live for each cahce
redis:ia an opensource, advanced key value store space and an apt solution for building high performance, scalable web applications
advantage:
*redis holds the database entirely in memory(ram), using the disk only for persistence. this makes the fast to access
*redis has a rich set of data types supported compared to the key value data stores
*redis can replicate data to any number of slaves
*all operations in redis is atomic(any 2 clients can hit or concurrently access the same). redis server will receive the updated value
*can be used for caching , counting no. of hits ina web application and for many purpose


            redis cache(in memory database)
                    |2
                    |
        1           |4
user -------application server-----------database
         6             5          3