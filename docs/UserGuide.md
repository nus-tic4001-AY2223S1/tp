# User Guide

## Introduction

**Librarian** is a cross-platform CLI application tool for managing book borrowing related activities. 

The app is optimized, i.e. shortcut keys are provided, to support efficient typing experience of end-users.

Librarian allows the users to: <code>list</code> <code>search</code> <code>borrow</code> <code>return</code> <code>reserve</code>

## Quick Start

### Step 1
Ensure that you have Java 11 or above installed.
### Step 2
Download the latest version of Librarian app, `librarian.jar` and the library.txt, [here](https://github.com/AY2223S1-TIC4001-F18-1/tp/releases).
### Step 3
Copy the file to the folder you want to use as the working folder for your Librarian.
### Step 4
Open a terminal and navigate to the working folder where the Librarian app is copied.
### Step 5
To run the application, type `java -jar librarian.jar` and hit the `enter` key.
### Step 6
To see what commands are available and their use, you may either type `help/` or `h/`, then hit the `enter` key, or see the Features section below.

## Features

Librarian commands are executed by typing the command in the terminal, then hitting the `enter` key. 

Librarian commands are not case-sensitive. That is, `search/title/Refactoring` can also be typed as `SEARCH /TITLE /REFACTORING` or as `SEArch    /      tiTLE     /     refacTORing`.
<br />
<br />

#### RUNNING THE PROGRAM

Ensure that you have done the steps described above under the "Quick Start" section.

syntax: `java -jar librarian.jar`
<br />
<br />

#### TERMINATING THE PROGRAM

syntax: `exit/`
<br />
<br />

#### CHECKING THE COMMANDS

syntax: `help/`
<br />
<br />

#### CHECKING THE LIBRARY

syntax: `list/library`
<br />
<br />

#### CHECKING YOUR ACCOUNT

syntax: `list/user`
<br />
<br />

#### BORROWING A BOOK

syntax: `borrow/<book_title>`

example: `borrow/clean code`
<br />
<br />

#### RETURNING A BOOK

syntax: `return/<book_title>`

example: `return/clean code`
<br />
<br />

#### RESERVING A BOOK

syntax: `reserve/<book_title>`

example: `reserve/clean code`
<br />
<br />

#### CANCELING BOOK FOR RESERVATION 

syntax: `cancel/<book_title>`

example: `cancel/clean code`
<br />
<br />

#### SEARCHING BOOK(S) BY TITLE

syntax: `search/title/<keyword(s)>`

example: `search/title/work` `search/title/Structures, CODE`
<br />
<br />

#### SEARCHING BOOK(S) BY AUTHOR

syntax: `search/author/<keyword(s)>`

example: `search/author/reddy` `search/author/Martin, robert`
<br />
<br />

#### SEARCHING BOOK(S) BY CATEGORY

syntax: `search/category/<keyword(s)>`

example: `search/category/programming` `search/category/mechanical, coding`

## FAQ

**Q:** Can I run Librarian in Mac or Linux operating system? <br />
**A:** Librarian is a cross-platform CLI application tool. So, the app will run regardless of the OS that you are using.
<br />
<br />
**Q:** Will the commands described above work in Mac or Linux operating systems? <br />
**A:** Yes, the same syntax are used even for Mac or Linux operating systems.

## Command Summary

| Action             | Command                                                    | Shortcut                                       |
|--------------------|------------------------------------------------------------|------------------------------------------------|
| Run                | `java -jar librarian.jar`                                  | -                                              |
| Exit               | `exit/`                                                    | `e/`                                           |
| Help               | `help/`                                                    | `h/`                                           |
| List Library       | `list/library`                                             | `l/l`                                          |
| List Account       | `list/user`                                                | `l/u`                                          |
| Borrow             | `borrow/<book_title>`                                      | `b/<book_title>`                               |
| Return             | `return/<book_title>`                                      | `r/<book_title>`                               |
| Reserve            | `reserve/<book_title>`                                     | `rb/<book_title>`                              |
| Cancel             | `cancel/<book_title>`                                      | `cb/<book_title>`                              |
| Search by Title    | `search/title/<keyword_or_keywords_separated_by_comma>`    | `s/t/<keyword_or_keywords_separated_by_comma>` |
| Search by Author   | `search/author/<keyword_or_keywords_separated_by_comma>`   | `s/a/<keyword_or_keywords_separated_by_comma>` |
| Search by Category | `search/category/<keyword_or_keywords_separated_by_comma>` | `s/c/<keyword_or_keywords_separated_by_comma>` |
