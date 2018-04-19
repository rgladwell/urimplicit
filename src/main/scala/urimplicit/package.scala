// Copyright 2015, 2018 Ricardo Gladwell.
// Licensed under the GNU Lesser General Public License.
// See the README.md file for more information.

import scala.language.implicitConversions
import scala.util.Try

package object urimplicit {

  type URI = java.net.URI

  implicit def javaUriToUriOps(uri: URI) = new URIOps(uri)

  object URI {
    def apply(uri: String) = new URI(uri)

    def unapply(uri: String): Option[(String, String)] =
      for {
        javaUri <- Try{ new URI(uri) }.toOption
        host <- Option(javaUri.getHost)
      } yield {
        (uri, javaUri.getHost)
      }

    def unapply(uri: URI): Option[(String, String)] = {
      Some((uri.toString(), uri.getHost))
    }
  }

}
