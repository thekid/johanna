Johanna
=======

Johanna is a server implementation of the Hannah session server `hannahd` and
is written in Java.

## Usage

```sh
$ java org.oneandone.idev.johanna.JohannahServer [--port=2001] \
  [--backend=memory|redis] \
  [--host=127.0.0.1] \
  [--identifier=md5|uuid]
```

or - if you run the uber-jar:

```sh
$ java -jar /path/to/johanna-jar.jar  [--port=2001] \
  [--backend=memory|redis] \
  [--host=127.0.0.1] \
  [--identifier=md5|uuid]
```

* port: defaults to 2001.
* backend: supports `memory` (keep sessions in RAM), `redis` (use Redis key-value
  store as session storage).
* host: host of Redis store
* identifier: use MD5 or UUID as session identifier implementation 

## Implemented protocol commands

The following commands are implemented:

* `session_create <ttl>`
* `session_terminate <id>`
* `session_isvalid <id>`
* `session_settimeout <id> <ttl>`
* `session_keys <id>`
* `var_write <id> <stor> <name> <value>`
* `var_read <id> <stor> <name>`
* `var_delete <id> <stor> <name>`
* `bye` and `exit`

Parameters explained:

* `<id>` is a session unique identifier generated by the server
* `<ttl>` is a timeout in seconds
* `<stor>` is the type of storage, it can be `tmp`, `perm` or `sec`. Currently
  only `tmp` is implemented
* `<name>` is a whitespace delimited key name
* `<value>` is a whitespace delimited value` - a common approach to store arbitrary
  data there is to first urlencode the data.

## Prerequisites
* The build requires Java 7
* A non-global dependency jcli is contained in the `contrib/` folder

## Protocol
### Basics
The Hannah-protocol is a line-based, human readable & writable protocol. Clients
issue a command, the server replies. There are no server-initiated actions on
the wire.

### Requests
