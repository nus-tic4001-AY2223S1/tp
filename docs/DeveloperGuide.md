# Developer Guide

## Acknowledgements

All the code base is developed internally by the DEV team and any libraries used are default libraries found within the IntelliJ IDEA IDE.

## Design & implementation

### Architecture

![](C:\Users\Roshan\Desktop\1.png)

The **Architecture Diagram** given above explains the high-level design of the program.

Given below is a quick overview of the main components and how they interact with each other.

**Main components of the architecture**

`UI`: The UI of the App. It requests for user inputs and displays corresponding outputs


`Main (Run)`: Found within UI, it takes in a user input, parses it and executes the appropriate command


`Command`: List of actions that can be performed based on defined user inputs


`Storage`: Storage of Library / Borrower

### Sequence Diagram

The *Sequence Diagram* below shows how the components interact with each other for the scenario when user has already keyed in
his username and then issues the command `list/library`

<img src="C:\Users\Roshan\Desktop\Sequence Diagram (1).jpeg"/>

### Storage Component

The **Storage Component** displays the types of storage classes within it. The UI / Parser classes load / add various information using
different components within the Storage Class.

![](C:\Users\Roshan\Desktop\Storage.png)

## User Stories

| Version | As a ... | I want to ...      | So that I can ...                            |
|---------|----------|--------------------|----------------------------------------------|
| v1.0    | Borrower | list my books      | see which books I have borrowed              |
| v2.0    | Borrower | list library books | see which books are available in the library |
| v3.0    | Borrower | borrow books       | reserve them for personal use                |
| v4.0    | Borrower | return books       | release the items from my list               |
| v5.0    | Borrower | search books       | finds books easily within the library        |

## Non-Functional Requirements

1. List of items from Library / Borrower should return in less than 3 secs
2. Ability to add up to 10 borrowers
