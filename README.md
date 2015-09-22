Urimplicit [![Build Status](https://travis-ci.org/rgladwell/urimplicit.svg)](https://travis-ci.org/rgladwell/urimplicit)
==========

**Urimplicit** is a really simple Scala library that provides useful, implicit augmentations for the Java
[URI class](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html).

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
     |   address match {
     |     case Uri(_)  => true
     |     case _       => false
     |   }
isAddress: (address: String)Boolean

scala> isAddress("http://localhost:8080")
res0: Boolean = true

scala> isAddress("unknown")
res1: Boolean = false
```

You can also use the pattern matcher to extract host information from a URI:

```scala
scala> def host(address: URI): Option[String] =
     |   address match {
     |     case Uri(host)  => Some(host)
     |     case _          => None
     |   }
isAddress: (address: String)Option[String]

scala> host(URI("http://localhost:8080"))
res2: Option[String] = Some(localhost)
```