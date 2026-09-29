# API Documentation

## About

**GET_ABOUT**:
    GET /api/about
    AVAILABLE_RESPONSES:
        1. 200 OK - Returns AboutDTO

**CREATE_ABOUT**:
    POST /api/about
    REQUEST_BODY: AboutDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully created
        2. 400 Bad Request - Invalid request body

**EDIT_ABOUT**:
    PATCH /api/about
    REQUEST_BODY: AboutDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully updated
        2. 400 Bad Request - Invalid request body

**DELETE_ABOUT**:
    DELETE /api/about
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully deleted

## Posts

**GET_POSTS**:
    GET /api/posts
    AVAILABLE_RESPONSES:
        1. 200 OK - Returns List<PostDTO>

**ADD_POST**:
    POST /api/posts
    REQUEST_BODY: PostDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully created
        2. 400 Bad Request - Invalid request body

**EDIT_POST**:
    PATCH /api/posts/{postId}
    REQUEST_BODY: PostDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully updated
        2. 400 Bad Request - Invalid request body
        3. 404 Not Found - Post not found

**DELETE_POST**:
    DELETE /api/posts/{postId}/delete
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully deleted
        2. 404 Not Found - Post not found

**GET_POST_COMMENTS**:
    GET /api/posts/{postId}/comments
    AVAILABLE_RESPONSES:
        1. 200 OK - Returns List<CommentDTO>
        2. 404 Not Found - Post not found

**ADD_COMMENT**:
    POST /api/posts/{postId}/comments
    REQUEST_BODY: CommentDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully created
        2. 400 Bad Request - Invalid request body

**EDIT_COMMENT**:
    PATCH /api/posts/{postId}/comments/{commentId}
    REQUEST_BODY: CommentDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully updated
        2. 400 Bad Request - Invalid request body
        3. 404 Not Found - Comment not found

**DELETE_COMMENT**:
    DELETE /api/posts/{postId}/comments/{commentId}
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully deleted
        2. 404 Not Found - Comment not found

## Projects

**GET_PROJECT_BY_ID**:
    GET /api/projects/{id}
    AVAILABLE_RESPONSES:
        1. 200 OK - Returns ProjectDTO
        2. 404 Not Found - Project not found

**GET_PROJECTS**:
    GET /api/projects
    AVAILABLE_RESPONSES:
        1. 200 OK - Returns List<ProjectDTO>

**ADD_PROJECT**:
    POST /api/projects
    REQUEST_BODY: ProjectDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully created
        2. 400 Bad Request - Invalid request body

**EDIT_PROJECT**:
    PATCH /api/projects/{id}
    REQUEST_BODY: ProjectDTO
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully updated
        2. 400 Bad Request - Invalid request body
        3. 404 Not Found - Project not found

**DELETE_PROJECT_BY_ID**:
    DELETE /api/projects/{id}
    AVAILABLE_RESPONSES:
        1. 200 OK - Successfully deleted
        2. 404 Not Found - Project not found

**DELETE_ALL_PROJECTS**:
    DELETE /api/projects
    AVAILABLE_RESPONSES:
        1. 200 OK - All projects successfully deleted

## Health

**HEALTH_CHECK**:
    GET /api/health
    AVAILABLE_RESPONSES:
        1. 200 OK - Returns {"status": "UP", "timestamp": "..."}

# Data Structures

## PostDTO
- id: long
- title: String
- content: String
- image: String
- date: Instant

## CommentDTO
- author: String
- body: String
- createdAt: Instant

## AboutDTO
- title: String
- content: String
- techStack: String

## ProjectDTO
- name: String
- description: String
- techStack: String
- url: String