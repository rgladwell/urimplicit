// Copyright 2015 Ricardo Gladwell.
// Licensed under the GNU Lesser General Public License.
// See the README.md file for more information.

package urimplicit

import java.net.URISyntaxException

case class Uri(uri: URI) {

  def + (uri2: URI): URI = uri.resolve(uri2)
  def + (uri2: String): URI = this + new URI(uri2)

}

object Uri {

  def unapply(uri: String): Option[(String, String)] = {
    try {
      val javaUri = new URI(uri)

      javaUri.getHost match {
        case host: String => Some((uri, host))
        case _            => None
      }
      
    } catch {
      case e : URISyntaxException => None
    }
  }

  def unapply(uri: URI): Option[(String, String)] = {
    Some((uri.toString(), uri.getHost))
  }

}
