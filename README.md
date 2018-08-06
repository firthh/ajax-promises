# ajax-promises
ClojureScript + HTTP + Promises
## Why?

We have two other libraries for HTTP requests on cljs, why do we need another one?

Neither of the existing libraries support promises. One uses callbacks and the other `core.async`. 

Personally I find promises simpler and fit the model of functional programming better.
Out of the box the other two libraries will do far more for you, they'll set content types, accept types and parse the responses for you. Here you'll get none of that. This library aims to do one thing and one thing well - HTTP requests, nothing more.

## Using this library
The request object passed to this library should take the form of the Ring request map. Requests will immediately return a promise that will eventually be resolved to contain a Ring response map. The implementation of promises used comes from [Promesa](https://funcool.github.io/promesa/latest/). Non-sucessful HTTP requests will be rejected but the value contained in the promise will still be a Ring response map. Success is defined by the `isSuccess()` method on the [XhrIo response](https://developers.google.com/closure/library/docs/xhrio)

TODO

## TODO
- [ ] TESTS!
  - How should this be tested? I'm leaning towards integration tests. Run a small server in a docker container
- Support all HTTP verbs
  - [x] GET (manually tested)
  - [x] POST (manually tested)
  - [x] PUT (not tested)
  - [ ] OPTIONS
  - [ ] DELETE
  - [ ] PATCH
- [ ] Better support for authentication headers

## Getting started

```sh
# Start a repl
clj --main cljs.main --compile ajax-promises.main --repl

# Start a repl with node.js
# Don't use this as node doesn't have XMLHttpRequest
clj --main cljs.main --compile ajax-promises.main --repl --repl-env node
```
