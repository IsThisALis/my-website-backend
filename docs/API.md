# EXAMPLE:
**ACTION_NAME**:
    *HTTP_METHOD*
    *ENDPOINT*
    *REQUEST_BODY_FORMAT* (IF EXISTS) 
    *AVAILABLE_RESPONSES*:
        1. RESPONSE1
        2. RESPONSE2

# API:

## About

**GET_ABOUT**:
- *HTTP_METHOD*: `GET`
- *ENDPOINT*: `/api/about`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Returns About

**CREATE_ABOUT**:
- *HTTP_METHOD*: `POST`
- *ENDPOINT*: `/api/about`
- *REQUEST_BODY_FORMAT*: `About`
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully created
    2. `400 Bad Request` - Invalid request body

**EDIT_ABOUT**:
- *HTTP_METHOD*: `PATCH`
- *ENDPOINT*: `/api/about`
- *REQUEST_BODY_FORMAT*: `About`
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully updated
    2. `400 Bad Request` - Invalid request body

**DELETE_ABOUT**:
- *HTTP_METHOD*: `DELETE`
- *ENDPOINT*: `/api/about`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully deleted


## Posts

**GET_POST_COMMENTS**:
- *HTTP_METHOD*: `GET`
- *ENDPOINT*: `/api/posts/{id}/comments`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Returns List<Comment>
    2. `404 Not Found` - Post not found

**GET_POSTS**:
- *HTTP_METHOD*: `GET`
- *ENDPOINT*: `/api/posts`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Returns List<Post>

**DELETE_POST**:
- *HTTP_METHOD*: `DELETE`
- *ENDPOINT*: `/api/posts/{id}/delete`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully deleted
    2. `404 Not Found` - Post not found

**EDIT_POST**:
- *HTTP_METHOD*: `PATCH`
- *ENDPOINT*: `/api/posts/{id}/edit`
- *REQUEST_BODY_FORMAT*: `Post`
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully updated
    2. `400 Bad Request` - Invalid request body
    3. `404 Not Found` - Post not found

**ADD_POST**:
- *HTTP_METHOD*: `POST`
- *ENDPOINT*: `/api/posts`
- *REQUEST_BODY_FORMAT*: `Post`
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully created
    2. `400 Bad Request` - Invalid request body


## Projects

**GET_PROJECT_BY_ID**:
- *HTTP_METHOD*: `GET`
- *ENDPOINT*: `/api/projects/{id}`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Returns Project
    2. `404 Not Found` - Project not found

**GET_PROJECTS**:
- *HTTP_METHOD*: `GET`
- *ENDPOINT*: `/api/projects`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Returns List<Project>

**EDIT_PROJECT**:
- *HTTP_METHOD*: `PATCH`
- *ENDPOINT*: `/api/projects/{id}`
- *REQUEST_BODY_FORMAT*: `Project`
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully updated
    2. `400 Bad Request` - Invalid request body
    3. `404 Not Found` - Project not found

**DELETE_ALL_PROJECTS**:
- *HTTP_METHOD*: `DELETE`
- *ENDPOINT*: `/api/projects`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - All projects successfully deleted

**DELETE_PROJECT_BY_ID**:
- *HTTP_METHOD*: `DELETE`
- *ENDPOINT*: `/api/projects/{id}`
- *REQUEST_BODY_FORMAT*: None
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully deleted
    2. `404 Not Found` - Project not found

**ADD_PROJECT**:
- *HTTP_METHOD*: `POST`
- *ENDPOINT*: `/api/projects`
- *REQUEST_BODY_FORMAT*: `Project`
- *AVAILABLE_RESPONSES*:
    1. `200 OK` - Successfully created
    2. `400 Bad Request` - Invalid request body


# Data structures:

## About
- title: String
- content: String
- techStack: String

## Comment
- author: String
- body: String
- createdAt: Instant
- post: Post

## Post
- title: String
- content: String
- image: String
- date: Instant

## Project
- techStack: String
- name: String
- description: String
- url: String