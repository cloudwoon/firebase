package test.app.testfirebase

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepository {

    private val firestore = FirebaseFirestore.getInstance()

    fun uploadItem(testModel: TestModel) {
        firestore.collection("Model").document(testModel.name.toString()).set(testModel)
    }
}