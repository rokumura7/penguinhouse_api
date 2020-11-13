package utils

trait Closable {
  type ClosableT = { def close(): Unit }
  def using[A <: ClosableT, B]( source: A )( func: A => B ): B = try func(source) finally source.close()
}
