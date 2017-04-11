# ra

Possible bug in Ring Async Jetty Adapter?

## Installation

git clone this repo.

## Usage

Run the project directly:

    $ boot run

Then hit the app in a browser:

    http://localhost:8080/

It should say `Yes please!`. Now append `?fail=msg` to the URL to cause it to raise an exception.

You'll get an Error 500 (as expected).

All future requests fail -- they hang and then thread death exception is reported at the console.

## License

Copyright © 2017 Sean Corfield

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
