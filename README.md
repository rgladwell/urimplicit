Urimplicit [![Build Status](https://travis-ci.org/rgladwell/urimplicit.svg)](https://travis-ci.org/rgladwell/urimplicit) [ ![Download](https://api.bintray.com/packages/rgladwell/maven/urimplicit/images/download.svg) ](https://bintray.com/rgladwell/maven/urimplicit/_latestVersion) [![Dependencies](https://app.updateimpact.com/badge/702556651743481856/urimplicit.svg?config=compile)](https://app.updateimpact.com/latest/702556651743481856/urimplicit)
==========

**Urimplicit** is a really simple Scala library that provides useful, implicit augmentations for the Java
[URI class](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html).

To install add the following line to your SBT configuration:

```
libraryDependencies += "me.gladwell" %% "urimplicit" % "0.3.0"
```

To enable simply import the library into scope:

```scala
scala> import urimplicit._
```

This gives you the ability to concatenate relative URIs together using the `+` operator:

```scala
scala> new URI("http://example.org")
res0: java.net.URI = http://example.org

scala> res0 + "/test"
res1: urimplicit.URI = http://example.org/test

scala> new URI("/main")
res2: java.net.URI = /main

scala> res1 + res2
res4: urimplicit.URI = http://example.org/main
```

It also provides a useful `URI` companion class constructor to make URI creation more succinct:

```scala
scala> URI("http://example.org")
res0: java.net.URI = http://example.org
```

This library also provides the `Uri` object which can be used in pattern matching on URI objects and strings:

```scala
scala> def isAddress(address: String): Boolean =
     address match {
     case URI(_,_)  => true
     case _         => false
     }
isAddress: (address: String)Boolean

scala> isAddress("http://localhost:8080")
res0: Boolean = true

scala> isAddress("unknown")
res1: Boolean = false
```

You can also use the pattern matcher to extract host information from a URI:

```scala
scala> def host(address: URI): Option[String] =
     address match {
     case URI(_, host)  => Some(host)
     case _             => None
}
host: (address: String)Option[String]

scala> host(URI("http://localhost:8080"))
res2: Option[String] = Some(localhost)
```

## Release

This project can be released as follows:

```sh
$ sbt
sbt:urimplicit> bintrayChangeCredentials

sbt:urimplicit> + publish
```

## License

This program is free software: you can redistribute it and/or modify#
it under the terms of the GNU Lesser General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this program.  If not, see
<http://www.gnu.org/licenses/>.

Copyright 2015-2020 [Ricardo Gladwell](http://gladwell.me).
