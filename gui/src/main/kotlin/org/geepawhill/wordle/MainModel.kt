package org.geepawhill.wordle

class MainModel {
    val dataset = Dataset()
    val datasetModel = DatasetModel()
    val firstSolverModel = FirstSolverModel(dataset)


    init {
        datasetModel.load(Dataset())
    }
}