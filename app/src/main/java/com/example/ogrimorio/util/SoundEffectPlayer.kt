package com.example.ogrimorio.util

import android.content.Context
import android.media.SoundPool
import com.example.ogrimorio.R

class SoundEffectPlayer(
    context: Context
) {

    private val soundPool = SoundPool.Builder()
        .setMaxStreams(3)
        .build()

    private val diceRoll = soundPool.load(
        context,
        R.raw.roll_dice_sound,
        1
    )

    fun playRollDice() {
        soundPool.play(
            diceRoll,
            1f,
            1f,
            1,
            0,
            1f
        )
    }

    fun release(){
        soundPool.release()
    }
}