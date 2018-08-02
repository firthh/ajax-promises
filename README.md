# ajax-promises

## Why?

We have two other libraries for HTTP requests on cljs, why do we need another one?

Neither of the existing libraries support promises. One uses callbacks and the other `core.async`. 

Personally I find promises simpler and fit the model of functional programming better.

## Getting started

```sh
# Start a repl
clj --main cljs.main --compile ajax-promises.main --repl

# Start a repl with node.js
# Don't use this as node doesn't have XMLHttpRequest
clj --main cljs.main --compile ajax-promises.main --repl --repl-env node
```
