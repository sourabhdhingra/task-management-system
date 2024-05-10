# Task Management System

A simple hands-on project to showcase how scala can be used to build a simple CLI. The CLI intended here is to manage tasks where a user
can add, update, delete and view his tasks. 
The task would have below attributes
- description: an elaborate title of the task
- due date: date by which task is to be completed
- status: complete/incomplete

Coding approach followed:

1. Scala inbuilt libraries are preferred
    - Scalatest used for unit testing
2. TDD driven approach 
   - Failing Unit Test cases were written
   - Code implemented to make unit test cases pass
3. Singleton pattern used wherever needed
4. CLI class has `main` entry point as supposed to be