# Demo Spring Session using JDBC & Redis

This is a very simple demo application using Spring Session with a Redis backend and a 
JDBC backend.

# Usage

The default Spring Session implementation is using JDBC via Postgres.  You need to
execute the DDL for Postgres (link below) before running the application.

If you set the active profile to `redis` (or edit the application.yml) it should
start using Redis instead.

## Postgres

Get the Postgres schema from here:
https://github.com/spring-projects/spring-session/tree/master/spring-session-jdbc/src/main/resources/org/springframework/session/jdbc/
