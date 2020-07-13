/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics

import co.aplicared.jvm.juego.arbucies.graphics.draw.Sprites
import kotlin.random.Random

class Screen(private val width: Int, private val height: Int) {
    val mapSize = 8
    val mapSizeMask = mapSize - 1
    var pixels = IntArray(width * height)
    var tiles = IntArray(mapSize * mapSize)
    
    private val random = Random
    
    init {
        for (i in 0 until mapSize * mapSize) {
            tiles[i] = random.nextInt(0xffffff)
        }
    }
    
    fun render(xOffset: Int, yOffset: Int) {
        for (y in 0 until height) {
            var yy = y + yOffset
            for (x in 0 until width) {
                var xx = x + xOffset
                val tileIndex = ((xx shr 4) and mapSizeMask) + ((yy shr 4) and mapSizeMask) * mapSize
                pixels[x + y * width] = Sprites.GRASS.get().pixels[(x and 15) + (y and 15) * Sprites.GRASS.get().size]
            }
        }
    }
    
    fun clear() {
        for (i in pixels.indices) {
            pixels[i] = 0
        }
    }
}