# UBS Test Sudoku Validator from csv file

[task details](SudokuValidator.pdf) 

packaging must be done with maven

```
mvn package
```

in `target` directory there will be `validate.sh(bat)` files.
To run the validation run in the terminal

```
./validate.sh {file path}
``` 

Example

```
./validate.sh /Users/administrator/IdeaProjects/UBS-Test/src/test/resources/csv/valid_sudoku_board.csv
```

it will return if the csv file content is valid Sudoku board or not with text message.

In case of error it will print the error as Java exception

## Generate test report

run these commands
```
mvn site
mvn surefire-report:report
```