package org.geepawhill.wordle

class MainModel {
    val datasetModel = DatasetModel()

    init {
        datasetModel.load(Dataset())
    }
}