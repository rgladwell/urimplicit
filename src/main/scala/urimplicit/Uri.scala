package urimplicit

import java.net.URISyntaxException

case class Uri(uri: URI) {

  def + (uri2: URI): URI = uri.resolve(uri2)
  def + (uri2: String): URI = this + new URI(uri2)

}

object Uri {

  def unapply(uri: String) = {
    try {
      Option(new URI(uri).getHost)
    } catch {
      case e : URISyntaxException => None
    }
  }

  def unapply(uri: URI) = {
    Option(uri.getHost)
  }

}
