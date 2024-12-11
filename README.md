MVC model:
1.presentation layer:(controller)
the layer which is accessible to the user like the http request
2.service layer: layer in which the business logic lies.
3.Persistence layer:DB the actual database and the logic to retrieve the data will be written under this layer
->  by following this MVC architecture we can improve the scalability, maintenance and testability

->first of all we have a controller which contains all the requests and then we have a service class which has the implementation of the functions which is required to perform all the functions to complete the http request
->the DTOs have the plain old java object which is converted to a JSon which is used while interacting between the presentation layer and the service layer
->then we have the Entities which is used in interaction between the service layer and the persistence layer , the entities are utilized by the repositories which extends the JPARepository which contains the menthods to save, flush, get, do batch processing and everything with the database rather than having to do everything using SQL query
->the JPARepository extends the ListCrudRepository and which inturn extends the CRUD repository which is utilized in performing few of the CRUD operations
->the entities use the annotation like @NotNull, @Patern etc., to define the fields constraints
->@query annotation can be used to query the entity objects to get the result this make use of the java Persistence Query Language JPQL


presentation---------service---------persistence
                DTO             Entity
IOC: inversion of control module is used to insert the dependencies to the prpoject with autoconfiguration

libraries:
Lombok: used to create the dto becoz it contains the @Data annotation which is used to create the getters and setters for the dtos
jackson: this is the library which helps in converting the object into json while hitting a http request and json to object in taking it to the functions

annotations:
@Component: used to say the system that it has to take care of the bean injection of the class for which it is associatd the @Controller annotation with and we will not associate the bean for the same
@Data: used to make the DTO which is the object that is used between the users->presentation layer->service layer
@PathVariable: to declare the path variable
@Schema:it is a part of the @Content annotation to specify the input into the system
@Operation: to define the operation of an endpoint
@PathParam: used to give the path parameter which could be set in the params of postman. this is the optional one and it could be null as well. its usually mentioned after ? mark to decide the path after the endpoint.multiple path parameter is also allowed
@Query:annotation uses JPQL, a SQL-like query language that operates on entity objects rather than database tables.
@NoRepositoryBean annotation is used in Spring Data JPA to indicate that a repository should not be instantiated as a Spring bean. This is particularly useful when defining base repository interfaces that should not be instantiated on their own, but rather serve as parent interfaces for other repositories.
@FieldNameConstants annotation is part of the Lombok library, which is a popular tool for reducing boilerplate code in Java applications. This annotation generates a constants class containing the names of the fields in the annotated class. These constants are useful for various purposes, such as referencing field names in query criteria or avoiding hard-coded strings in your code. eg:classname.Fields.<fieldName>() this will set the field name as itself
@JsonIgnoreProperties: is an annotation of    .it is used to ignore certain properties during serialization and deserialization. it is also used to exclude certain details from json output and remove problems if certain field values are misssing


