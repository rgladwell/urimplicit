// Copyright 2015 Ricardo Gladwell.
// Licensed under the GNU Lesser General Public License.
// See the README.md file for more information.

import scala.language.implicitConversions

package object urimplicit {

  type URI = java.net.URI

  implicit def javaUriToUri(uri: URI) = Uri(uri)

  object URI {
    def apply(uri: String) = new URI(uri)
  }

}
