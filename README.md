# University Event Management

## Frameworks
* Java 8 SE
* JDK 21
* Spring web starter 3.1.4
* JPA
* Spring Validation
* Lombok
* H2 Database
* Swagger UI

## Entity Definitions

### Student

---

Integer studentId - Primary Key (manually generated)

String firstName - First letter uppercase

String lastName - Not blank

Integer age - between 18 and 25

Department department - from Department Enum

### Event

---

Integer eventId - Primary Key (manually generated)

String eventName - not blank

LocalDate date - format : dd-MM-yyyy

LocalTime startTime - format : HH:mm

LocalTime endTime - format : HH:mm

___

## Data Flow

### Student

---

#### Controller

localhost:8080/student

POST mapping :

/ - add one student through request body

GET mapping :

/ - returns a list of all students in the database

/{id} - accepts a studentId and returns that Student

PUT mapping :

/{id}/department - accepts studentId through Path variable and Department through Request params

DELETE mapping :

/{id} - accepts a studentId and deletes its record from the Database

#### Service

String addStudent(Student student) - adds entry to database and returns its values

List<Student> getAllStudents() - returns a list of all entries in Students

Student getStudent(Integer id) - returns Student with specified id

String updateStudentDepartment(Department department, Integer id) 'transacional' - updates department by student id 

String deleteStudent(Integer id) - deletes student with specified id from the database

#### Repository

JpaRepository<Student, Integer>

void updateDepartmentByStudentId(Department department, Integer studentId) - Custom update query

---

### Event

---

#### Controller

localhost:8080/events

POST mapping :

/ - add one event through request body

GET mapping :

/{date} - accepts a date and returns a list of all events at that date

PUT mapping :

/ - accepts Event through Request body, updates event with that id

DELETE mapping :

/{id} - accepts a eventId and deletes its record from the Database

#### Service

String addEvent(Event event) - Adds entry to database

ArrayList<Event> getEventsByDate(LocalDate date) - returns list of events at specified date

String updateEvent(Event event) 'Transactional' - updates event by id

String deleteEvent(Integer id) - deletes event by id

#### Repository

JpaRepository<Event, Integer>

void updateEventNameAndLocationOfEventAndDateAndStartTimeAndEndTimeByEventId(String eventName,
String locationOfEvent,
LocalDate date,
LocalTime startTime,
LocalTime endTime,
Integer eventId)

List<Event> findByDateOrderByStartTimeAsc(LocalDate date)

---

### Database

H2 Database - does not persist after shutdown

Tables - Employee, Event












