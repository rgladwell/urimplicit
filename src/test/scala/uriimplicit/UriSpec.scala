package urimplicit

import org.specs2.mutable.Specification

object UriSpec extends Specification {

  "A URI" should {

    "match an address" in {
      "http://example.org" must beLike { case Uri(host) => host must_== "example.org" }
    }

    "not match a host" in {
      Uri.unapply("example.org") must beNone
    }

    "not match an IP address" in {
      Uri.unapply("192.173.55.87") must beNone
    }

    "match an URI" in {
      new URI("http://example.org") must beLike { case Uri(host) => host must_== "example.org" }
    }

    "correctly concatenate with a relative URI" in {
      new URI("http://example.org") + new URI("/index.html") must_== new URI("http://example.org/index.html")
    }

    "correctly concatenate with a relative URI string" in {
      new URI("http://example.org") + "/index.html" must_== new URI("http://example.org/index.html")
    }

    "provide companion object succinct constructor for URI" in {
      URI("http://example.org") must_== new URI("http://example.org")
    }
  }

}
