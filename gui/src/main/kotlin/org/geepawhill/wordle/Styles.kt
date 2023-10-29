package org.geepawhill.wordle

import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.text.Font


class Styles {

    companion object {
        val headerBackground = Background(BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))
        val lossBackground = Background(BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY))
        val winBackground = Background(BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY))
        val textFont = Font(20.0)
    }
}