Johanna
=======

Johanna is a server implementation of the Hannah session server `hannahd` and
is written in Java.

## Usage

```sh
$ java org.oneandone.idev.johanna.JohannahServer [<port>]
```

<port> defaults to 2001.

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
