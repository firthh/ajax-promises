# ajax-promises
A ClojureScript HTTP library that uses promises!

[![Clojars Project](https://img.shields.io/clojars/v/firthh/ajax-promises.svg)](https://clojars.org/firthh/ajax-promises)

## Why should you use this library?

You might not want to use `core.async` or callbacks to handle responses from HTTP requests. Promises are functional concept that are embraced in the Javascript community. Or maybe you want a library that aims to do one thing and one thing well - HTTP requests. 

## When to not use this library?

If you want a HTTP library that does everything, this one isn't for you. 

This library won't deal with encoding of the request body into your required format, it won't deal decoding the response body, it won't set content-type headers, it won't set accept headers. That's all up to you.

## Using this library
The request object passed to this library should take the form of the Ring request map. Requests will immediately return a promise that will eventually be resolved to contain a Ring response map. The implementation of promises used comes from [Promesa](https://funcool.github.io/promesa/latest/). Non-sucessful HTTP requests will be rejected but the value contained in the promise will still be a Ring response map. Success is defined by the `isSuccess()` method on the [XhrIo response](https://developers.google.com/closure/library/docs/xhrio)

### Examples
TODO

## Running

### Testing
```sh
# with nix to add nodejs otherwise we'll assume you've installed it yourself
nix-shell
# Install test dependencies
npm install
# Run the test server in the background
docker-compose up -d
# Run the tests
boot test-all
```

### REPL
TODO



## TODO
- [ ] More tests!
  - Tests are all integration tests
  - [ ] Test the shape of the response and things other than status
  - [ ] Test unhappy cases - 500s, 400s, 404s, timeouts, connection errors, etc.
- Support all HTTP verbs
  - [x] GET
  - [x] POST
  - [x] PUT
  - [x] HEAD
  - [x] OPTIONS
  - [ ] DELETE
  - [ ] PATCH
- [ ] Better support for authentication headers?
- [ ] Documentation
