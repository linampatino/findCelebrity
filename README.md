find-celebrity
Find celebrities in a team Problem: Find the Celebrity Description: In a team of n people, a celebrity is known by everyone but he/she doesn't know anybody.

Assumptions:

- User has to type the connectorType (CSV, DATABASE,...). Now, is implemented just CSV
- User has to type the path of the csv file that contains a list with the team pepople, in this case.
- Csv file must have this structure: personId, name, lastname, knownPersonId, knownPersonName, knownPersonLastname
- The program doesn't validate the file structure, assumes that file has the correct format

--- File example --- In this example Manuel and Paola are celebrities, they don't know anyone and everybady knows their.

"1", "Lina", "Patino", "2", "Manuel", "Zapata" 
"1", "Lina", "Patino", "3", "Maria", "Lpoez" 
"1", "Lina", "Patino", "4", "Jose", "Jaramillo" 
"1", "Lina", "Patino", "5", "Paola", "Gomez" 
"2", "Manuel", "Zapata", , , 
"3", "Maria", "Lpoez", "1", "Lina", "Patino" 
"3", "Maria", "Lpoez", "2", "Manuel", "Zapata" 
"3", "Maria", "Lpoez", "5", "Paola", "Gomez" 
"4", "Jose", "Jaramillo", "2", "Manuel", "Zapata" 
"4", "Jose", "Jaramillo","5", "Paola", "Gomez" 
"5", "Paola", "Gomez", , ,

Test: go to this url: http://localhost:8080/swagger-ui.html
