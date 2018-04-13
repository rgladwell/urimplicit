// Copyright 2015 Ricardo Gladwell.
// Licensed under the GNU Lesser General Public License.
// See the README.md file for more information.

package urimplicit

import scala.util.Try

case class Uri(uri: URI) {

  def + (uri2: URI): URI = uri.resolve(uri2)
  def + (uri2: String): URI = this + new URI(uri2)

}

object Uri {

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
