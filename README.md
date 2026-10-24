# CRM Realm Technical Assessment
## Junior Software Engineer Intern

### Project Overview

This project is my solution to the CRM Realm Junior Software Engineer Intern technical assessment. It includes a Java console application for managing leads, three JavaScript problem-solving exercises with test cases, and SQL queries for working with lead priorities.

I kept the implementation simple and focused on meeting the requirements, writing readable code, and handling common input errors.

### Project Structure

```text
crm-realm-assessment/
├── java/
│   ├── Lead.java
│   └── LeadTracker.java
├── javascript/
│   ├── solutions.js
│   └── solutions.test.js
├── sql/
│   └── queries.sql
└── README.md
```

### Requirements

To run and work with this project, you will need:

- Java JDK
- Node.js
- MySQL 8 (for the SQL queries; a database connection is not required)

### Part A: Java Lead Tracker

The Java application lets users add leads, view the leads they have added, and exit through a simple console menu.

Each lead contains a name, email address, and score between 0 and 100. The application checks the input and displays an error message when the name or email is empty, the email format is invalid, the score is not an integer, or the score is outside the allowed range.

Each lead's priority is calculated from its score using the `getPriority()` method in `Lead.java`:

- **HOT:** 80–100
- **WARM:** 50–79
- **COLD:** 0–49

The priority is calculated when needed rather than stored as a separate value. This keeps it consistent with the lead's score.

Leads are stored in an `ArrayList`, so they remain available while the application is running. They are cleared when the program exits.

#### How to run

Open a terminal in the project root directory and run:

```bash
javac java/Lead.java java/LeadTracker.java
java -cp java LeadTracker
```

### Part B: JavaScript Problem-Solving

The JavaScript solutions are in `javascript/solutions.js`, and their test cases are in `javascript/solutions.test.js`. I used Node.js's built-in `assert` module, so no additional packages are needed.

#### 1. First non-repeating character

The `firstNonRepeatingChar()` function finds the first character that appears only once in a string. I used a `Map` to count the characters, treating uppercase and lowercase letters as the same. I then check the original string to return the first unique character in its original form.

The function also handles spaces and punctuation, and returns `null` if no unique character exists.

#### 2. Two Sum

The `findTwoSum()` function finds two different elements whose values add up to a given target. I used a `Map` to store previously visited numbers and their indices. For each number, the function checks whether the number needed to reach the target has already been seen.

This approach avoids checking every possible pair and has an expected time complexity of O(n). The function returns the two indices if a pair is found, or `null` otherwise.

#### 3. Count leads by status

The `countLeadsByStatus()` function counts how many leads belong to each status. I used an object to keep track of the counts, allowing the function to handle new status values without needing to change the code.

The function returns an empty object when given an empty array and does not modify the original array.

If certain statuses need to appear even when no leads have them, I would initialize those statuses with a count of `0` before processing the array. The function could then increment the relevant count as it goes through each lead.

#### How to run the JavaScript tests

From the project root directory, run:

```bash
node javascript/solutions.test.js
```

If all assertions pass, the test file prints:

```text
All JavaScript tests passed!
```

### Part C: SQL Queries

The SQL queries are available in `sql/queries.sql`. I used MySQL 8 syntax and assumed that the `leads` table contains `id`, `name`, `email`, and `score` columns.

The first query retrieves all leads with a score of 80 or higher, which qualifies them as HOT leads.

The second query groups leads into HOT, WARM, and COLD priorities and counts how many leads belong to each group. It can also include a priority group with a count of zero.

No database connection is needed to run the Java application.

### Part D: Testing

I included JavaScript test cases for normal inputs and several edge cases, such as:

- Empty strings and strings with repeated characters.
- Uppercase and lowercase letters, spaces, and punctuation.
- Two Sum inputs with duplicate numbers, zero values, and no valid pair.
- Empty lead arrays and leads with different statuses.
- Checking that the original lead array remains unchanged.

For the Java application, I considered validation cases such as empty names and emails, invalid email formats, non-integer scores, and scores outside the allowed range. The priority boundaries are also important to check: `0`, `49`, `50`, `79`, `80`, and `100`.

### Assumptions and Design Decisions

I used an in-memory collection for the Java application because the assessment does not require a database or permanent storage. This keeps the application straightforward and easy to run.

I also chose MySQL 8 for the SQL examples. For the first JavaScript problem, I treated uppercase and lowercase characters as equivalent when counting occurrences while preserving the original character in the result.

### What I Would Improve

If I had more time, I would add automated tests for the Java application so that input validation and priority calculations could be checked more easily. I would also consider adding database storage to preserve leads between runs and improving the application's input handling further.

