// Copyright 2015 Ricardo Gladwell.
// Licensed under the GNU Lesser General Public License.
// See the README.md file for more information.

package urimplicit

import scala.util.Try

case class URIOps(uri: URI) {

  def + (uri2: URI): URI = uri.resolve(uri2)
  def + (uri2: String): URI = this + new URI(uri2)

}
