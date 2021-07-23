# Demo Spring Session using JDBC & Redis

This is a very simple demo web application using Spring Session with a JDBC
(via Postgres) or Redis backend.  Once running, visit http://localhost:8080.

The application leverages Spring Security, so you will be redirected to a login
page where the only valid user is "user/password".  Once logged in, you will be
presented with a link to a customized greeting.

The application updates the user's session with every invocation of the
greeting page and adds a `time_stamp` entry to the session to simulate
changes to state.

# Usage

The default Spring Session implementation is using JDBC (via Postgres).  You
will need to execute the DDL for Postgres (link below) before running the
application.

To run the application outside the IDE, just execute (for JDBC):

```shell
$ ./gradlew :bootRun 
```

Or this (for Redis):

```shell
$ ./gradlew :bootRun --args='--spring.profiles.active=redis'
```

## Notes

- The session is configured to expire in 60 seconds (this makes it easier to
  verify clean-up behavior).
- The JDBC clean-up behavior is configured to run ever 3 minutes.
- For simplicity the DataSource config is active in both profiles (i.e., it is
  harder to disable w/o excluding the jdbc dependencies).  I may research how
  to do this better in the future...
- Under load, you can sometimes observe an SQL ERROR caused by a transaction
  lock timeout:
  - https://github.com/spring-projects/spring-session/issues/838
  - https://github.com/spring-projects/spring-session/issues/1739
- Other deadlocks may exist:
  - https://github.com/spring-projects/spring-session/issues/1031
  - https://github.com/spring-projects/spring-session/issues/1550
  - Attempts to fix: https://github.com/spring-projects/spring-session/pull/1726

## Postgres DDL

Get the Postgres schema from here:
https://github.com/spring-projects/spring-session/tree/master/spring-session-jdbc/src/main/resources/org/springframework/session/jdbc/
