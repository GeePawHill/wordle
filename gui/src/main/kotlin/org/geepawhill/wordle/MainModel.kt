package org.geepawhill.wordle

class MainModel {
    val dataset = Dataset()
    val datasetModel = DatasetModel()
    val firstSolverModel = FirstSolverModel(dataset)
    val maxInfoModel = MaxInfoModel(dataset)


    init {
        datasetModel.load(Dataset())
    }
}