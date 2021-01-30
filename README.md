# Introduction
Movie Manager allows movie connoisseurs to keep track of movies they watched and stay up to date on what they will watch next. 

* Search for movies
* Add a movie to list
* View movie list in digestible fashion
* Add specific details about movies such as genre. 
* Modify and delete entries as required.
* Mark movie as favorite for easy access
* Add scores to your watched movies and share it with your friends!
* And much more. 

Users can interact with Movie Manager using a set of RESTful service endpoints or a simple but organized UI.

# Storyboard - NOT DONE
![MovieUIImg]()
[Link to full mock up]()



# Functional Requirements

### As a movie watcher, I want a way to store my movies in an organized way, so that I can decide what I want to watch.

> **Given:** Movie title is Tenet<br />
> **Given:** Director name is Christopher Nolan<br />
> **Given:** Genre is action-thriller<br />
> **When:** The user/service selects add a movie and provides the given details<br />
> **Then:** Tenet will be saved as a movie in the user's list with information about the director and the genre of the movie.

> **Given:** Movie title is not avaliable<br />
> **Given:** Director name is Christopher Nolan<br />
> **Given:** Genre is action-thriller<br />
> **When:** The user/service selects add a movie and provides the given details<br />
> **Then:** The entry will not be saved and throw an error saying at least the movie title must be included.

> **Given:** Movie name is Tenet<br />
> **Given:** Director name is not avaliable<br />
> **Given:** Genre is not avaliable<br />
> **When:** The user/service selects add a movie and provides the given details<br />
> **Then:** Tenet will be saved as a movie in the user's list with no information about the director and the genre of the movie.

> **Given:** Movie title is not avaliable<br />
> **Given:** Director name is not avaliable<br />
> **Given:** Genre is not avaliable<br />
> **When:** The user/service selects add a movie and provides the given details<br />
> **Then:** The entry will not be saved and throw an error saying at least the movie title must be included.


### As a movie watcher, I want to modify or delete movies, so that I can change or remove my movies from the list.

> **Given:** User has a saved movie entry called Tenet with no information for director or genre<br />
> **When:** The user/service navigates to Tenet<br />
> **When:** The user/service edits Tenet<br />
> **Given:** Director name is Christopher Nolan<br />
> **Given:** Genre is action-thriller<br />
> **When:** The user/service saves their modications for Tenet<br />
> **Then:** The movie entry Tenet will be updated to now contain information about director and genre.

> **Given:** User has a saved movie entry called Tenet with information for director and genre<br />
> **When:** The user/service navigates to Tenet<br />
> **When:** The user/service edits Tenet<br />
> **When:** The user/service selects delete option in edit menu<br />
> **Then:** The movie entry Tenet will be removed from the movie list.


### As a movie watcher, I want to search for movies from a database, so that I can explore and find new movies to watch.

> **Given:** The title of a movie called Tenet<br />
> **When:** The user/service searches for Tenet<br />
> **Then:** Search database for Tenet<br /> 
> **Given:** JSON data from database<br />
> **Then:** Display the movie to the user on the app with the option of saving it

> **Given:** A title for a movie is not provided<br />
> **When:** The user/service searches by pressing enter or search on an empty text box<br />
> **Then:** Show an error stating that a title must be entered for the search to function


# Class Diagram
![MovieAppClassDiagram](https://github.com/serhanmd/Movie-Manager/blob/main/MovieClassDiagramImg.png)



# JSON Schema
### Movie Object
```JSON
{
  "Title": "",
  "Year": "",
  "Rated": "",
  "Released": "",
  "Runtime": "",
  "Director": "",
  "imdbRating": "",
  "userRating": "",
  "Genre": [
    "",
    "",
    ""
  ]
}
```

# Scrum Roles
**UI Specialist:** Seth White

**Business Logic/Persistence:** Connor Keith

**DevOps/Product Owner/Scrum Master/Github Admin:** Mohamed Serhan


# Milestones
They are found in the projects tab on GitHub and represent the project backlog.


# Weekly Standup

[Tuesday | 4:00PM](https://teams.microsoft.com/l/meetup-join/19%3ameeting_MTVjNTAyYmItNTIzMy00NWRkLTliYjQtNzU0OGNmYzVjOTE4%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%2268fd18b3-3b5f-45d9-aad4-9af00e39f78e%22%7d)
