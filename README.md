# ajax-promises
ClojureScript + HTTP + Promises

[![Clojars Project](https://img.shields.io/clojars/v/firthh/ajax-promises.svg)](https://clojars.org/firthh/ajax-promises)

## Why?

We have two other libraries for HTTP requests on cljs, why do we need another one?

Neither of the existing libraries support promises. One uses callbacks and the other `core.async`. 

Personally I find promises simpler and fit the model of functional programming better.
Out of the box the other two libraries will do far more for you, they'll set content types, accept types and parse the responses for you. Here you'll get none of that. This library aims to do one thing and one thing well - HTTP requests, nothing more.

## Using this library
The request object passed to this library should take the form of the Ring request map. Requests will immediately return a promise that will eventually be resolved to contain a Ring response map. The implementation of promises used comes from [Promesa](https://funcool.github.io/promesa/latest/). Non-sucessful HTTP requests will be rejected but the value contained in the promise will still be a Ring response map. Success is defined by the `isSuccess()` method on the [XhrIo response](https://developers.google.com/closure/library/docs/xhrio)

### Examples
TODO

## TODO
- [ ] TESTS!
  - How should this be tested? I'm leaning towards integration tests. Run a small server in a docker container
- Support all HTTP verbs
  - [x] GET (manually tested)
  - [x] POST (manually tested)
  - [x] PUT (not tested)
  - [x] HEAD
  - [x] OPTIONS
  - [ ] DELETE
  - [ ] PATCH
- [ ] Better support for authentication headers
- [ ] Documentation
## Running

### Testing
```sh
# with nix to add nodejs otherwise we'll assume you've installed it yourself
nix-shell
# Install test dependencies
npm install
# Run the tests
boot test-all
```

### REPL
TODO
