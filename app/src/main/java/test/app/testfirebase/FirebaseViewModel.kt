package test.app.testfirebase

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class FirebaseViewModel(application: Application) :AndroidViewModel(application) {
    private val repository : FirebaseRepository = FirebaseRepository()
    fun uploadItem(testModel: TestModel) {
        repository.uploadItem(testModel)
    }
}